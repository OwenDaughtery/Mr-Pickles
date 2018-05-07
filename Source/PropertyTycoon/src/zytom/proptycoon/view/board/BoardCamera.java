/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

/**
 *
 * @author utopia
 */
public class BoardCamera {
    /**
     * Reference to the board canvas panel.
     */
    private final JPanel panel;
    
    /**
     * The position (displacement from the origin) of the camera.
     */
    private final Point position;
    
    /**
     * The current viewport that the camera is showing.
     */
    private final Dimension viewport;
    
    /**
     * Keep track of the transform that the camera applies.
     */
    private AffineTransform at;
    
    /**
     * What proportion of the full-view a zoomed-in viewport shows.
     */
    private static final float SCALE_FACTOR = 0.5f;
    
    /**
     * Whether or not the camera is zoomed in.
     */
    private boolean isZoomed;
    
    /**
     * How fast the camera moves.
     */
    private static final double SPEED = 320.0 / 60.0;
    
    /**
     * Keeps track of the directions the camera is moving in.
     */
    private final boolean[] isMoving = { false, false, false, false }; //Right, Up, Left, Down.
    
    /**
     * How far the camera can stray from the board (px).
     */
    private static final int MARGIN = 90;
    
    /**
     * Record jpanel (BoardCanvas) instance.
     * Set position to top-left of board.
     * Viewport equal to the size of the board.
     * Set zoomed state to false.
     * @param panel 
     */
    public BoardCamera(JPanel panel) {
        this.panel = panel;
        this.position = new Point(0, 0);
        this.viewport = new Dimension(this.panel.getWidth(), this.panel.getHeight());
        this.isZoomed = false;
    }   
    
    /**
     * If the camera is zoomed out, zoom in.
     */
    public void zoom() {
        if (isZoomed) return;
        this.viewport.setSize(
                new Dimension(
                        Math.round((float)this.panel.getWidth() * SCALE_FACTOR),
                        Math.round((float)this.panel.getHeight() * SCALE_FACTOR)
                )        
        );
        this.isZoomed = true;
    }
    
    /**
     * If the camera is zoomed in, zoom out.
     */
    public void unzoom() {
        if (!isZoomed) return;
        this.viewport.setSize(
                new Dimension(
                        this.panel.getWidth(),
                        this.panel.getHeight()
                )        
        );
        this.isZoomed = false;
    }
    
    /**
     * If zoomed, unzoom.
     * & Vice-versa.
     */
    public void toggleZoom() {
        if (isZoomed) 
            unzoom();
        else
            zoom();
    }
    
    /**
     * Override where the camera will be positioned.
     * @param x
     * @param y 
     */
    public void setPosition(int x, int y) {
        this.position.x = x;
        this.position.y = y;
    }
    
    /**
     * Describes a direction.
     */
    public enum Direction { RIGHT, UP, LEFT, DOWN };
    
    /**
     * Tell the camera to start moving in the specified direction.
     * (E.g. when a key is pressed.)
     * @param direction 
     */
    public void startMoving(Direction direction) {
        switch (direction) {
            case RIGHT:
                isMoving[0] = true;
                break;
            case UP:
                isMoving[1] = true;
                break;
            case LEFT:
                isMoving[2] = true;
                break;
            case DOWN:
                isMoving[3] = true;
                break;
        }
    }
    
    /**
     * Stop moving the camera in a certain direction.
     * (E.g. when a key is released.)
     * @param direction Which direction the camera should stop moving in.
     */
    public void stopMoving(Direction direction) {
        switch (direction) {
            case RIGHT:
                isMoving[0] = false;
                break;
            case UP:
                isMoving[1] = false;
                break;
            case LEFT:
                isMoving[2] = false;
                break;
            case DOWN:
                isMoving[3] = false;
                break;
        }
    }
    
    /**
     * Prevent camera from going too far away from board.
     */
    private void limitBounds() {
        int bw = panel.getWidth();
        int bh = panel.getHeight();
        int w = viewport.width;
        int h = viewport.height;
        position.x = (position.x < -MARGIN) ? -MARGIN : position.x;
        position.x = (position.x > bw + MARGIN - w) ?  bw + MARGIN - w : position.x;
        position.y = (position.y < -MARGIN) ? -MARGIN : position.y;
        position.y = (position.y > bh + MARGIN - h) ?  bh + MARGIN - h: position.y;
    }
    
    /**
     * To be called before rendering anything on board canvas.
     * @param g2 
     */
    public void applyTransform(Graphics2D g2) {
        //Work out directional vector of camera's motion.
        double velX = 0.0;
        double velY = 0.0;
        if (isMoving[0] || isMoving[1] || isMoving[2] || isMoving[3]) {
            if (isMoving[0])
                velX += 1.0;
            if (isMoving[1])
                velY -= 1.0;
            if (isMoving[2])
                velX -= 1.0;
            if (isMoving[3])
                velY += 1.0;
            //Normalise it.
            double dist = Math.sqrt(Math.pow(velX, 2) + Math.pow(velY, 2));
            if (dist != 0) {
                velX /= dist;
                velY /= dist;
                //Multiply by speed.
                velX *= SPEED;
                velY *= SPEED;
            } else {
                velX = 0.0;
                velY = 0.0;
            }
        }
        
        //Move camera based on velocity.
        this.position.x += velX;
        this.position.y += velY;
        
        //Prevent camera from going too far away from board.
        limitBounds();
        
        //Perform transform.
        at = g2.getTransform();
        double scaleFactorX = (double)this.panel.getWidth() / (float)this.viewport.width;
        double scaleFactorY = (double)this.panel.getHeight() / (float)this.viewport.height;
        g2.translate(
                -this.position.x * scaleFactorX,
                -this.position.y * scaleFactorY
        );
        if (isZoomed)
            g2.scale(
                    scaleFactorX,
                    scaleFactorY
            );
    }
    
    /**
     * To be called after rendering everything on board canvas.
     * @param g2
     */
    public void clearTransform(Graphics2D g2) {
        g2.setTransform(at);
    }
    
    
}
