package zytom.proptycoon.model.preGame;

/*
 * PropertyTycoon Application by Zytom
 */

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import zytom.proptycoon.controller.preGame.PlayerInitalizer;
import zytom.proptycoon.model.Player;
/**
 *
 * @author zenos
 */
public class PlayerInitializerTest {
    
    @Test 
    public void createPlayer() {
        PlayerInitalizer playerInit = new PlayerInitalizer();
        playerInit.createPlayer("Zenos", Player.TokenType.BOOT);
        assertTrue(playerInit.getPlayers().size() == 1);
        assertTrue("Zenos".equals(playerInit.getPlayers().get(0).getName()));
    }
}
