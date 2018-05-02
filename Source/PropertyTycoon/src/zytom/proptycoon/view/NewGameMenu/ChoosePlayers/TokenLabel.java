/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.NewGameMenu.ChoosePlayers;

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
    public enum TokenType { BOOT, SMARTPHONE, GOBLET, HATSTAND, CAT, SPOON };
    
    public TokenLabel(TokenType tokenType) throws IOException {
        super(getImageIcon(tokenType));
    }

    public static ImageIcon getImageIcon(TokenType tokenType) throws IOException {
        EnumMap<TokenType, String> iconMap = new EnumMap(TokenType.class);
        iconMap.put(TokenType.BOOT, "boot.png");
        iconMap.put(TokenType.SMARTPHONE, "smartphone.png");
        iconMap.put(TokenType.GOBLET, "goblet.png");
        iconMap.put(TokenType.HATSTAND, "hatstand.png");
        iconMap.put(TokenType.CAT, "cat.png");
        iconMap.put(TokenType.SPOON, "spoon.png");
        try {
            String filepath = TOKEN_ICONS_PATH + iconMap.get(tokenType);
            return new ImageIcon(ImageIO.read(new File(filepath)));
        } catch (IOException ex) {
            throw ex;
        }
    }
}
