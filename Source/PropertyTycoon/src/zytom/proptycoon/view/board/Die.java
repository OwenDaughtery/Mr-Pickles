/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Tom
 * @author Ayman
 * @author Zenos
 */
public abstract class Die {

    private final ArrayList<BufferedImage> images;
    private final Dimension boardSize;
    private final Point position;
    private int currentValue;

    public Die(Dimension boardSize, Point position) {
        this.boardSize = boardSize;
        this.position = position;
        this.images = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            try {
                this.images.add(
                        ImageIO.read(new File("./resources/images/dice/" + i + ".png"))
                );
            } catch (IOException ex) {
                Logger.getLogger(Die.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void setValue(int val) {
        this.currentValue = val;
    }
    
    private BufferedImage getCurrentImage() {
        return this.images.get(currentValue);
    }

    private void renderContents(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.translate(position.x, position.y);
        g2.scale(0.8, 0.8);
        g2.drawImage(
                getCurrentImage(),
                0,
                0,
                null
        );
        g2.setTransform(at);
    }

    public void render(Graphics g) {
        renderContents((Graphics2D) g);
    }
}
