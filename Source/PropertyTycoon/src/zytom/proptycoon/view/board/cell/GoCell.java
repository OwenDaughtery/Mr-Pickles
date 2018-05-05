/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Tom
 */
public class GoCell extends CornerCell {
    
    public GoCell(Dimension boardSize, float boardProportion) {
        super(
                boardSize,
                boardProportion,
                Corner.BOTTOMRIGHT
        );
    }
    
    @Override
    public void renderContents(Graphics g) {
        g.drawString("GO", 0, 0);
    }
}
