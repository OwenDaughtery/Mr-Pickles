package zytom.proptycoon.model.deckCreator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.card.CardAction;
import zytom.proptycoon.model.card.OpportunityKnocksCard;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.StationPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;

public class DeckCreatorTest {
    
    @Test 
    public void buildDeckCreator() throws FileNotFoundException {
        DeckCreator deckCreator = new DeckCreator();
        Assert.assertNotNull(deckCreator);
    }

    @Test
    public void createPotLuckDeck() throws FileNotFoundException {
        DeckCreator deckCreator = new DeckCreator();
        ArrayList<PotLuckCard> potLuckCards = deckCreator.createPotLuckDeck();
        Assert.assertEquals(16, potLuckCards.size());

    }

    @Test
    public void createOpportunityKnocksDeck() throws FileNotFoundException {
        DeckCreator deckCreator = new DeckCreator();
        ArrayList<OpportunityKnocksCard> opportunityKnocksCards = deckCreator.createOpportunityKnocksDeck();
        Assert.assertEquals(16, opportunityKnocksCards.size());
    }

    @Test
    public void createUtilityPropertyCardDeck() throws FileNotFoundException, Board.CellNotFoundException {
        DeckCreator deckCreator = new DeckCreator();
        Board board = new Board(deckCreator.getPropertyData());
        ArrayList<UtilityPropertyCard> utilityPropertyCards = deckCreator.createUtilityPropertyCardDeck(board);
        Assert.assertEquals(2, utilityPropertyCards.size());
    }

    @Test
    public void createStationPropertyCardDeck() throws FileNotFoundException, Board.CellNotFoundException {
        DeckCreator deckCreator = new DeckCreator();
        Board board = new Board(deckCreator.getPropertyData());
        ArrayList<StationPropertyCard> stationPropertyCards = deckCreator.createStationPropertyCardDeck(board);
        Assert.assertEquals(4, stationPropertyCards.size());
    }

    @Test
    public void createStreetPropertyCardDeck() throws FileNotFoundException, Board.CellNotFoundException {
        DeckCreator deckCreator = new DeckCreator();
        Board board = new Board(deckCreator.getPropertyData());
        ArrayList<StreetPropertyCard> streetPropertyCards = deckCreator.createStreetPropertyCardDeck(board);
        Assert.assertEquals(22, streetPropertyCards.size());
    }

    @Test
    public void getPropertyData() throws FileNotFoundException {
        DeckCreator deckCreator = new DeckCreator();
        Assert.assertEquals(40, deckCreator.getPropertyData().size());
    }
}
