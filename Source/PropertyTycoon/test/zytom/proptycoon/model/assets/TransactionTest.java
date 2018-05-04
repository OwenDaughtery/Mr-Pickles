package zytom.proptycoon.model.assets;

import java.io.FileNotFoundException;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Player;
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
    
//    @Test
//    public void BankGivePotLuckCardToPlayer() {
//        this.bank.getAssetCollection().getPotLuckCards().remove(0);
//
//    }
    
}