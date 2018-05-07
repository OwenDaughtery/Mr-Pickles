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
    private final JPanel panel;
    private final Point position;
    private final Dimension viewport;
    private AffineTransform at;
    private static final float SCALE_FACTOR = 0.5f;
    private boolean isZoomed;
    private static final double SPEED = 120.0 / 60.0;
    private boolean[] isMoving = { false, false, false, false }; //Right, Up, Left, Down.
    
    
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
        this.isZoomed = true;
    }
    
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
    
    public enum Direction { RIGHT, UP, LEFT, DOWN };
    
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
            velX /= dist;
            velY /= dist;
            //Multiply by speed.
            velX *= SPEED;
            velY *= SPEED;
        }
        
        //Move camera based on velocity.
        this.position.x += velX;
        this.position.y += velY;
        
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
    
    public void clearTransform(Graphics2D g2) {
        g2.setTransform(at);
    }
    
    
}
