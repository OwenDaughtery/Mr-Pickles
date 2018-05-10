package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import zytom.proptycoon.model.card.StreetPropertyCard;

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
    public void setAndGetAssociatedCard() throws StreetPropertyCard.InvalidColourGroupException {
        int[] rentCosts = new int[4];
        StreetPropertyCard streetPropertyCard = new StreetPropertyCard(this.streetPropertyCell, "CRAPPER STREET",
                                                                        100, rentCosts, 500, "GREEN");
        this.streetPropertyCell.setAssociatedCard(streetPropertyCard);
        assertEquals("CRAPPER STREET", this.streetPropertyCell.getAssociatedCard().getTitle());
    }


    @Test
    public void getTitle() {
        assertTrue("CRAPPER STREET".equals(this.streetPropertyCell.getTitle()));
    }
    
    @Test
    public void addBulding() throws StreetPropertyCell.ConstructionError {
        this.streetPropertyCell.addBuilding();
        assertTrue(this.streetPropertyCell.getNumberOfBuildings() == 1);
    }
    
    @Test
    public void cellHasHotel() throws StreetPropertyCell.ConstructionError {
        this.streetPropertyCell.addBuilding();
        this.streetPropertyCell.addBuilding();
        this.streetPropertyCell.addBuilding();
        this.streetPropertyCell.addBuilding();
        this.streetPropertyCell.addBuilding();
        assertTrue(this.streetPropertyCell.hasHotel());
    }
    
    @Test(expected = StreetPropertyCell.ConstructionError.class)
    public void noMoreThanFiveBuildings() throws StreetPropertyCell.ConstructionError {
        this.streetPropertyCell.addBuilding();
        this.streetPropertyCell.addBuilding();
        this.streetPropertyCell.addBuilding();
        this.streetPropertyCell.addBuilding();
        this.streetPropertyCell.addBuilding();
        this.streetPropertyCell.addBuilding();
    }
    
    @Test
    public void removeBuilding() throws StreetPropertyCell.ConstructionError {
        this.streetPropertyCell.addBuilding();
        assertTrue(this.streetPropertyCell.getNumberOfBuildings() == 1);
        this.streetPropertyCell.removeBuilding();
        assertTrue(this.streetPropertyCell.getNumberOfBuildings() == 0);
    }
    
    @Test (expected = StreetPropertyCell.ConstructionError.class)
    public void noLessThatZeroBuildings() throws StreetPropertyCell.ConstructionError {
        this.streetPropertyCell.removeBuilding();
    }
}