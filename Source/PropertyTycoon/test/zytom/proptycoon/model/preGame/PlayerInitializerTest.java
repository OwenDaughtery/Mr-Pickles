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
    
    @Test
    public void noMoreThanSixPlayers() {
        PlayerInitalizer playerInit = new PlayerInitalizer();
        playerInit.createPlayer("Zenos", Player.TokenType.BOOT);
        playerInit.createPlayer("Max", Player.TokenType.CAT);
        playerInit.createPlayer("Ayman", Player.TokenType.GOBLET);
        playerInit.createPlayer("Tom", Player.TokenType.HATSTAND);
        playerInit.createPlayer("Owen", Player.TokenType.SMARTPHONE);
        playerInit.createPlayer("Some Guy", Player.TokenType.SPOON);
        playerInit.createPlayer("Mr Pickles", Player.TokenType.SPOON);
        assertTrue(playerInit.getPlayers().size() == 6);
    }
    
    @Test
    public void noDuplicateTokens() {
        PlayerInitalizer playerInit = new PlayerInitalizer();
        playerInit.createPlayer("Zenos", Player.TokenType.BOOT);
        playerInit.createPlayer("Tom", Player.TokenType.BOOT);
        assertTrue(playerInit.getPlayers().size() == 1);
        assertTrue("Zenos".equals(playerInit.getPlayers().get(0).getName()));
    }
}