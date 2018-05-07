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
 * @author utopia
 */
public class PotLuckCell extends InsideCell {
    
    public PotLuckCell(
            Dimension boardSize, 
            float boardProportion, 
            InsideCell.Side side, 
            int rowIndex) {
        super(boardSize, boardProportion, side, rowIndex);
    }
    
    @Override
    protected void renderContents(Graphics2D g2) {
        g2.setFont(new Font("Monaco", Font.PLAIN, 8));
        g2.drawString("Pot", 4, dimension.height * 0.25f);
        g2.drawString("Luck", 4, dimension.height * 0.25f + 10.0f);
    }
}
