package zytom.proptycoon.model.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class PotLuckCardTest {
    
    //public PotLuckCard(String description, CardAction action)

    @Test
    public void getDescription() throws CardAction.InvalidActionException {
        
        CardAction action = new CardAction("BANK PAYS PLAYER", 100);
        ActionCard actionCard = new PotLuckCard("Collect £200", action);
        assertTrue("Collect £200".equals(actionCard.getDescription()));
    }
}