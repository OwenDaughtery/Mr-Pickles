package zytom.proptycoon.model.assets;

import java.io.FileNotFoundException;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.card.CardAction;
import zytom.proptycoon.model.deckCreator.DeckCreator;

public class AssetCollectionTest {
    
    private DeckCreator dc;
    private Board board;
    private Bank bank;
    
    @Before
    public void init() throws FileNotFoundException, CardAction.InvalidActionException, Board.CellNotFoundException {
        this.dc = new DeckCreator();
        this.board = new Board(dc.getPropertyData());
        this.bank = new Bank(dc.createPotLuckDeck(), 
                             dc.createOpportunityKnocksDeck(),
                             dc.createStreetPropertyCardDeck(board),
                             dc.createStationPropertyCardDeck(board),
                             dc.createUtilityPropertyCardDeck(board));
        
    }
    
    
    @Test
    public void getPotLuckCards() {
        assertTrue(bank.getAssetCollection().getPotLuckCards() != null);
        assertTrue(bank.getAssetCollection().getPotLuckCards().size() == 16);
    }

    
    @Test
    public void getOpportunityKnocksCards() {
        assertTrue(bank.getAssetCollection().getOpportunityKnocksCards() != null);
        assertTrue(bank.getAssetCollection().getOpportunityKnocksCards().size() == 16);
    }

    @Test
    public void getStreetPropertyCards() {
        assertTrue(bank.getAssetCollection().getStreetPropertyCards() != null);
        assertTrue(bank.getAssetCollection().getStreetPropertyCards().size() == 22);
    }

    @Test
    public void getStationPropertyCards() {
        assertTrue(bank.getAssetCollection().getStationPropertyCards() != null);
        assertTrue(bank.getAssetCollection().getStationPropertyCards().size() == 4);
    }

    @Test
    public void getUtilityPropertyCards() {
        assertTrue(bank.getAssetCollection().getUtilityPropertyCards() != null);
        assertTrue(bank.getAssetCollection().getUtilityPropertyCards().size() == 2);
    }

    @Test
    public void getMoney() {
        assertTrue(bank.getAssetCollection().getMoney() == 50000);
    }

    @Test
    public void setMoney() {
        AssetCollection money = new AssetCollection(0);
        money.setMoney(100);
        assertTrue(money.getMoney() == 100);
    }

    @Test
    public void calculateValue() {
        assertTrue(bank.getAssetCollection().calculateValue() - bank.getAssetCollection().getMoney() == 5690);
    }
}