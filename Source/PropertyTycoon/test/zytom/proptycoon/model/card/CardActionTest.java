package zytom.proptycoon.model.card;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.FreeParking;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.deckCreator.DeckCreator;

public class CardActionTest {
    
    private FreeParking freeParking;
    private Bank bank;
    private Player player;
    private ArrayList<Player> players;
    
    
    @Before
    public void init() throws FileNotFoundException, CardAction.InvalidActionException, Board.CellNotFoundException, StreetPropertyCard.InvalidColourGroupException {
        this.freeParking = new FreeParking();
        DeckCreator dc = new DeckCreator();
        Board board = new Board(dc.getPropertyData());
        ArrayList<StreetPropertyCard> streetDeck = dc.createStreetPropertyCardDeck(board);
        ArrayList<StationPropertyCard> stationDeck = dc.createStationPropertyCardDeck(board);
        ArrayList<UtilityPropertyCard> utilityDeck = dc.createUtilityPropertyCardDeck(board);
        this.bank = new Bank(dc.createPotLuckDeck(), dc.createOpportunityKnocksDeck(), streetDeck, stationDeck, utilityDeck);
        this.player = new Player("Zenos", Player.TokenType.BOOT);
        this.players = new ArrayList<>();
        this.players.add(player);
    }
    

    @Test
    public void bankPaysPlayerAndCardHandedBackToBankCorrectly() throws CardAction.InvalidActionException, AssetOwner.AssetNotFoundException {
        OpportunityKnocksCard oppCard = bank.getAssetCollection().getOpportunityKnocksCards().remove(0); //Bank pays player £50
        oppCard.getCardAction().performAction(freeParking, bank, player, players, oppCard);
        assertTrue(this.player.getAssetCollection().getMoney() == 1550);     
        assertFalse(this.bank.getAssetCollection().getOpportunityKnocksCards().get(0).equals(oppCard));
        assertTrue(this.bank.getAssetCollection().getOpportunityKnocksCards().get(this.bank.getAssetCollection()
                                                                                           .getOpportunityKnocksCards()
                                                                                           .size() - 1).equals(oppCard));
    }
    
    
    @Test
    public void givePlayerJailFreeCard() throws AssetOwner.AssetNotFoundException {
        
        PotLuckCard getOutOfJailCard  = null;
        
        for(PotLuckCard card : this.bank.getAssetCollection().getPotLuckCards()) {
            if(card.getCardAction().type.equals(CardAction.Type.GET_OUT_OF_JAIL_POT_LUCK)) {
                getOutOfJailCard = card;
                break;
            }
        }
        
        //CHECK THAT THE BANK HAS THE CARD
        assertTrue(bank.getAssetCollection().getPotLuckCards().contains(getOutOfJailCard));
        
        //CHECK THAT THE PALYER DOES NOT HAVE THE CARD YET
        assertFalse(player.getAssetCollection().getPotLuckCards().contains(getOutOfJailCard));
        
        //PERFORM THE CARD ACTION WHICH WILL GIVE THE PLAYER THE CARD
        getOutOfJailCard.getCardAction().performAction(freeParking, bank, player, players, getOutOfJailCard);
        
        //CHECK THAT THE PLAYER HAS THE CARD NOW
        assertTrue(player.getAssetCollection().getPotLuckCards().contains(getOutOfJailCard));
        
        //CHECK THAT THE BANK NO LONGER HAS THE CARD
        assertFalse(bank.getAssetCollection().getPotLuckCards().contains(getOutOfJailCard));
       
    }
    
    
    
    @Test
    public void playerPaysFreeParking() throws AssetOwner.AssetNotFoundException {
        PotLuckCard potLuckCard = null;
        
        for(PotLuckCard card : this.bank.getAssetCollection().getPotLuckCards()) {
            if(card.getCardAction().type.equals(CardAction.Type.PAY_FREE_PARKING)) {
                potLuckCard = card;
                break;
            }
        }
        
        //CHECK THAT THE BANK HAS THE POT LUCK CARD
        assertTrue(bank.getAssetCollection().getPotLuckCards().contains(potLuckCard));
        
        //REMOVE THE CARD FROM THE POT LUCK DECK IN BANK
        bank.getAssetCollection().getPotLuckCards().remove(potLuckCard);
        
        //PERFORM THE CARD ACTION
        potLuckCard.getCardAction().performAction(freeParking, bank, player, players, potLuckCard);
        
        //RECORD THE FEE THAT WAS PAID
        int taxFee = 1500 - player.getAssetCollection().getMoney();
        
        //CHECK THAT THE PLAYER'S BALANCE HAS BEEN UPDATED
        assertTrue(player.getAssetCollection().getMoney() == 1500 - taxFee);
        
        //CHECK THAT FREE PARKING'S BALANCE HAS UPDATED
        assertTrue(freeParking.getAssetCollection().getMoney() == taxFee);
        
        //CHECK THAT THE CARD HAS BEEN PUT BACK AT THE BOTTOM OF THE POT LUCK DECK IN BANK
        assertTrue(bank.getAssetCollection().getPotLuckCards().get(bank.getAssetCollection().getPotLuckCards().size()-1).equals(potLuckCard));
    }
    
}