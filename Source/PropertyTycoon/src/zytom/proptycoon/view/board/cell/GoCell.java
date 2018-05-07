/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    protected void renderContents(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.setFont(new Font("Monaco", Font.PLAIN, 32));
        g2.drawString("GO", 18, 48);
    }
}
