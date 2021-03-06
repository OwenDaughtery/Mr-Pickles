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
 * @author Tom
 */
public class FreeParkingCell extends CornerCell {
    
    private BufferedImage image;
    
    public FreeParkingCell(Dimension boardSize, float boardProportion)  {
        super(
                boardSize,
                boardProportion,
                CornerCell.Corner.TOPLEFT
        );
        try {
            this.image = ImageIO.read(new File("./resources/images/cells/free_parking.png"));
        } catch (IOException ex) {
            Logger.getLogger(FreeParkingCell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void renderContents(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.70, 0.70);
        g2.drawImage(image, 20, 25, null);
        g2.setTransform(at);
    }
}
