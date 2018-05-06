/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import zytom.proptycoon.view.board.cell.FreeParkingCell;
import zytom.proptycoon.view.board.cell.GoCell;
import zytom.proptycoon.view.board.cell.GoToJailCell;
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
    
    private boolean running;
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
    
    public BoardCanvas (
            ArrayList<String> streetNames,
            ArrayList<String> stationNames,
            ArrayList<String> utilityNames,
            ArrayList<String> streetPrices,
            ArrayList<String> stationPrices,
            ArrayList<String> utilityPrices
    ) {
        setSize(720, 720);
        thread = new Thread(this);
        thread.start();
        initCells(
                streetNames,
                stationNames,
                utilityNames,
                streetPrices,
                stationPrices,
                utilityPrices
        );
    }
    
    private void initCells (
            ArrayList<String> streetNames,
            ArrayList<String> stationNames,
            ArrayList<String> utilityNames,
            ArrayList<String> streetPrices,
            ArrayList<String> stationPrices,
            ArrayList<String> utilityPrices
    ) {
        Dimension boardSize = new Dimension(getWidth(), getHeight());
        goCell = new GoCell(boardSize, CELL_PROPORTION);
        jailCell = new JailCell(boardSize, CELL_PROPORTION);
        freeParkingCell = new FreeParkingCell(boardSize, CELL_PROPORTION);
        goToJailCell = new GoToJailCell(boardSize, CELL_PROPORTION);
        
        this.streetPropertyCells = new ArrayList<>();
        this.stationPropertyCells = new ArrayList<>();
        this.utilityPropertyCells = new ArrayList<>();
        
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
    }
    
    private void initStreetCells(
            Dimension boardSize,
            ArrayList<String> streetNames,
            ArrayList<String> streetPrices
    ) {
        int[] streetPositions = {
            0, 2, 5, 7, 8,
            0, 2, 3, 5, 7, 8,
            0, 2, 3, 5, 6, 8,
            0, 1, 3, 6, 8
        };
        Color[] streetColours = {
            Color.GRAY, Color.GRAY,
            Color.CYAN, Color.CYAN, Color.CYAN,
            Color.PINK, Color.PINK, Color.PINK, 
            Color.ORANGE, Color.ORANGE, Color.ORANGE, 
            Color.RED, Color.RED, Color.RED,
            Color.YELLOW, Color.YELLOW, Color.YELLOW,
            Color.GREEN, Color.GREEN, Color.GREEN,
            Color.BLUE, Color.BLUE
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
        int[] positions = {
            1, 7
        };
        Side[] sides = {
            Side.BOTTOM, Side.LEFT, Side.TOP, Side.RIGHT
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
    
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double numberOfTicks = 60.0;
        double ns = 1000000000 / numberOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running) {
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
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        //Overlay background.
        g.setColor(Color.white);
        g.fillRect(
                0, 
                0, 
                getWidth(), 
                getHeight()
        );
        
        //Render stuff.
        renderCells(g);
    }
}
