/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import zytom.proptycoon.view.board.cell.InJailCell;

/**
 *
 * @author zenos
 */
public class LogoView {
    
    private BufferedImage image;
    Dimension boardSize;
    
    
    public LogoView(Dimension boardSize) {
        this.boardSize = boardSize;
        try {
            this.image = ImageIO.read(new File("./resources/images/logo/logo.png"));
        } catch (IOException ex) {
            Logger.getLogger(InJailCell.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void renderContents(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        double posX = 210;
        double posY = 210;
        g2.translate(posX, posY);
        g2.scale(0.33, 0.33);
        g2.drawImage(image, 0, 0, null);
        g2.setTransform(at);
    }
    
    public void render(Graphics g) {
        renderContents((Graphics2D) g);
    }
}
