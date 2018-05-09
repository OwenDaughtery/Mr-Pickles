/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import zytom.proptycoon.Common.TokenType;
import zytom.proptycoon.view.board.cell.JailCell;

/**
 *
 * @author Tom
 */
public class PlayerView {

    private BufferedImage image;

    private final TokenType type;
    private final Point position;

    private static String getFilename(TokenType type) {
        switch (type) {
            case BOOT:
                return "boot.png";
            case CAT:
                return "cat.png";
            case HATSTAND:
                return "hatstand.png";
            case SMARTPHONE:
                return "smartphone.png";
            case GOBLET:
                return "goblet.png";
            case SPOON:
                return "spoon.png";
        }
        return "";
    }

    private static Point getPosition(TokenType type) {
        switch (type) {
            case BOOT:
                return new Point(6, 10);
            case CAT:
                return new Point(32, 10);
            case HATSTAND:
                return new Point(6, 38);
            case SMARTPHONE:
                return new Point(32, 38);
            case GOBLET:
                return new Point(8, 62);
            case SPOON:
                return new Point(32, 62);
        }
        return new Point(0, 0);
    }

    public PlayerView(TokenType type) {
        this.type = type;
        String filepath = "./resources/images/tokens/small/" + getFilename(this.type);
        try {
            this.image = ImageIO.read(new File(filepath));
        } catch (IOException ex) {
            Logger.getLogger(JailCell.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.position = getPosition(this.type);
    }
    
    public TokenType getTokenType() {
        return this.type;
    }

    public void render(Graphics2D g2) {
        g2.drawImage(image, position.x, position.y, null);
    }
}
