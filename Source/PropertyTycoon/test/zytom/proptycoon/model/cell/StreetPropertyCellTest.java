package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard.Colour;

public class StreetPropertyCellTest {
    
    StreetPropertyCell  streetPropertyCell;
    
    @Before
    public void init() {
        this.streetPropertyCell = new StreetPropertyCell("CRAPPER STREET");
    }

    @Test
    public void getNumberOfBuildings() {
        assertEquals(0, this.streetPropertyCell.getNumberOfBuildings());
    }


    @Test
    public void setAndGetAssociatedCard() {
        int[] rentCosts = new int[4];
        StreetPropertyCard streetPropertyCard = new StreetPropertyCard(this.streetPropertyCell, "CRAPPER STREET",
                                                                        100, rentCosts, 500, Colour.GREEN);
        this.streetPropertyCell.setAssociatedCard(streetPropertyCard);
        assertEquals("CRAPPER STREET", this.streetPropertyCell.getAssociatedCard().getTitle());
    }


    @Test
    public void getTitle() {
        assertTrue("CRAPPER STREET".equals(this.streetPropertyCell.getTitle()));
    }
}