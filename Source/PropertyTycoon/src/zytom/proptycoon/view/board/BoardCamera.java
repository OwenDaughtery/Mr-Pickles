/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

/**
 *
 * @author utopia
 */
public class BoardCamera {
    private final JPanel panel;
    private final Point position;
    private final Dimension viewport;
    private AffineTransform at;
    private static final float SCALE_FACTOR = 0.5f;
    private boolean isZoomed;
    
    public BoardCamera(JPanel panel) {
        this.panel = panel;
        this.position = new Point(0, 0);
        this.viewport = new Dimension(this.panel.getWidth(), this.panel.getHeight());
        this.isZoomed = false;
    }   
    
    public void zoom() {
        if (isZoomed) return;
        this.viewport.setSize(
                new Dimension(
                        Math.round((float)this.panel.getWidth() * SCALE_FACTOR),
                        Math.round((float)this.panel.getHeight() * SCALE_FACTOR)
                )        
        );
    }
    
    public void unzoom() {
        if (!isZoomed) return;
        this.viewport.setSize(
                new Dimension(
                        this.panel.getWidth(),
                        this.panel.getHeight()
                )        
        );
    }
    
    public void toggleZoom() {
        if (isZoomed) 
            unzoom();
        else
            zoom();
    }
    
    public void setPosition(int x, int y) {
        this.position.x = x;
        this.position.y = y;
    }
    
    public void applyTransform(Graphics2D g2) {
        at = g2.getTransform();
        g2.translate(
                this.position.x,
                this.position.y
        );
        if (isZoomed)
            g2.scale(
                    (float)this.panel.getWidth() / (float)this.viewport.width,
                    (float)this.panel.getHeight() / (float)this.viewport.height
            );
    }
    
    public void clearTransform(Graphics2D g2) {
        g2.setTransform(at);
    }
    
    
}
