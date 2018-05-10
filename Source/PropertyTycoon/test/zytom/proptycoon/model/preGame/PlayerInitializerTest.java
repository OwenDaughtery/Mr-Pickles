package zytom.proptycoon.model.preGame;

/*
 * PropertyTycoon Application by Zytom
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import zytom.proptycoon.Common.TokenType;
import zytom.proptycoon.controller.preGame.PlayerInitalizer;

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
    
    @Test (expected = PlayerInitalizer.ToManyPlayersException.class)
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
    
    @Test (expected = PlayerInitalizer.TokenNotFoundException.class)
    public void noDuplicateTokens() throws PlayerInitalizer.ToManyPlayersException, PlayerInitalizer.TokenNotFoundException {
        PlayerInitalizer playerInit = new PlayerInitalizer();
        playerInit.createPlayer("Zenos", TokenType.BOOT);
        playerInit.createPlayer("Tom", TokenType.BOOT);
        assertTrue(playerInit.getPlayers().size() == 1);
        assertTrue("Zenos".equals(playerInit.getPlayers().get(0).getName()));
    }
    
    @Test
    public void playersHaveCorrectTokens() throws PlayerInitalizer.ToManyPlayersException, PlayerInitalizer.TokenNotFoundException {
        PlayerInitalizer playerInit = new PlayerInitalizer();
        playerInit.createPlayer("Zenos", TokenType.BOOT);
        assertTrue(playerInit.getPlayers().get(0).getTokenType() == TokenType.BOOT);
        playerInit.createPlayer("Tom", TokenType.SMARTPHONE);
        assertTrue(playerInit.getPlayers().get(1).getTokenType() == TokenType.SMARTPHONE);
        playerInit.createPlayer("Ayman", TokenType.GOBLET);
        assertTrue(playerInit.getPlayers().get(2).getTokenType() == TokenType.GOBLET);
        playerInit.createPlayer("Max", TokenType.HATSTAND);
        assertTrue(playerInit.getPlayers().get(3).getTokenType() == TokenType.HATSTAND);
        playerInit.createPlayer("Owen", TokenType.CAT);
        assertTrue(playerInit.getPlayers().get(4).getTokenType() == TokenType.CAT);
        playerInit.createPlayer("Some Guy", TokenType.SPOON);
        assertTrue(playerInit.getPlayers().get(5).getTokenType() == TokenType.SPOON);
    }
    
    @Test
    public void allPlayersStartAtGo() throws PlayerInitalizer.ToManyPlayersException, PlayerInitalizer.TokenNotFoundException {
        PlayerInitalizer playerInit = new PlayerInitalizer();
        playerInit.createPlayer("Zenos", TokenType.BOOT);
        playerInit.createPlayer("Tom", TokenType.SMARTPHONE);
        playerInit.createPlayer("Ayman", TokenType.GOBLET);
        playerInit.createPlayer("Max", TokenType.HATSTAND);
        playerInit.createPlayer("Owen", TokenType.CAT);
        playerInit.createPlayer("Some Guy", TokenType.SPOON);
        playerInit.getPlayers().stream().forEach((player) -> {
            assertEquals(0, player.getPosition());
        });
    }
    
    @Test
    public void allPlayersStartWithCorrectMoney() throws PlayerInitalizer.ToManyPlayersException, PlayerInitalizer.TokenNotFoundException {
        PlayerInitalizer playerInit = new PlayerInitalizer();
        playerInit.createPlayer("Zenos", TokenType.BOOT);
        playerInit.createPlayer("Tom", TokenType.SMARTPHONE);
        playerInit.createPlayer("Ayman", TokenType.GOBLET);
        playerInit.createPlayer("Max", TokenType.HATSTAND);
        playerInit.createPlayer("Owen", TokenType.CAT);
        playerInit.createPlayer("Some Guy", TokenType.SPOON);
        playerInit.getPlayers().stream().forEach((player) -> {
            assertEquals(1500, player.getAssetCollection().getMoney());
        });
    }
}