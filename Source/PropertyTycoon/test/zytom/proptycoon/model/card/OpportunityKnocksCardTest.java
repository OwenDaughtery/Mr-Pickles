package zytom.proptycoon.model.card;

import org.junit.Test;

import static org.junit.Assert.*;
import static zytom.proptycoon.model.card.CardAction.Type.BANK_PAYS_PLAYER;

public class OpportunityKnocksCardTest {

    @Test
    public void getDescription() throws CardAction.InvalidActionException {
        CardAction cardAction = new CardAction("BANK PAYS PLAYER",100);
        OpportunityKnocksCard okc = new OpportunityKnocksCard("ThisIsADescription",cardAction);

        assertTrue("ThisIsADescription".equals(okc.getDescription()));
        assertTrue(okc.getCardAction().type == BANK_PAYS_PLAYER);
    }
}