package zytom.proptycoon.model.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardActionTest {

    @Test
    public void bankPaysPlayerActionCard() throws CardAction.InvalidActionException {
        CardAction card = new CardAction("BANK PAYS PLAYER", 100);
        assertTrue(card.type == card.type.BANK_PAYS_PLAYER);
        //System.out.println(card.type);
                
    }
    
    @Test
    public void execute() {
    }
}