package zytom.proptycoon.model.deckCreator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import org.junit.Before;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.card.CardAction;
import zytom.proptycoon.model.card.OpportunityKnocksCard;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.StationPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;

public class DeckCreatorTest {
    
    DeckCreator deckCreator;
    
    @Before 
    public void init() throws FileNotFoundException {
        this.deckCreator = new DeckCreator();
    }
    
    
    @Test 
    public void buildDeckCreator() throws FileNotFoundException {
        Assert.assertNotNull(this.deckCreator);
    }

    @Test
    public void createPotLuckDeck() throws FileNotFoundException, CardAction.InvalidActionException {
        ArrayList<PotLuckCard> potLuckCards = this.deckCreator.createPotLuckDeck();
        Assert.assertEquals(16, potLuckCards.size());

    }

    @Test
    public void createOpportunityKnocksDeck() throws FileNotFoundException, CardAction.InvalidActionException {
        ArrayList<OpportunityKnocksCard> opportunityKnocksCards = this.deckCreator.createOpportunityKnocksDeck();
        Assert.assertEquals(16, opportunityKnocksCards.size());
    }

    @Test
    public void createUtilityPropertyCardDeck() throws FileNotFoundException, Board.CellNotFoundException {
        Board board = new Board(this.deckCreator.getPropertyData());
        ArrayList<UtilityPropertyCard> utilityPropertyCards = this.deckCreator.createUtilityPropertyCardDeck(board);
        Assert.assertEquals(2, utilityPropertyCards.size());
    }

    @Test
    public void createStationPropertyCardDeck() throws FileNotFoundException, Board.CellNotFoundException {
        Board board = new Board(this.deckCreator.getPropertyData());
        ArrayList<StationPropertyCard> stationPropertyCards = this.deckCreator.createStationPropertyCardDeck(board);
        Assert.assertEquals(4, stationPropertyCards.size());
    }

    @Test
    public void createStreetPropertyCardDeck() throws FileNotFoundException, Board.CellNotFoundException {
        Board board = new Board(this.deckCreator.getPropertyData());
        ArrayList<StreetPropertyCard> streetPropertyCards = this.deckCreator.createStreetPropertyCardDeck(board);
        Assert.assertEquals(22, streetPropertyCards.size());
    }

    @Test
    public void getPropertyData() throws FileNotFoundException {
        Assert.assertEquals(40, this.deckCreator.getPropertyData().size());
    }
}
