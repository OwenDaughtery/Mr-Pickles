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
        PotLuckCard getOutOfJailCard  = findPotLuckCard(CardAction.Type.GET_OUT_OF_JAIL_POT_LUCK);
        
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
        PotLuckCard potLuckCard = findPotLuckCard(CardAction.Type.PAY_FREE_PARKING);
        
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
    
    
    
    @Test
    public void playerPaysBank() throws AssetOwner.AssetNotFoundException {
        PotLuckCard potLuckCard = findPotLuckCard(CardAction.Type.PLAYER_PAYS_BANK);
        
        //CHECK THAT THE BANK HAS THE POT LUCK CARD
        assertTrue(bank.getAssetCollection().getPotLuckCards().contains(potLuckCard));      
        
        //REMOVE THE CARD FROM THE POT LUCK DECK IN BANK
        bank.getAssetCollection().getPotLuckCards().remove(potLuckCard);
        
        //PERFORM THE CARD ACTION
        potLuckCard.getCardAction().performAction(freeParking, bank, player, players, potLuckCard);
        
        //RECORD THE FEE THAT WAS PAID
        int bankFee = 1500 - player.getAssetCollection().getMoney();
        
        //CHECK THAT THE PLAYER'S BALANCE HAS BEEN UPDATED
        assertTrue(player.getAssetCollection().getMoney() == 1500 - bankFee);
        
        //CHECK THAT THE CARD HAS BEEN PUT BACK AT THE BOTTOM OF THE POT LUCK DECK IN BANK
        assertTrue(bank.getAssetCollection().getPotLuckCards().get(bank.getAssetCollection().getPotLuckCards().size()-1).equals(potLuckCard));
    }
    
    
    @Test
    public void playerGoesToJail() throws AssetOwner.AssetNotFoundException {
        PotLuckCard potLuckCard = findPotLuckCard(CardAction.Type.GO_TO_JAIL);
        
        //CHECK THAT THE BANK HAS THE POT LUCK CARD
        assertTrue(bank.getAssetCollection().getPotLuckCards().contains(potLuckCard));      
        
        //REMOVE THE CARD FROM THE POT LUCK DECK IN BANK
        bank.getAssetCollection().getPotLuckCards().remove(potLuckCard);
        
        //PERFORM THE CARD ACTION
        potLuckCard.getCardAction().performAction(freeParking, bank, player, players, potLuckCard);
        
        //CHECK THAT THE PLAYER HAS BEEN MOVED TO THE JAIL CELL
        assertTrue(player.getPosition() == 40);
        
        //CHECK THAT THE CARD HAS BEEN PUT BACK AT THE BOTTOM OF THE POT LUCK DECK IN BANK
        assertTrue(bank.getAssetCollection().getPotLuckCards().get(bank.getAssetCollection().getPotLuckCards().size()-1).equals(potLuckCard));
    }
    
    
    @Test
    public void playerMovesForward() throws AssetOwner.AssetNotFoundException {
        PotLuckCard potLuckCard = findPotLuckCard(CardAction.Type.MOVE_FORWARD);
        
        //CHECK THAT THE BANK HAS THE POT LUCK CARD
        assertTrue(bank.getAssetCollection().getPotLuckCards().contains(potLuckCard));      
        
        //REMOVE THE CARD FROM THE POT LUCK DECK IN BANK
        bank.getAssetCollection().getPotLuckCards().remove(potLuckCard);
        
        //PERFORM THE CARD ACTION
        potLuckCard.getCardAction().performAction(freeParking, bank, player, players, potLuckCard);
        
        assertTrue(player.getPosition() == 0);
    }
    
    
    @Test
    public void collectFromAll() throws AssetOwner.AssetNotFoundException {
        
        Player max = new Player("max", Player.TokenType.BOOT);
        Player tom = new Player("tom", Player.TokenType.CAT);
        Player ayman = new Player("ayman", Player.TokenType.HATSTAND);
        
        players.add(max);
        players.add(tom);
        players.add(ayman);
        
        PotLuckCard potLuckCard = findPotLuckCard(CardAction.Type.COLLECT_FROM_ALL);
        
        //CHECK THAT THE BANK HAS THE POT LUCK CARD
        assertTrue(bank.getAssetCollection().getPotLuckCards().contains(potLuckCard));      
        
        //REMOVE THE CARD FROM THE POT LUCK DECK IN BANK
        bank.getAssetCollection().getPotLuckCards().remove(potLuckCard);
        
        //PERFORM THE CARD ACTION
        potLuckCard.getCardAction().performAction(freeParking, bank, player, players, potLuckCard);
        
        //CHECK THAT PLAYER HAS RECEIVED £10 FROM EACH PLAYER
        assertTrue(player.getAssetCollection().getMoney() == 1530);
        
        //CHECK THAT EACH PLAYER IS MINUS £10
        assertTrue(max.getAssetCollection().getMoney() == 1490);
        assertTrue(tom.getAssetCollection().getMoney() == 1490);
        assertTrue(ayman.getAssetCollection().getMoney() == 1490);
        
    }
    
    public PotLuckCard findPotLuckCard(CardAction.Type type){
        for(PotLuckCard card : this.bank.getAssetCollection().getPotLuckCards()) {
            if(card.getCardAction().type.equals(type)) {
                return card;
            }
        }
        return null;
    }
    
}