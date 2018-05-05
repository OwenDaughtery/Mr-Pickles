/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Tom
 */
public abstract class Cell {
    private final Dimension dimension;
    private final Point position;
    
    public Cell(Dimension dimension, Point position) {
        this.dimension = dimension;
        this.position = position;
    }
    
    public abstract void renderContents(Graphics g);
    
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(
                position.x,
                position.y,
                dimension.width,
                dimension.height
        );
        g.translate(position.x, position.y);
        renderContents(g);
    }
}
