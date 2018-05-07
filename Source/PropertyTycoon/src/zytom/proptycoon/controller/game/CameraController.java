/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.controller.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import zytom.proptycoon.view.board.BoardCamera;

/**
 *
 * @author utopia
 */
public class CameraController implements KeyListener {
    private BoardCamera camera;
    
    
    public CameraController() {
        this.camera = null;
    }
    
    public void setCameraView(BoardCamera camera) {
        this.camera = camera;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if (this.camera == null)
            return;
    }

    private enum Direction { LEFT, RIGHT, UP, DOWN }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (this.camera == null)
            return;        
        
        switch(e.getKeyCode()) {
            case KeyEvent.VK_Z:
                camera.toggleZoom();
                break;
            case KeyEvent.VK_UP:
                camera.startMoving(BoardCamera.Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                camera.startMoving(BoardCamera.Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                camera.startMoving(BoardCamera.Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                camera.startMoving(BoardCamera.Direction.RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (this.camera == null)
            return;
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                camera.stopMoving(BoardCamera.Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                camera.stopMoving(BoardCamera.Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                camera.stopMoving(BoardCamera.Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                camera.stopMoving(BoardCamera.Direction.RIGHT);
                break;
        }
    }
    
}
