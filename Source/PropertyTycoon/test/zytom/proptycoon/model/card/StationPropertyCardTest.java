package zytom.proptycoon.model.card;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import zytom.proptycoon.model.cell.StationPropertyCell;

public class StationPropertyCardTest {
    
    
    StationPropertyCard stationPropertyCard;
    StationPropertyCell stationPropertyCell;
    
    @Before
    public void init() {
        
        int[] rentCosts;
        rentCosts = new int[6];
        
        rentCosts[0] = 50;  // 0 houses
        rentCosts[1] = 100; // 1 House
        rentCosts[2] = 150; // 2 houses
        rentCosts[3] = 200; // 3 houses
        rentCosts[4] = 250; // 4 houses
        rentCosts[5] = 300; // 1 hotel
        
        this.stationPropertyCell = new StationPropertyCell("BRIGHTON STATION");
        this.stationPropertyCard = new StationPropertyCard(this.stationPropertyCell, "BRIGHTON STATION", 200,rentCosts);
    }

    
    @Test
    public void getTitle() {
        assertTrue("BRIGHTON STATION".equals(this.stationPropertyCard.getTitle()));
    }

    
    @Test
    public void getCellRef() {
        assertEquals(this.stationPropertyCell, this.stationPropertyCard.getCellRef());
    }

    
    @Test
    public void getMortgageValue() {
        assertEquals(100, this.stationPropertyCard.getMortgageValue());
    }
    
    
    @Test
    public void rentCostsValid() {
        
        int[] rentCosts = this.stationPropertyCard.getRentCosts();
        
        assertTrue(rentCosts[0] == 50 && rentCosts[1] == 100 && rentCosts[2] == 150 &&
                   rentCosts[3] == 200 && rentCosts[4] == 250 && rentCosts[5] == 300  );
    }

    
    @Test
    public void getPrice() {
        assertEquals(200, this.stationPropertyCard.getPrice());
    }
}