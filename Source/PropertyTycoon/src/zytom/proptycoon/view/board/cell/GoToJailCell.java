/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Tom
 */
public class GoToJailCell extends CornerCell{
    public GoToJailCell(Dimension boardSize, float boardProportion) {
        super(
                boardSize,
                boardProportion,
                CornerCell.Corner.TOPRIGHT
        );
    }
    
    @Override
    public void renderContents(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.setFont(new Font("Arial", Font.PLAIN, 32));
        g2.drawString("GO TO\nJAIL", 18, 48);
    }
}
