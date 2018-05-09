/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import zytom.proptycoon.Common.TokenType;
import zytom.proptycoon.controller.game.GameController;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.card.CardAction;
import zytom.proptycoon.model.card.StreetPropertyCard;
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
        startGame();
    }
    
    private static void startGame() {
        
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("p1", TokenType.BOOT));
        players.add(new Player("p2", TokenType.CAT));
        try {
            Game game = new Game(
                    players, players.get(0)
            );
            GameController gameController = new GameController(game);
            GameFrame gameFrame = new GameFrame(gameController);
            gameFrame.setVisible(true);
        } catch (Game.PlayerNumberException ex) {
            Logger.getLogger(PropertyTycoon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertyTycoon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Board.CellNotFoundException ex) {
            Logger.getLogger(PropertyTycoon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CardAction.InvalidActionException ex) {
            Logger.getLogger(PropertyTycoon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (StreetPropertyCard.InvalidColourGroupException ex) {
            Logger.getLogger(PropertyTycoon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
