package zytom.proptycoon.model.card;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import zytom.proptycoon.model.card.CardAction.InvalidActionException;

public class ActionCardTest {
    
    String descriptionOfOpportunityKnocks;
    CardAction cardActionOfOpportunityKnocks;
    ActionCard opportunityKnocksCard;
    
    @Before
    public void init() throws InvalidActionException {
        descriptionOfOpportunityKnocks = "COLLECT £200";
        cardActionOfOpportunityKnocks = new CardAction("BANK PAYS PLAYER", 200);
        opportunityKnocksCard = new OpportunityKnocksCard(descriptionOfOpportunityKnocks, cardActionOfOpportunityKnocks);
    }

    @Test
    public void getDescription() {
        assertTrue("COLLECT £200".equals(opportunityKnocksCard.getDescription()));
    }
}