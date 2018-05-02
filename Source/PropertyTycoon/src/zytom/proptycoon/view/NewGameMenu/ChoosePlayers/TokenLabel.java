/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.NewGameMenu.ChoosePlayers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author utopia
 */
public class TokenLabel extends JLabel {

    public TokenLabel() {
        super();

    }

    public static ImageIcon getImageIcon() {
        try {
            return new ImageIcon(ImageIO.read(new File("path-to-file")));
        } catch (IOException ex) {
            Logger.getLogger(TokenLabel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
