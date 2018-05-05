/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JPanel;
import zytom.proptycoon.view.board.cell.GoCell;

/**
 *
 * @author Tom
 */
public class BoardCanvas extends JPanel implements Runnable {
    
    private boolean running;
    private final Thread thread;
    int x;
    
    private GoCell goCell;
    
    public BoardCanvas() {
        setSize(720, 720);
        x = 0;
        thread = new Thread(this);
        thread.start();
        initCells();
    }
    
    private void initCells() {
        goCell = new GoCell(
                new Dimension(getWidth(), getHeight()), 
                0.1f
        );
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
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        //Draw Here//
        g.setColor(Color.white);
        g.fillRect(
                0, 
                0, 
                getWidth(), 
                getHeight()
        );
        g.fillRect(x, 30, 50, 50);
    }
}
