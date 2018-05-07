/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Graphics2D;

/**
 *
 * @author Tom
 */
public class TokenView {
    
    public enum TokenType { BOOT, CAT, HATSTAND, SMARTPHONE, GOBLET, SPOON }
    
    private final TokenType type;
    
    public TokenView(TokenType type) {
        this.type = type;
    }
}
