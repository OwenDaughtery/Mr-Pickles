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
import javax.imageio.ImageIO;

/**
 *
 * @author utopia
 */
public class JailCell extends CornerCell {
    
    final BufferedImage image;
    
    public JailCell(Dimension boardSize, float boardProportion) throws IOException {
        super(
                boardSize,
                boardProportion,
                CornerCell.Corner.BOTTOMLEFT
        );
        
        this.image = ImageIO.read(new File("./resources/images/cells/just_visiting.png"));
    }
    
    @Override
    public void renderContents(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.80, 0.80);
        g2.drawImage(image, 10, 10, null);
        g2.setTransform(at);
    }
}
