/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class StreetPropertyCell extends InsideCell {
    
    private final Color colour;
    private final String title;
    private final String price;
    
    private final ArrayList<String> lines;
    private static final int CHAR_LIMIT = 8;
    
    public StreetPropertyCell(
            Dimension boardSize, 
            float boardProportion, 
            Side side, 
            int rowIndex,
            Color colour,
            String title,
            String price) {
        super(boardSize, boardProportion, side, rowIndex);
        this.colour = colour;
        this.title = title;
        this.price = price;
        
        lines = new ArrayList<>();
        String remainder = this.title;
        while (remainder.length() > CHAR_LIMIT) {
            lines.add(remainder.substring(0, CHAR_LIMIT));
            remainder = remainder.substring(CHAR_LIMIT);
        }
        lines.add(remainder);
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
        
        float yPos = dimension.height * 0.325f;
        for (int i=0; i<lines.size(); i++) {
            g2.drawString(lines.get(i), 4, yPos);
            yPos += 10.0f;
        }
        
        g2.drawString("Price: " + price, 4, dimension.height * 0.85f);
    }
}
