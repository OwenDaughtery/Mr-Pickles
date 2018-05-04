package zytom.proptycoon.model.card;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import zytom.proptycoon.model.cell.UtilityPropertyCell;

public class UtilityPropertyCardTest {
    
    UtilityPropertyCard utilityPropertyCard;
    UtilityPropertyCell utilityPropertyCell;
    
    @Before
    public void init() {
        this.utilityPropertyCell = new UtilityPropertyCell("UTILITY");
        this.utilityPropertyCard = new UtilityPropertyCard(this.utilityPropertyCell, "UTILITY", 20, 4, 10);
    }
    
    @Test
    public void getRent() {
        //assertEquals()
    }

    @Test
    public void getTitle() {
        assertTrue("UTILITY".equals(this.utilityPropertyCard.getTitle()));
    }

    @Test
    public void getCellRef() {
        assertEquals(this.utilityPropertyCell, this.utilityPropertyCard.getCellRef());
    }

    @Test
    public void getMortgageValue() {
        assertEquals(10, this.utilityPropertyCard.getMortgageValue());
    }

    @Test
    public void getPrice() {
        assertEquals(20, this.utilityPropertyCard.getPrice());
    }
}