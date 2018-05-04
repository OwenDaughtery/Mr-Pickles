package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import zytom.proptycoon.model.card.UtilityPropertyCard;

public class UtilityPropertyCellTest {
    
    UtilityPropertyCell utilitiyPropertyCell;
    UtilityPropertyCard utilityPropertyCard;
    
    @Before
    public void init() {
        this.utilitiyPropertyCell = new UtilityPropertyCell("UTILITY PROPERTY");
        this.utilityPropertyCard = new UtilityPropertyCard(utilitiyPropertyCell,
                                                        "UTILITY PROPERTY",
                                                         500, 500, 500);
    }
    
    
    @Test
    public void setAndGetAssociatedCard() {
        this.utilitiyPropertyCell.setAssociatedCard(this.utilityPropertyCard);
        assertEquals(this.utilityPropertyCard, this.utilitiyPropertyCell.getAssociatedCard());
    }

    
    @Test
    public void getTitle() {
        assertTrue("UTILITY PROPERTY".equals(utilitiyPropertyCell.getTitle()));
    }
}