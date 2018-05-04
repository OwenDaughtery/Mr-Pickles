package zytom.proptycoon.model.card;

import org.junit.Test;

import static org.junit.Assert.*;
import static zytom.proptycoon.model.card.CardAction.Type.BANK_PAYS_PLAYER;

public class OpportunityKnocksCardTest {

    @Test
    public void getDescription() throws CardAction.InvalidActionException {
        CardAction cardAction = new CardAction("BANK PAYS PLAYER",100);
        OpportunityKnocksCard okc = new OpportunityKnocksCard("ThisIsADescription",cardAction);

        assertTrue(okc.getDescription() == "ThisIsADescription");
        assertTrue(okc.action.type == BANK_PAYS_PLAYER);
    }
}