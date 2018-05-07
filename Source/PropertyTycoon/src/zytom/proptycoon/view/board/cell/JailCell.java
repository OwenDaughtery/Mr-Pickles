/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
public class JailCell extends CornerCell {
    
    private BufferedImage image;
    
    public JailCell(Dimension boardSize, float boardProportion)  {
        super(
                boardSize,
                boardProportion,
                CornerCell.Corner.BOTTOMLEFT
        );

        try {
            this.image = ImageIO.read(new File("./resources/images/cells/just_visiting.png"));
        } catch (IOException ex) {
            Logger.getLogger(JailCell.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public void renderContents(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.80, 0.80);
        g2.drawImage(image, 10, 10, null);
        g2.setTransform(at);
    }
}
