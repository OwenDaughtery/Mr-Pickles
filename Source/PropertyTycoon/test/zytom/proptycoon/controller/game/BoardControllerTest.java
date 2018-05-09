

package zytom.proptycoon.controller.game;

/*
 * PropertyTycoon Application by Zytom
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import zytom.proptycoon.Common.TokenType;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.card.CardAction;
import zytom.proptycoon.model.card.StreetPropertyCard;

/**
 *
 * @author aymanfree
 */
public class BoardControllerTest {
    
    BoardController boardController;
    public BoardControllerTest(){
        
    }
    @Before
    public void setUp() throws Game.PlayerNumberException, FileNotFoundException, Board.CellNotFoundException, CardAction.InvalidActionException, StreetPropertyCard.InvalidColourGroupException {
   
        ArrayList<Player>players = new ArrayList<>();
        players.add(new Player("zenos", TokenType.BOOT));
        players.add(new Player("tom", TokenType.CAT));
        players.add(new Player("ayman", TokenType.HATSTAND));      
        players.add(new Player("max", TokenType.GOBLET));      
        players.add(new Player("owen", TokenType.SPOON));
        Player startingPlayer = players.get(0);
        Game game = new Game(players, startingPlayer);
        boardController = new BoardController(game.getBoard());
    }
  
    @Test
    public void StreetNameStrings() {
        boardController.getStreetNames().forEach((string) -> {
            System.out.println(string);
        });
    }
    
    @Test
    public void StreetNamePrices() {
        boardController.getStreetPrices().forEach((string) -> {
            System.out.println(string);
        });
    }
}
