/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JPanel;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.view.board.cell.FreeParkingCell;
import zytom.proptycoon.view.board.cell.GoCell;
import zytom.proptycoon.view.board.cell.GoToJailCell;
import zytom.proptycoon.view.board.cell.IncomeTaxCell;
import zytom.proptycoon.view.board.cell.InsideCell;
import zytom.proptycoon.view.board.cell.InsideCell.Side;
import zytom.proptycoon.view.board.cell.JailCell;
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
    
    private IncomeTaxCell incomeTaxCell;
    private SuperTaxCell superTaxCell;
    
    public BoardCanvas(
            
    ) {
        setSize(720, 720);
        thread = new Thread(this);
        thread.start();
    }
    
    private void initCells() {
        Dimension boardSize = new Dimension(getWidth(), getHeight());
        goCell = new GoCell(boardSize, CELL_PROPORTION);
        jailCell = new JailCell(boardSize, CELL_PROPORTION);
        freeParkingCell = new FreeParkingCell(boardSize, CELL_PROPORTION);
        goToJailCell = new GoToJailCell(boardSize, CELL_PROPORTION);
        
        streetPropertyCells = new ArrayList<>();
        stationPropertyCells = new ArrayList<>();
        utilityPropertyCells = new ArrayList<>();
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
