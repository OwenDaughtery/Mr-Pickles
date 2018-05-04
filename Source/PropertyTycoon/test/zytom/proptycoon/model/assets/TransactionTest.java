package zytom.proptycoon.model.assets;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.card.OpportunityKnocksCard;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.StationPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;
import zytom.proptycoon.model.deckCreator.DeckCreator;

public class TransactionTest {
    
    private  Bank bank;
    private  Player zenos;
    private  Board board;
    
    @Before
    public void init() throws FileNotFoundException, Board.CellNotFoundException {
        DeckCreator dc = new DeckCreator();
        this.board = new Board(dc.getPropertyData());
        this.bank = new Bank(dc.createPotLuckDeck(), dc.createOpportunityKnocksDeck(), 
                             dc.createStreetPropertyCardDeck(board), dc.createStationPropertyCardDeck(board),
                             dc.createUtilityPropertyCardDeck(board));
        
        zenos = new Player("Zenos");
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
        
        //ARGUMENTS FOR ASSET COLLECTION
        ArrayList<UtilityPropertyCard> utilityCards = new ArrayList<>();
        ArrayList<StationPropertyCard> stationCards = new ArrayList<>();
        ArrayList<StreetPropertyCard> streetCards = new ArrayList<>();
        ArrayList<OpportunityKnocksCard> oppKnocksCards = new ArrayList<>();
        ArrayList<PotLuckCard> potLuckCards = new ArrayList<>();
        
        //GET TARGET CARD
        PotLuckCard targetCard = this.bank.getAssetCollection().getPotLuckCards().get(0);
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
        
        //ARGUMENTS FOR ASSET COLLECTION
        ArrayList<UtilityPropertyCard> utilityCards = new ArrayList<>();
        ArrayList<StationPropertyCard> stationCards = new ArrayList<>();
        ArrayList<StreetPropertyCard> streetCards = new ArrayList<>();
        ArrayList<PotLuckCard> potLuckCards = new ArrayList<>();
        ArrayList<OpportunityKnocksCard> oppKnocksCards = new ArrayList<>();
        
        //GET TARGET CARD
        OpportunityKnocksCard targetCard = this.bank.getAssetCollection().getOpportunityKnocksCards().get(0);
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
}