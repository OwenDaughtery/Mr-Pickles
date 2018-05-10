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
import java.util.ArrayList;
import zytom.proptycoon.view.board.PlayerView;

/**
 * Draws a simple rectangle.
 * Is extendable to allow rendering of stuff inside.
 * Is able to be rotated based on orientation and 
 * apply rotation to rendered contents.
 * 
 * @author Tom
 */
public abstract class Cell {
    /** Describes which wya the cell is rotated */
    public enum Orientation { UP, LEFT, DOWN, RIGHT };
    
    /** Width & height of cell. */
    protected final Dimension dimension;
    /** Position of cell */
    protected final Point position;
    /** Which way it's rotated */
    private final Orientation orientation;
    /** The player/token views on this cell */
    private final ArrayList<PlayerView> tokenViews;
    
    /**
     * 
     * @param dimension
     * @param position
     * @param orientation 
     */
    public Cell(Dimension dimension, Point position, Orientation orientation) {
        this.dimension = dimension;
        this.position = position;
        this.orientation = orientation;
        tokenViews = new ArrayList<>();
    }
    
    /**
     * Remove all the player/token views in this cell.
     */
    public void clearTokenViews() {
        tokenViews.clear();
    }
    
    /**
     * Add a token ivew to this cell.
     * @param tokenView 
     */
    public void addTokenView(PlayerView tokenView) {
        tokenViews.add(tokenView);
    }
    
    /**
     * Remove a specific token/player view from this cell.
     * @param tokenView 
     */
    public void removeTokenView(PlayerView tokenView) {
        tokenViews.remove(tokenView);
    }
    
    /**
     * @param tokenView
     * @return True if contains a specific tokenview, false if not.
     */
    public boolean containsTokenView(PlayerView tokenView) {
        return tokenViews.contains(tokenView);
    }
    
    /**
     * Render the contents of this cell.
     * (Will render whatever the subtype of this cell chooses to,
     * whilst applying relevant transformations.)
     * @param g2 
     */
    protected abstract void renderContents(Graphics2D g2);
    
    /**
     * Convert an orientation to radians.
     * @param orientation
     * @return radians.
     */
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
    
    /**
     * Render player/token views in this cell.
     * @param g2 gfx context
     */
    private void renderTokens(Graphics2D g2) {
        for (PlayerView token : tokenViews) {
            token.render(g2);
        }
    }
    
    /**
     * Render the cell border,
     * player/token views,
     * and extended contents,
     * all whilst applying transformations.
     * @param g gfx context.
     */
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
        renderTokens(g2);
        
        
        // Restore original transform
        g2.setTransform(saveAT);
    }
}
