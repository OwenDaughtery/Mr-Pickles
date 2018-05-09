/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;
import zytom.proptycoon.Common.TokenType;
import zytom.proptycoon.controller.game.BoardController;
import zytom.proptycoon.controller.game.PlayerController;
import zytom.proptycoon.view.GameFrame;
import zytom.proptycoon.view.board.cell.Cell;
import zytom.proptycoon.view.board.cell.FreeParkingCell;
import zytom.proptycoon.view.board.cell.GoCell;
import zytom.proptycoon.view.board.cell.GoToJailCell;
import zytom.proptycoon.view.board.cell.InJailCell;
import zytom.proptycoon.view.board.cell.IncomeTaxCell;
import zytom.proptycoon.view.board.cell.InsideCell.Side;
import zytom.proptycoon.view.board.cell.JailCell;
import zytom.proptycoon.view.board.cell.OpportunityKnocksCell;
import zytom.proptycoon.view.board.cell.PotLuckCell;
import zytom.proptycoon.view.board.cell.StationPropertyCell;
import zytom.proptycoon.view.board.cell.StreetPropertyCell;
import zytom.proptycoon.view.board.cell.SuperTaxCell;
import zytom.proptycoon.view.board.cell.UtilityPropertyCell;
//import zytom.proptycoon.view.dice.DiceCell;

/**
 *
 * @author Tom
 */
public class BoardCanvas extends JPanel implements Runnable {
    
    /**
     * 
     */
    public static final float CELL_PROPORTION = 0.125f;
    
    private boolean running = true;
    private final Thread thread;
    
    private GoCell goCell;
    private JailCell jailCell;
    private FreeParkingCell freeParkingCell;
    private GoToJailCell goToJailCell;
    private InJailCell inJailCell;
    
    private ArrayList<StreetPropertyCell> streetPropertyCells;
    private ArrayList<StationPropertyCell> stationPropertyCells;
    private ArrayList<UtilityPropertyCell> utilityPropertyCells;
    
    private ArrayList<OpportunityKnocksCell> opportunityKnocksCells;
    private ArrayList<PotLuckCell> potLuckCells;
    
    private IncomeTaxCell incomeTaxCell;
    private SuperTaxCell superTaxCell;
    
    private BoardCamera camera;
    
    private final GameFrame parent;
    
    private PotLuckDeck potLuckDeckCell;
    private OpportunityKnocksDeck opportunityKnocksDeckCell;
    
    private LogoView logoView;
    
    private LeftDie leftDie;
    private RightDie rightDie;
    
    private final ArrayList<PlayerView> playerViews;
    private final ArrayList<PlayerController> playerControllers;
    
    private final RollDiceButton rollDiceButton;
    
    public BoardCanvas (
            GameFrame parent, 
            BoardController boardController
    ) {
        this.parent = parent;
        setSize(720, 720);
        thread = new Thread(this);
        
        this.playerControllers = null;
        
        playerViews = new ArrayList<>();
        playerViews.add(new PlayerView(TokenType.BOOT));
        playerViews.add(new PlayerView(TokenType.SMARTPHONE));
        playerViews.add(new PlayerView(TokenType.GOBLET));
        playerViews.add(new PlayerView(TokenType.HATSTAND));
        playerViews.add(new PlayerView(TokenType.CAT));
        playerViews.add(new PlayerView(TokenType.SPOON));
        initCells(
                boardController.getStreetNames(),
                boardController.getStationNames(),
                boardController.getUtilityNames(),
                boardController.getStreetPrices(),
                boardController.getStationPrices(),
                boardController.getUtilityPrices(),
                boardController.getIncomeTaxPrice(),
                boardController.getSuperTaxPrice()
        );
        camera = new BoardCamera(this);
        
        //Give camera controller instance of camera view.
        boardController
                .getCameraController()
                .setCameraView(camera);
        
        //Attach camera controller to this panel.
        //(As a key listener).
        this.addKeyListener(
                boardController.getCameraController()
        );
        this.setFocusTraversalKeysEnabled(false);
        this.setFocusable(true);
        
        rollDiceButton = new RollDiceButton();
        this.add(rollDiceButton);
        
        
        thread.start();
    }
    
    private void clearPlayerTokens() {
        for(Cell cell : this.getCells()) {
            cell.clearTokenViews();
        }
    }
    
    private void removePlayerToken(PlayerView playerView) {
        for(Cell cell : this.getCells()) {
            if (cell.containsTokenView(playerView))
                cell.removeTokenView(playerView);
        }
    }
    
    private void addPlayerToken(PlayerView playerView, int cellIndex) {
        this.getCells().get(cellIndex).addTokenView(playerView);
    }
    
    public void movePlayerToken(TokenType tokenType, int newCellIndex) { 
        PlayerView playerView = null;        
        for (PlayerView p : playerViews) {
            if (p.getTokenType() == tokenType) {
                playerView = p;
            }
        }
        removePlayerToken(playerView);
        addPlayerToken(playerView, newCellIndex);
    }
    
    private void updatePlayerTokenPosition(PlayerView tokenView, int newIndex) {
        for(Cell cell : this.getCells()) {
            if (cell.containsTokenView(tokenView))
                cell.removeTokenView(tokenView);
            break;
        }
        this.getCells().get(newIndex).addTokenView(tokenView);
    }
    
    private void initCells (
            ArrayList<String> streetNames,
            ArrayList<String> stationNames,
            ArrayList<String> utilityNames,
            ArrayList<String> streetPrices,
            ArrayList<String> stationPrices,
            ArrayList<String> utilityPrices,
            String incomeTaxPrice,
            String superTaxPrice
    ) {
        Dimension boardSize = new Dimension(getWidth(), getHeight());
        goCell = new GoCell(boardSize, CELL_PROPORTION);
        jailCell = new JailCell(boardSize, CELL_PROPORTION);
        freeParkingCell = new FreeParkingCell(boardSize, CELL_PROPORTION);
        goToJailCell = new GoToJailCell(boardSize, CELL_PROPORTION);
        initStreetCells(
                boardSize,
                streetNames,
                streetPrices
        );
        initStationCells(
                boardSize,
                stationNames,
                stationPrices
        );
        initUtilityCells(
                boardSize,
                utilityNames,
                utilityPrices
        );
        initPotLuckCells(
                boardSize
        );
        initOpportunityKnocksCells(
                boardSize
        );
        incomeTaxCell = new IncomeTaxCell(
                boardSize, 
                CELL_PROPORTION,
                Side.BOTTOM,
                3,
                incomeTaxPrice
        );
        superTaxCell = new SuperTaxCell(
                boardSize, 
                CELL_PROPORTION,
                Side.RIGHT,
                7,
                superTaxPrice
        );
        inJailCell = new InJailCell(
                boardSize, 
                CELL_PROPORTION
        );
        potLuckDeckCell = new PotLuckDeck(
                boardSize
        );
        opportunityKnocksDeckCell = new OpportunityKnocksDeck(
                boardSize
        );
        logoView = new LogoView(
                boardSize
        );
        leftDie = new LeftDie(
                boardSize
        );
        rightDie = new RightDie(
                boardSize
        );
    }
    
    private ArrayList<Cell> getCells() {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(goCell);
        cells.add(jailCell);
        cells.add(inJailCell);
        cells.add(goToJailCell);
        cells.add(freeParkingCell);
        cells.addAll(this.streetPropertyCells);
        cells.addAll(this.stationPropertyCells);
        cells.addAll(this.utilityPropertyCells);
        cells.addAll(this.potLuckCells);
        cells.addAll(this.opportunityKnocksCells);
        cells.add(incomeTaxCell);
        cells.add(superTaxCell);
        return cells;
    }
    
    private void initStreetCells(
            Dimension boardSize,
            ArrayList<String> streetNames,
            ArrayList<String> streetPrices
    ) {
        
        this.streetPropertyCells = new ArrayList<>();
        int[] streetPositions = {
            0, 2, 5, 7, 8,
            0, 2, 3, 5, 7, 8,
            0, 2, 3, 5, 6, 8,
            0, 1, 3, 6, 8
        };
        Color[] streetColours = {
            Color.getHSBColor(0.11f,0.9f,0.65f), Color.getHSBColor(0.11f,0.9f,0.65f),
            Color.getHSBColor(0.5f,1.0f,0.9f), Color.getHSBColor(0.5f,1.0f,0.9f), Color.getHSBColor(0.5f,1.0f,0.9f),
            Color.getHSBColor(0.75f,0.9f,0.95f), Color.getHSBColor(0.75f,0.9f,0.95f), Color.getHSBColor(0.75f,0.9f,0.95f),
            Color.getHSBColor(0.1f,0.9f,0.95f), Color.getHSBColor(0.1f,0.9f,0.95f), Color.getHSBColor(0.1f,0.9f,0.95f),
            Color.getHSBColor(0.0f,0.9f,0.95f), Color.getHSBColor(0.0f,0.9f,0.95f), Color.getHSBColor(0.0f,0.9f,0.95f),
            Color.getHSBColor(0.15f,0.95f,1.0f), Color.getHSBColor(0.15f,0.95f,1.0f), Color.getHSBColor(0.15f,0.95f,1.0f),
            Color.getHSBColor(0.3f,0.95f,0.8f), Color.getHSBColor(0.3f,0.95f,0.8f), Color.getHSBColor(0.3f,0.95f,0.8f),
            Color.getHSBColor(0.7f,0.95f,1.0f), Color.getHSBColor(0.7f,0.95f,1.0f)
        };
        for (int i=0; i<22; i++) {
            Side side;
            if (i<5) side = Side.BOTTOM;
            else if (i<11) side = Side.LEFT;
            else if (i<17) side = Side.TOP;
            else side = Side.RIGHT;
            int position = streetPositions[i];
            Color colour = streetColours[i];
            this.streetPropertyCells.add(
                    new StreetPropertyCell(
                            boardSize,
                            CELL_PROPORTION,
                            side,
                            position,
                            colour,
                            streetNames.get(i),
                            streetPrices.get(i)
                    )
            );
        }
    }
    
    private void initStationCells (
            Dimension boardSize,
            ArrayList<String> stationNames,
            ArrayList<String> stationPrices
    ) {
        this.stationPropertyCells = new ArrayList<>();
        Side[] sides = {
            Side.BOTTOM, Side.LEFT, Side.TOP, Side.RIGHT
        };
        for (int i=0; i<4; i++) {
            this.stationPropertyCells.add(
                    new StationPropertyCell(
                            boardSize,
                            CELL_PROPORTION,
                            sides[i],
                            4,
                            stationNames.get(i),
                            stationPrices.get(i)
                    )
            );
        }
    }
    
    private void initUtilityCells (
            Dimension boardSize,
            ArrayList<String> utilityNames,
            ArrayList<String> utilityPrices) {
        this.utilityPropertyCells = new ArrayList<>();
        int[] positions = {
            1, 7
        };
        Side[] sides = {
             Side.LEFT, Side.TOP
        };
        for (int i=0; i<2; i++) {
            this.utilityPropertyCells.add(
                    new UtilityPropertyCell(
                            boardSize,
                            CELL_PROPORTION,
                            sides[i],
                            positions[i],
                            utilityNames.get(i),
                            utilityPrices.get(i)
                    )
            );
        }
    }
    
    private void initPotLuckCells(Dimension boardSize) {
        potLuckCells = new ArrayList<>();
        int[] positions = {
            1, 6, 2
        };
        Side[] sides = {
            Side.BOTTOM, Side.LEFT, Side.RIGHT
        };
        for (int i=0; i<3; i++) {
            this.potLuckCells.add(
                    new PotLuckCell(
                            boardSize,
                            CELL_PROPORTION,
                            sides[i],
                            positions[i]
                    )
            );
        }
    }
    
    private void initOpportunityKnocksCells(Dimension boardSize) {
        opportunityKnocksCells = new ArrayList<>();
        int[] positions = {
            6, 1, 5
        };
        Side[] sides = {
            Side.BOTTOM, Side.TOP, Side.RIGHT
        };
        for (int i=0; i<3; i++) {
            this.opportunityKnocksCells.add(
                    new OpportunityKnocksCell(
                            boardSize,
                            CELL_PROPORTION,
                            sides[i],
                            positions[i]
                    )
            );
        }
    }
    
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double numberOfTicks = 60.0;
        double ns = 1000000000 / numberOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        
        while(this.running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            if (System.currentTimeMillis() - timer > 1000) {
                this.parent.setTitle("FPS: " + frames + " | Updates:" + updates);
                timer += 1000;
                frames = 0;
                updates = 0;
            }
            repaint();
            frames ++;
            try {
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                //Do nothing
                System.out.println("Interrupted");
            }
        }
    }
    
    private void tick() {
        if (camera != null)
            camera.update();
    }
    
    private void renderCells(Graphics g) {
        goCell.render(g);
        jailCell.render(g);
        freeParkingCell.render(g);
        goToJailCell.render(g);
        
        for (StreetPropertyCell cell : streetPropertyCells) {
            cell.render(g);
        }
        for (StationPropertyCell cell : stationPropertyCells) {
            cell.render(g);
        }
        for (UtilityPropertyCell cell : utilityPropertyCells) {
            cell.render(g);
        }
        for (OpportunityKnocksCell cell : opportunityKnocksCells) {
            cell.render(g);
        }for (PotLuckCell cell : potLuckCells) {
            cell.render(g);
        }
        
        incomeTaxCell.render(g);
        superTaxCell.render(g);
        inJailCell.render(g);
        potLuckDeckCell.render(g);
        opportunityKnocksDeckCell.render(g);
        logoView.render(g);
        leftDie.render(g);
        rightDie.render(g);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        //Overlay background.
        g.setColor(Color.getHSBColor(0.13f,0.12f,1.0f));
        g.fillRect(
                0, 
                0, 
                getWidth(), 
                getHeight()
        );
        
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHint(
            RenderingHints.KEY_FRACTIONALMETRICS,
            RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        
        camera.applyTransform(g2);
        
        //Render stuff.
        renderCells(g);
        
        camera.clearTransform(g2);
    }
}
