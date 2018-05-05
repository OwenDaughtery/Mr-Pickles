package zytom.proptycoon.model.card;

import org.junit.Before;
import org.junit.Test;
import zytom.proptycoon.model.cell.StationPropertyCell;

import static org.junit.Assert.*;

public class StreetPropertyCardTest {


    StreetPropertyCard StreetPropertyCard;

    @Before
    public void init() {

        int[] rentCosts;
        rentCosts = new int[6];

        rentCosts[0] = 50;  // 0 houses
        rentCosts[1] = 100; // 1 house
        rentCosts[2] = 150; // 2 houses
        rentCosts[3] = 200; // 3 houses
        rentCosts[4] = 250; // 4 houses
        rentCosts[5] = 300; // 1 hotel
//
//        this.stationPropertyCell = new StationPropertyCell("BRIGHTON STATION");
//        this.stationPropertyCard = new StationPropertyCard(this.stationPropertyCell, "BRIGHTON STATION", 200,rentCosts);
    }
//    @Test
//    public void getRent() {
//        StreetPropertyCard streetPropertyCard = new StreetPropertyCard();
//    }

    @Test
    public void getBuildCost() {
    }

    @Test
    public void getTitle() {
    }

    @Test
    public void getCellRef() {
    }

    @Test
    public void getMortgageValue() {
    }

    @Test
    public void getPrice() {
    }

    @Test
    public void getRent1() {
    }

    @Test
    public void mortagage() {
    }

    @Test
    public void unmortagage() {
    }
}