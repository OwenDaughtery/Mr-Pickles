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
import javax.imageio.ImageIO;

/**
 *
 * @author Tom
 */
public class GoToJailCell extends CornerCell{
    
    final BufferedImage image;
    
    public GoToJailCell(Dimension boardSize, float boardProportion) throws IOException {
        super(
                boardSize,
                boardProportion,
                CornerCell.Corner.TOPRIGHT
        );
        this.image = ImageIO.read(new File("./resources/images/cells/police.png"));
    }
    
    @Override
    public void renderContents(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.70, 0.70);
        g2.drawImage(image, 20, 25, null);
        g2.setTransform(at);
        
    }
}
