package zytom.proptycoon.model.assets;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.card.*;
import zytom.proptycoon.model.deckCreator.DeckCreator;


public class TransactionTest {
    
    private  Bank bank;
    private  Player zenos;
    private  Board board;
    
    private ArrayList<UtilityPropertyCard> utilityCards;
    private ArrayList<StationPropertyCard> stationCards;
    private ArrayList<StreetPropertyCard> streetCards;
    private ArrayList<OpportunityKnocksCard> oppKnocksCards;
    private ArrayList<PotLuckCard> potLuckCards;
    
    @Before
    public void init() throws FileNotFoundException, Board.CellNotFoundException, CardAction.InvalidActionException {
        DeckCreator dc = new DeckCreator();
        this.board = new Board(dc.getPropertyData());
        this.bank = new Bank(dc.createPotLuckDeck(), 
                             dc.createOpportunityKnocksDeck(), 
                             dc.createStreetPropertyCardDeck(board), 
                             dc.createStationPropertyCardDeck(board),
                             dc.createUtilityPropertyCardDeck(board));
        
        this.zenos = new Player("Zenos");
        
        this.utilityCards = new ArrayList<>();
        this.stationCards = new ArrayList<>();
        this.streetCards = new ArrayList<>();
        this.oppKnocksCards = new ArrayList<>();
        this.potLuckCards = new ArrayList<>();
    }

    
    
    @Test
    public void cashBankToPlayer() throws AssetOwner.AssetNotFoundException {
        AssetCollection fromBank = new AssetCollection(100);
        AssetCollection toZenos = new AssetCollection(0);
        Transaction tx = new Transaction(bank, zenos, fromBank, toZenos);
        tx.settleTransaction();
        assertEquals(1600, zenos.getAssetCollection().getMoney());
    }
    
    
    
    @Test
    public void bankGivePotLuckCardToPlayer() throws AssetOwner.AssetNotFoundException {

        
        //GET TARGET CARD
        PotLuckCard targetCard = bank.getAssetCollection().getPotLuckCards().get(0);
        potLuckCards.add(targetCard);
        
        //CHECK THAT PLAYER DOES NOT HAVE THE TARGET CARD
        assertFalse(zenos.getAssetCollection().getPotLuckCards().contains(targetCard));
        
        //CREATE TEMP ASSET COLLECTION TO TAKE FROM BANK
        AssetCollection fromBank = new AssetCollection(potLuckCards, oppKnocksCards, streetCards, stationCards, utilityCards);
        
        //CREATE TEMP ASSET COLLECTION TO TAKE FROM PLAYER OF £0.00
        AssetCollection toZenos = new AssetCollection(0);
        
        //CHECK THAT THE BANK HAS THE POTLUCK CARD
        assertTrue(bank.getAssetCollection().getPotLuckCards().contains(targetCard));
        
        //CREATE TRANSACTION AND SETTLE IT
        Transaction tx = new Transaction(bank, zenos, fromBank, toZenos);
        tx.settleTransaction();
        
        //CHECK THAT PLAYER NOW HAS THE CARD
        assertEquals(zenos.getAssetCollection().getPotLuckCards().get(0), targetCard);
        
        //CHECK THAT THE BANK NO LONGER HAS THE CARD
        assertFalse(bank.getAssetCollection().getPotLuckCards().contains(targetCard));
    }
    
    
    
    @Test
    public void bankGiveOpportunityKnocksCardToPlayer() throws AssetOwner.AssetNotFoundException {
        
        //GET TARGET CARD
        OpportunityKnocksCard targetCard = bank.getAssetCollection().getOpportunityKnocksCards().get(0);
        oppKnocksCards.add(targetCard);
        
        //CHECK THAT PLAYER DOES NOT HAVE THE TARGET CARD
        assertFalse(zenos.getAssetCollection().getOpportunityKnocksCards().contains(targetCard));
        
        //CREATE TEMP ASSET COLLECTION TO TAKE FROM BANK
        AssetCollection fromBank = new AssetCollection(potLuckCards, oppKnocksCards, streetCards, stationCards, utilityCards);
        
        //CREATE TEMP ASSET COLLECTION TO TAKE FROM PLAYER OF £0.00
        AssetCollection toZenos = new AssetCollection(0);
        
        //CHECK THAT THE BANK HAS THE OPPORTUNITY KNOCKS CARD
        assertTrue(bank.getAssetCollection().getOpportunityKnocksCards().contains(targetCard));
        
        //CREATE TRANSACTION AND SETTLE IT
        Transaction tx = new Transaction(bank, zenos, fromBank, toZenos);
        tx.settleTransaction();
        
        //CHECK THAT PLAYER NOW HAS THE CARD
        assertEquals(zenos.getAssetCollection().getOpportunityKnocksCards().get(0), targetCard);
        
        //CHECK THAT THE BANK NO LONGER HAS THE CARD
        assertFalse(bank.getAssetCollection().getOpportunityKnocksCards().contains(targetCard));
    }
    
    
    
    @Test
    public void playerBuysStreetPropertyFromBank() throws AssetOwner.AssetNotFoundException {
        StreetPropertyCard card = bank.getAssetCollection().getStreetPropertyCards().get(0);
        int price = card.getPrice();
        AssetCollection propertyFromBank = new AssetCollection(card);
        AssetCollection moneyFromPlayer = new AssetCollection(price);
        Transaction tx = new Transaction(bank, zenos, propertyFromBank, moneyFromPlayer);
        tx.settleTransaction();
        assertTrue((1500 - price) == zenos.getAssetCollection().getMoney());
        assertTrue(card.equals(zenos.getAssetCollection().getStreetPropertyCards().get(0)));
        assertFalse(bank.getAssetCollection().getStreetPropertyCards().contains(card));
    }
    
    
    @Test
    public void playerBuysStationFromBank() throws AssetOwner.AssetNotFoundException {
        StationPropertyCard card = bank.getAssetCollection().getStationPropertyCards().get(0);
        int price = card.getPrice();
        AssetCollection propertyFromBank = new AssetCollection(card);
        AssetCollection moneyFromPlayer = new AssetCollection(price);
        Transaction tx = new Transaction(bank, zenos, propertyFromBank, moneyFromPlayer);
        tx.settleTransaction();
        assertTrue((1500 - price) == zenos.getAssetCollection().getMoney());
        assertTrue(card.equals(zenos.getAssetCollection().getStationPropertyCards().get(0)));
        assertFalse(bank.getAssetCollection().getStationPropertyCards().contains(card));
    }
    
    @Test
    public void playerBuysUtilityFromBank() throws AssetOwner.AssetNotFoundException {
        UtilityPropertyCard card = bank.getAssetCollection().getUtilityPropertyCards().get(0);
        int price = card.getPrice();
        AssetCollection propertyFromBank = new AssetCollection(card);
        AssetCollection moneyFromPlayer = new AssetCollection(price);
        Transaction tx = new Transaction(bank, zenos, propertyFromBank, moneyFromPlayer);
        tx.settleTransaction();
        assertTrue((1500 - price) == zenos.getAssetCollection().getMoney());
        assertTrue(card.equals(zenos.getAssetCollection().getUtilityPropertyCards().get(0)));
        assertFalse(bank.getAssetCollection().getUtilityPropertyCards().contains(card));
    }
    
}