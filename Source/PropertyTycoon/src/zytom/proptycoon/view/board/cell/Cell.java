/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Tom
 */
public abstract class Cell {
    public enum Orientation { UP, LEFT, DOWN, RIGHT };
    
    protected final Dimension dimension;
    protected final Point position;
    private final Orientation orientation;
    
    
    public Cell(Dimension dimension, Point position, Orientation orientation) {
        this.dimension = dimension;
        this.position = position;
        this.orientation = orientation;
    }
    
    protected abstract void renderContents(Graphics2D g2);
    
    public static double getRadians(Orientation orientation) {
        switch (orientation) {
            case UP:
                return 0;
            case LEFT:
                return Math.PI / 2;
            case DOWN:
                return Math.PI;
            case RIGHT:
                return 3 * Math.PI / 2;
        }
        return 0;
    }
    
    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        
        // Get the current transform
        AffineTransform saveAT = g2.getTransform();
        
        g2.translate(position.x, position.y);
        g2.rotate(
                getRadians(orientation)
        );
        g2.setColor(Color.black);
        g2.drawRect(
                0, 0,
                dimension.width,
                dimension.height
        );
        renderContents(g2);
        
        // Restore original transform
        g2.setTransform(saveAT);
    }
}
