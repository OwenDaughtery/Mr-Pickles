/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Canvas;
import java.awt.Dimension;

/**
 *
 * @author utopia
 */
public class BoardCamera {
    private Canvas canvas;
    private Dimension viewport;
    
    public BoardCamera(Canvas canvas, Dimension viewport) {
        this.canvas = canvas;
        this.viewport = viewport;
    }
    
}
