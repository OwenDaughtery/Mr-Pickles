/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Color;
import java.awt.Dimension;
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
import zytom.proptycoon.view.board.cell.Cell;
import static zytom.proptycoon.view.board.cell.Cell.getRadians;
import zytom.proptycoon.view.board.cell.CornerCell;
import zytom.proptycoon.view.board.cell.InJailCell;

/**
 *
 * @author zenos
 */
public class OpportunityKnocksDeckCell {

    private BufferedImage image;
    Dimension boardSize;

    public OpportunityKnocksDeckCell(Dimension boardSize) {
        this.boardSize = boardSize;
        try {
            this.image = ImageIO.read(new File("./resources/images/opKnockCardBack/card_back_Red.png"));
        } catch (IOException ex) {
            Logger.getLogger(InJailCell.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void renderContents(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        double posX = boardSize.width / 2.0 + 100;
        double posY = boardSize.height / 2.0 + 100;
        g2.translate(posX, posY);
        g2.scale(0.33, 0.33);
        g2.drawImage(image, 0, 0, null);
        g2.setTransform(at);
    }
    
    public void render(Graphics g) {
        renderContents((Graphics2D) g);
    }

}
