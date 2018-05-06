/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author Tom
 */
public class FreeParkingCell extends CornerCell {
    public FreeParkingCell(Dimension boardSize, float boardProportion) {
        super(
                boardSize,
                boardProportion,
                CornerCell.Corner.TOPLEFT
        );
    }
    
    @Override
    public void renderContents(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.setFont(new Font("Arial", Font.PLAIN, 32));
        g2.drawString("FREE\nPARKING", 18, 48);
    }
}
