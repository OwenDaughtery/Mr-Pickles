/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.newgame.chooseplayers;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Tom
 */
public class TokenLabel extends JLabel {

    private static final String TOKEN_ICONS_PATH = "./resources/images/tokens/";

    public enum TokenType {
        BOOT, SMARTPHONE, GOBLET, HATSTAND, CAT, SPOON
    };
    
    TokenType tokenType;

    public TokenLabel(TokenType tokenType) throws IOException {
        super(getImageIcon(tokenType));
        this.tokenType = tokenType;
        this.setMaximumSize(new Dimension(64, 64));
        this.setSize(64, 64);
    }

    public static ImageIcon getImageIcon(TokenType tokenType) throws IOException {
        EnumMap<TokenType, String> iconMap = new EnumMap(TokenType.class);
        iconMap.put(TokenType.BOOT, "boot.jpg");
        iconMap.put(TokenType.SMARTPHONE, "smartphone.jpg");
        iconMap.put(TokenType.GOBLET, "goblet.jpg");
        iconMap.put(TokenType.HATSTAND, "hatstand.jpg");
        iconMap.put(TokenType.CAT, "cat.jpg");
        iconMap.put(TokenType.SPOON, "spoon.jpg");
        try {
            String filepath = TOKEN_ICONS_PATH + iconMap.get(tokenType);
            return new ImageIcon(ImageIO.read(new File(filepath)));
        } catch (IOException ex) {
            throw ex;
        }
    }
}
