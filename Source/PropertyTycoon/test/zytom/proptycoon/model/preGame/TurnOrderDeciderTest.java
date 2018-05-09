/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.preGame;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import zytom.proptycoon.Common.TokenType;
import zytom.proptycoon.controller.preGame.TurnOrderDecider;
import zytom.proptycoon.model.Player;

/**
 *
 * @author zenos
 */
public class TurnOrderDeciderTest {
    
    private ArrayList<Player> players;
    private TurnOrderDecider turnOrderDecider;
    @Before
    public void init() {
        this.players = new ArrayList<>();
        this.players.add(new Player("zenos", TokenType.BOOT));
        this.players.add(new Player("tom", TokenType.CAT));
        this.players.add(new Player("ayman", TokenType.HATSTAND));
        this.turnOrderDecider = new TurnOrderDecider(players);
    }
    
    @Test(expected = TurnOrderDecider.EveryPlayerHasRolledException.class)
    public void everyPlayerRollTest() throws TurnOrderDecider.EveryPlayerHasRolledException{
        turnOrderDecider.rollDice();
        turnOrderDecider.rollDice();
        turnOrderDecider.rollDice();
        turnOrderDecider.rollDice();
    }
    @Test
     public void getFirstPlayer() throws TurnOrderDecider.EveryPlayerHasRolledException{
        turnOrderDecider.rollDice();
        assertTrue(turnOrderDecider.getFirstPlayer().equals(players.get(0)));
    }
    
}
