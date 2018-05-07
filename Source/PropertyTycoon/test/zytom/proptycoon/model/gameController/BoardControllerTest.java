/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.gameController;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import zytom.proptycoon.controller.game.BoardController;
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

    private final ArrayList<Player> players;
    private final Game game;
    private final  BoardController boardController;
    
    public BoardControllerTest() throws Game.PlayerNumberException, CardAction.InvalidActionException, FileNotFoundException, Board.CellNotFoundException, StreetPropertyCard.InvalidColourGroupException {    
        this.players = new ArrayList<>();
        this.players.add(new Player("zenos", Player.TokenType.BOOT));
        this.players.add(new Player("tom", Player.TokenType.CAT));
        this.players.add(new Player("ayman", Player.TokenType.HATSTAND));      
        this.players.add(new Player("max", Player.TokenType.GOBLET));      
        this.players.add(new Player("owen", Player.TokenType.SPOON));
        Player startingPlayer = players.get(0);
        this.game = new Game(players, startingPlayer);
        this.boardController = new BoardController(game.getBoard());
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
