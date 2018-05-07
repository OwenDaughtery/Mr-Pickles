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
    private JPanel panel;
    private Point position;
    private Dimension viewport;
    private AffineTransform at;
    
    
    public BoardCamera(JPanel panel, Dimension viewport) {
        this.panel = panel;
        this.viewport = viewport;
    }
    
    public void applyTransform(Graphics2D g2) {
        at = g2.getTransform();
        g2.scale(
                (float)this.panel.getWidth() / (float)this.viewport.width,
                (float)this.panel.getHeight() / (float)this.viewport.height
        );
    }
    
    public void clearTransform(Graphics2D g2) {
        g2.setTransform(at);
    }
    
    
}
