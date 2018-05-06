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
public class OpportunityKnocksCell extends InsideCell {
    public OpportunityKnocksCell(
            Dimension boardSize, 
            float boardProportion, 
            InsideCell.Side side, 
            int rowIndex,
            Color colour,
            String title,
            int price) {
        super(boardSize, boardProportion, side, rowIndex);
    }
    
    @Override
    protected void renderContents(Graphics2D g2) {
        g2.setFont(new Font("Arial", Font.PLAIN, 8));
        g2.drawString("Opportunity\nKnocks", 4, dimension.height * 0.25f);
    }
}