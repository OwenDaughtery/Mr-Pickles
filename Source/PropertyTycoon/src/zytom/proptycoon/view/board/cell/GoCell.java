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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Tom
 */
public class GoCell extends CornerCell {
    
    private BufferedImage image;
    
    public GoCell(Dimension boardSize, float boardProportion)  {
        super(
                boardSize,
                boardProportion,
                Corner.BOTTOMRIGHT
        );
        try {
            this.image = ImageIO.read(new File("./resources/images/cells/go_arrow.png"));
        } catch (IOException ex) {
            Logger.getLogger(GoCell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void renderContents(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.drawString("GO", 30, 45);
        AffineTransform at = g2.getTransform();
        g2.scale(0.5, 0.5);
        g2.drawImage(image, 35, 80, null);
        g2.setTransform(at);
        g2.setFont(new Font("Arial", Font.BOLD, 16));
    }
}
