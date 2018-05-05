/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.preGame;

import java.util.ArrayList;
import org.junit.Before;
import zytom.proptycoon.model.Player;

/**
 *
 * @author zenos
 */
public class TurnOrderDeciderTest {
    
    private ArrayList<Player> players;
    
    @Before
    public void init() {
        this.players = new ArrayList<>();
        this.players.add(new Player("zenos", Player.TokenType.BOOT));
        this.players.add(new Player("tom", Player.TokenType.CAT));
        this.players.add(new Player("ayman", Player.TokenType.HATSTAND));
    }
}
