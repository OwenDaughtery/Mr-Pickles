package zytom.proptycoon.model;

import java.io.FileNotFoundException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.card.CardAction;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.deckCreator.DeckCreator;

public class PlayerTest {

    Player player;
    DeckCreator deckCreator;
    Board board;
    Bank bank;
    
    @Before 
    public void init() throws FileNotFoundException, Board.CellNotFoundException, CardAction.InvalidActionException, StreetPropertyCard.InvalidColourGroupException {
        this.player = new Player("zenos", Player.TokenType.SMARTPHONE);
        this.deckCreator = new DeckCreator();
        this.board = new Board(deckCreator.getPropertyData());
        this.bank = new Bank(deckCreator.createPotLuckDeck(), deckCreator.createOpportunityKnocksDeck(), deckCreator.createStreetPropertyCardDeck(board),
                             deckCreator.createStationPropertyCardDeck(board), deckCreator.createUtilityPropertyCardDeck(board)); 
    }


    @Test
    public void getName() {
        String result = player.getName();
        assertTrue("zenos".equals(result));
    }

    
    @Test
    public void getPosition() {
        assertEquals(0, player.getPosition());
    }

    
    @Test
    public void move() throws FileNotFoundException, Board.CellNotFoundException {
        player.move(2, bank);
        assertEquals(2, player.getPosition());
        
        player.move(38, bank);
        assertEquals(0, player.getPosition());
    }

    
    @Test
    public void moveTo() {
        player.moveTo(4, true, bank);
        assertEquals(4, player.getPosition());
    }

    @Test
    public void passGoAndCollect200() {
        player.move(39, bank);
        player.move(1, bank);
        assertEquals(1700, player.getAssetCollection().getMoney());
    }
    
    @Test
    public void getAssetCollection() {
        assertTrue(player.getAssetCollection() instanceof AssetCollection);
    }

    
    @Test
    public void getAndSetTurnsInJail() {
        assertEquals(0, player.getTurnsInJail());
        player.setTurnsInJail(1);
        assertEquals(1, player.getTurnsInJail());
        player.setTurnsInJail(2);
        assertEquals(2, player.getTurnsInJail());
    }

    
    @Test
    public void takeMoneyAssetCollection() throws AssetOwner.AssetNotFoundException {
        player.takeAssetCollection(new AssetCollection(500));
        assertEquals(1000, player.getAssetCollection().getMoney());
    }

    
    @Test
    public void giveMoneyAssetCollection() {
        player.giveAssetCollection(new AssetCollection(200));
        assertEquals(1700, player.getAssetCollection().getMoney());  
    }
    
    @Test
    public void takeMoneyAsset() throws AssetOwner.AssetNotFoundException {
        AssetCollection money = new AssetCollection(100);
        player.takeAssetCollection(money);
        assertEquals(1400, player.getAssetCollection().getMoney());
    }
    
    @Test
    public void giveMoneyAsset() {
        AssetCollection money = new AssetCollection(100);
        player.giveAssetCollection(money);
        assertEquals(1600, player.getAssetCollection().getMoney());
    }
    
    @Test
    public void getInitialBalance() {
        assertEquals(1500, player.getAssetCollection().getMoney());
    }
}