package zytom.proptycoon.view.dice;


import zytom.proptycoon.view.board.cell.CornerCell;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiceCell {

    private BufferedImage one;
    private BufferedImage two;
    private BufferedImage three;
    private BufferedImage four;
    private BufferedImage five;
    private BufferedImage six;

    public DiceCell() {
        try {
            this.one= ImageIO.read(new File("./resources/images/dice/1.png"));
            this.two = ImageIO.read(new File("./resources/images/dice/2.png"));
            this.three = ImageIO.read(new File("./resources/images/dice/3.png"));
            this.four = ImageIO.read(new File("./resources/images/dice/4.png"));
            this.five = ImageIO.read(new File("./resources/images/dice/5.png"));
            this.six = ImageIO.read(new File("./resources/images/dice/6.png"));
        } catch (IOException ex) {
            Logger.getLogger("Dice Images Not Found").log(Level.SEVERE, null, ex);
        }
    }

    public void renderOne(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.40, 0.40);
        g2.drawImage(one, 20, 20, null);
        g2.setTransform(at);
    }
    public void renderTwo(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.40, 0.40);
        g2.drawImage(two, 20, 20, null);
        g2.setTransform(at);
    }
    public void renderThree(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.40, 0.40);
        g2.drawImage(three, 20, 20, null);
        g2.setTransform(at);
    }
    public void renderFour(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.40, 0.40);
        g2.drawImage(four, 20, 20, null);
        g2.setTransform(at);
    }
    public void renderFive(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.40, 0.40);
        g2.drawImage(five, 20, 20, null);
        g2.setTransform(at);
    }
    public void renderSix(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.40, 0.40);
        g2.drawImage(six, 20, 20, null);
        g2.setTransform(at);
    }
}
