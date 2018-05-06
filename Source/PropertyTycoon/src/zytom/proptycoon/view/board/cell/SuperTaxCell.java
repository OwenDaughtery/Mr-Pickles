/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author utopia
 */
public class SuperTaxCell extends InsideCell {
    private final String price;
    
    public SuperTaxCell(
            Dimension boardSize, 
            float boardProportion, 
            InsideCell.Side side, 
            int rowIndex,
            String price) {
        super(boardSize, boardProportion, side, rowIndex);
        this.price = price;
    }
    
    @Override
    protected void renderContents(Graphics2D g2) {
        g2.setFont(new Font("Arial", Font.PLAIN, 8));
        g2.drawString("Super", 4, dimension.height * 0.25f);
        g2.drawString("Tax", 4, dimension.height * 0.4f);
        g2.drawString("Price: " + price, 4, dimension.height * 0.85f);
    }
}
