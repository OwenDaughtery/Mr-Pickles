/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Dimension;
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
import zytom.proptycoon.view.board.cell.CornerCell;
import zytom.proptycoon.view.board.cell.InJailCell;

/**
 *
 * @author zenos
 */
public class PotLuckDeckCell extends Cell {

 private BufferedImage image;
    
    public static Dimension calcDimension(
            Dimension boardSize,
            float boardProportion
    ) {
        return new Dimension(
                    Math.round((float)boardSize.width * boardProportion / 1.5f),
                    Math.round((float)boardSize.height * boardProportion /1.5f)
                );
    }
    
    public static Point calcPosition(
            Dimension boardSize,
            float boardProportion
    ) {
        Dimension dimension = calcDimension(boardSize, boardProportion);
        Dimension cornerDimension = CornerCell.calcDimension(boardSize, boardProportion);
        
        return new Point(
                cornerDimension.width,
                boardSize.height - cornerDimension.height - dimension.height
        );
    }
    
    public PotLuckDeckCell(Dimension boardSize, float boardProportion) {
        super(
                calcDimension(boardSize, boardProportion),
                calcPosition(boardSize, boardProportion),
                Cell.Orientation.RIGHT
        );
        try {
            this.image = ImageIO.read(new File("./resources/images/opKnockCardBack/card_back_Blue.png"));
        } catch (IOException ex) {
            Logger.getLogger(InJailCell.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public void renderContents(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.33, 0.33);
        g2.drawImage(image, 0, 0, null);
        g2.setTransform(at);
        
    }

    
}
