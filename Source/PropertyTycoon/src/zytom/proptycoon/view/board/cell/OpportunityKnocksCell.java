/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author utopia
 */
public class OpportunityKnocksCell extends InsideCell {
    
    private BufferedImage image;
    
    public OpportunityKnocksCell(
            Dimension boardSize, 
            float boardProportion, 
            InsideCell.Side side, 
            int rowIndex) {
        super(boardSize, boardProportion, side, rowIndex);
        try {
            this.image = ImageIO.read(new File("./resources/images/cells/question_mark.png"));
        } catch (IOException ex) {
            Logger.getLogger(OpportunityKnocksCell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void renderContents(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.50, 0.50);
        g2.drawImage(image, 15, 45, null);
        g2.setTransform(at);
    }
}