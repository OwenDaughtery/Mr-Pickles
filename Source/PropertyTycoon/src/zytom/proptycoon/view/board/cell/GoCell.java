/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Tom
 */
public class GoCell extends CornerCell {
    
    final BufferedImage image;
    
    public GoCell(Dimension boardSize, float boardProportion) throws IOException {
        super(
                boardSize,
                boardProportion,
                Corner.BOTTOMRIGHT
        );
        this.image = ImageIO.read(new File("./resources/images/cells/go_arrow.png"));
    }
    
    @Override
    protected void renderContents(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.drawString("GO", 30, 45);
        AffineTransform at = g2.getTransform();
        g2.scale(0.5, 0.5);
        g2.drawImage(image, 35, 80, null);
        g2.setTransform(at);
    }
}
