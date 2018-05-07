/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import zytom.proptycoon.controller.game.BoardController;
import zytom.proptycoon.view.GameFrame;
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
    
    private ArrayList<StreetPropertyCell> streetPropertyCells;
    private ArrayList<StationPropertyCell> stationPropertyCells;
    private ArrayList<UtilityPropertyCell> utilityPropertyCells;
    
    private ArrayList<OpportunityKnocksCell> opportunityKnocksCells;
    private ArrayList<PotLuckCell> potLuckCells;
    
    private IncomeTaxCell incomeTaxCell;
    private SuperTaxCell superTaxCell;
    
    private BoardCamera camera;
    
    private final GameFrame parent;
    
    public BoardCanvas (GameFrame parent, BoardController boardController) {
        this.parent = parent;
        setSize(720, 720);
        thread = new Thread(this);
        thread.start();
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
            repaint();
            frames ++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
                updates = 0;
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                //Do nothing
                System.out.println("Interrupted");
            }
        }
    }
    
    private void tick() {
        
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
        
        camera.applyTransform(g2);
        
        //Render stuff.
        renderCells(g);
        
        camera.clearTransform(g2);
    }
}
