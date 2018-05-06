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
public class StreetPropertyCell extends InsideCell {
    
    private final Color colour;
    private final String title;
    private final int price;
    
    public StreetPropertyCell(
            Dimension boardSize, 
            float boardProportion, 
            Side side, 
            int rowIndex,
            Color colour,
            String title,
            int price) {
        super(boardSize, boardProportion, side, rowIndex);
        this.colour = colour;
        this.title = title;
        this.price = price;
    }

    @Override
    protected void renderContents(Graphics2D g2) {
        g2.setColor(colour);
        g2.fillRect(
                0, 
                0, 
                dimension.width, 
                Math.round((float)dimension.height * 0.2f)
        );
        g2.setColor(Color.black);
        g2.drawRect(
                0, 
                0, 
                dimension.width, 
                Math.round((float)dimension.height * 0.2f)
        );
        g2.setFont(new Font("Arial", Font.PLAIN, 8));
        g2.drawString(title, 4, dimension.height * 0.5f);
        g2.drawString("Price: " + price, 4, dimension.height * 0.85f);
    }
}
