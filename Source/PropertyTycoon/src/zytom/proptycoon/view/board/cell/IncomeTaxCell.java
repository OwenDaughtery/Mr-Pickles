/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

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
 * @author Tom
 */
public class IncomeTaxCell extends InsideCell {
    
    private BufferedImage image;
    
    private final String price;
    
    public IncomeTaxCell(
            Dimension boardSize, 
            float boardProportion, 
            InsideCell.Side side, 
            int rowIndex,
            String price) {
        super(boardSize, boardProportion, side, rowIndex);
        this.price = price;
        try {
            this.image = ImageIO.read(new File("./resources/images/cells/income_tax.png"));
        } catch (IOException ex) {
            Logger.getLogger(IncomeTaxCell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void renderContents(Graphics2D g2) {
        g2.setFont(new Font("Monaco", Font.PLAIN, 8));
        g2.drawString("Income Tax", 4, dimension.height * 0.25f);
        g2.drawString("Price:  " + price, 4, dimension.height * 0.85f);
        AffineTransform at = g2.getTransform();
        g2.scale(0.45, 0.45);
        g2.drawImage(image, 20, 60, null);
        g2.setTransform(at);
    }
}
