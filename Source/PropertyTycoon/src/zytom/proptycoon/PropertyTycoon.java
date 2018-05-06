/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon;

import java.util.ArrayList;
import javax.swing.JFrame;
import zytom.proptycoon.model.Game;
import zytom.proptycoon.view.GameFrame;

/**
 *
 * @author utopia
 */
public class PropertyTycoon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }
    
    private void startGame() {
        Game game = new Game();
        GameController gameController = new GameController();
        GameFrame gameFrame = new GameFrame(gameController);
    }
    
}
