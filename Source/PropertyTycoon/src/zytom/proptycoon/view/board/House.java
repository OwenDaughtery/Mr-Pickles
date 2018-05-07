package zytom.proptycoon.view.board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class House {


    private BufferedImage image;
    public House() {
        try {
            this.image= ImageIO.read(new File("./resources/images/properties/house.png"));
        } catch (IOException ex) {
            Logger.getLogger("House Images Not Found").log(Level.SEVERE, null, ex);
        }
    }
    public void renderContents(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.2,0.2);
        g2.drawImage(image, 10,10, null);
        g2.setTransform(at);
    }
}
