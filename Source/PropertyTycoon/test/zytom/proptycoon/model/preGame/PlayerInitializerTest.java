package zytom.proptycoon.model.preGame;

/*
 * PropertyTycoon Application by Zytom
 */

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import zytom.proptycoon.Common.TokenType;
import zytom.proptycoon.controller.preGame.PlayerInitalizer;
import zytom.proptycoon.model.Player;
/**
 *
 * @author zenos
 */
public class PlayerInitializerTest {
    
    @Test 
    public void createPlayer() throws PlayerInitalizer.ToManyPlayersException, PlayerInitalizer.TokenNotFoundException {
        PlayerInitalizer playerInit = new PlayerInitalizer();
        playerInit.createPlayer("Zenos", TokenType.BOOT);
        assertTrue(playerInit.getPlayers().size() == 1);
        assertTrue("Zenos".equals(playerInit.getPlayers().get(0).getName()));
    }
    
    @Test
    public void noMoreThanSixPlayers() throws PlayerInitalizer.ToManyPlayersException, PlayerInitalizer.TokenNotFoundException {
        PlayerInitalizer playerInit = new PlayerInitalizer();
        playerInit.createPlayer("Zenos", TokenType.BOOT);
        playerInit.createPlayer("Max", TokenType.CAT);
        playerInit.createPlayer("Ayman", TokenType.GOBLET);
        playerInit.createPlayer("Tom", TokenType.HATSTAND);
        playerInit.createPlayer("Owen", TokenType.SMARTPHONE);
        playerInit.createPlayer("Some Guy", TokenType.SPOON);
        playerInit.createPlayer("Mr Pickles", TokenType.SPOON);
        assertTrue(playerInit.getPlayers().size() == 6);
    }
    
    @Test
    public void noDuplicateTokens() throws PlayerInitalizer.ToManyPlayersException, PlayerInitalizer.TokenNotFoundException {
        PlayerInitalizer playerInit = new PlayerInitalizer();
        playerInit.createPlayer("Zenos", TokenType.BOOT);
        playerInit.createPlayer("Tom", TokenType.BOOT);
        assertTrue(playerInit.getPlayers().size() == 1);
        assertTrue("Zenos".equals(playerInit.getPlayers().get(0).getName()));
    }
}