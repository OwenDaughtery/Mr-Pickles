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
 * @author utopia
 */
public class StationPropertyCell extends InsideCell {
    
    private final String title;
    private final String price;
    
    
    private final ArrayList<String> lines;
    private static final int CHAR_LIMIT = 8;
    
    public StationPropertyCell(
            Dimension boardSize, 
            float boardProportion, 
            InsideCell.Side side, 
            int rowIndex,
            String title,
            String price) {
        super(boardSize, boardProportion, side, rowIndex);
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
        g2.setFont(new Font("Monaco", Font.PLAIN, 8));
        
        float yPos = dimension.height * 0.25f;
        for (int i=0; i<lines.size(); i++) {
            g2.drawString(lines.get(i), 6, yPos);
            yPos += 10.0f;
        }
        
        g2.drawString("Price: " + price, 6, dimension.height * 0.85f);
    }
}
