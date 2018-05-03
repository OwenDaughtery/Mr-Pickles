package zytom.proptycoon.model;

import java.io.FileNotFoundException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.deckCreator.DeckCreator;

public class PlayerTest {

    Player player;
    DeckCreator deckCreator;
    Board board;
    Bank bank;
    
    @Before 
    public void init() throws FileNotFoundException, Board.CellNotFoundException {
        this.player = new Player("zenos");
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

    }

    @Test
    public void passGoAndCollect200() {
        player.move(39, bank);
        player.move(1, bank);
        assertEquals(1700, player.getAssetCollection().getMoney());
    }
    
    @Test
    public void getAssetCollection() {
    }

    
    @Test
    public void getTurnsInJail() {
    }

    
    @Test
    public void setTurnsInJail() {
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
    public void takeAssetCollection() {
        
    }
    
    @Test
    public void giveAssetCollection() {

    }
    
    @Test
    public void getInitialBalance() {
        assertEquals(1500, player.getAssetCollection().getMoney());
    }
}