package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import zytom.proptycoon.model.card.StationPropertyCard;

public class StationPropertyCellTest {
    
    StationPropertyCell stationPropertyCell;
    
    @Before
    public void init() {
        this.stationPropertyCell = new StationPropertyCell("BRIGHTON STATION");
    }

    @Test
    public void setAndGetAssociatedCard() {
        int[] rentCosts = new int[4];
        StationPropertyCard stationPropertyCard = new StationPropertyCard(this.stationPropertyCell, "BRIGHTON STATION",
                                                                            100, rentCosts);
        this.stationPropertyCell.setAssociatedCard(stationPropertyCard);
        assertEquals("BRIGHTON STATION", this.stationPropertyCell.getAssociatedCard().getTitle());
    }

    
    @Test
    public void getTitle() {
        assertTrue("BRIGHTON STATION".equals(this.stationPropertyCell.getTitle()));
    }
}