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
    public void init() throws FileNotFoundException, CardAction.InvalidActionException, Board.CellNotFoundException {
        this.freeParking = new FreeParking();
        DeckCreator deckCreator = new DeckCreator();
        Board board = new Board(deckCreator.getPropertyData());
        ArrayList<PotLuckCard> potLuckDeck = deckCreator.createPotLuckDeck();
        ArrayList<OpportunityKnocksCard> oppKnocksDeck = deckCreator.createOpportunityKnocksDeck();
        ArrayList<StreetPropertyCard> streetDeck = deckCreator.createStreetPropertyCardDeck(board);
        ArrayList<StationPropertyCard> stationDeck = deckCreator.createStationPropertyCardDeck(board);
        ArrayList<UtilityPropertyCard> utilityDeck = deckCreator.createUtilityPropertyCardDeck(board);
        this.bank = new Bank(potLuckDeck, oppKnocksDeck, streetDeck, stationDeck, utilityDeck);
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
    
}