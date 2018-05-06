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
public class UtilityPropertyCell extends InsideCell {
    
    private final String title;
    private final int price;
    
    public UtilityPropertyCell(
            Dimension boardSize, 
            float boardProportion, 
            InsideCell.Side side, 
            int rowIndex,
            String title,
            int price) {
        super(boardSize, boardProportion, side, rowIndex);
        this.title = title;
        this.price = price;
    }
    
    @Override
    protected void renderContents(Graphics2D g2) {
        g2.setFont(new Font("Arial", Font.PLAIN, 8));
        g2.drawString(title, 4, dimension.height * 0.25f);
        g2.drawString("Price: " + price, 4, dimension.height * 0.85f);
    }
}
