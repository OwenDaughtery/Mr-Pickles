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
public class IncomeTaxCell extends InsideCell {
    private final int price;
    
    public IncomeTaxCell(
            Dimension boardSize, 
            float boardProportion, 
            InsideCell.Side side, 
            int rowIndex,
            int price) {
        super(boardSize, boardProportion, side, rowIndex);
        this.price = price;
    }
    
    @Override
    protected void renderContents(Graphics2D g2) {
        g2.setFont(new Font("Arial", Font.PLAIN, 8));
        g2.drawString("Income", 4, dimension.height * 0.25f);
        g2.drawString("Tax", 4, dimension.height * 0.4f);
        g2.drawString("Price: " + price, 4, dimension.height * 0.85f);
    }
}
