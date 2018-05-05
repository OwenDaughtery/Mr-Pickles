package zytom.proptycoon.model.card;

import org.junit.Before;
import org.junit.Test;
import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.cell.Cell;
import zytom.proptycoon.model.cell.StationPropertyCell;
import zytom.proptycoon.model.cell.StreetPropertyCell;

import static org.junit.Assert.*;

public class StreetPropertyCardTest {


    StreetPropertyCard streetPropertyCard;
    StreetPropertyCell streetPropertyCell;
    Player player ;
    Dice dice;


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

        this.streetPropertyCell = new StreetPropertyCell("BRIGHTON ROAD");
        this.streetPropertyCard = new StreetPropertyCard(this.streetPropertyCell, "BRIGHTON ROAD", 200,rentCosts,50);
        this.player =  new Player("zenos", Player.TokenType.BOOT);
        this.dice = new Dice();
    }
    @Test
    public void getRent() throws StreetPropertyCell.ConstructionError {
        Dice dice = new Dice();
        Player player = new Player("zenos", Player.TokenType.BOOT);
        this.streetPropertyCell.addBuilding();
        int numberOfBuildings = this.streetPropertyCell.getNumberOfBuildings();
       int rent = this.streetPropertyCard.getRent(dice,player);
        assertTrue(100 == rent);
        assertTrue(numberOfBuildings == 1);
        this.streetPropertyCell.addBuilding();
         numberOfBuildings= this.streetPropertyCell.getNumberOfBuildings();
         rent= this.streetPropertyCard.getRent(dice,player);
        assertTrue(150 == rent);
        assertTrue(numberOfBuildings == 2);
    }

    @Test
    public void getBuildCost() {
        int buildcost =streetPropertyCard.getBuildCost();
        assertTrue(buildcost == 50);
    }

    @Test
    public void getTitle() {
        String title = streetPropertyCard.getTitle();
        assertTrue(title.equals("BRIGHTON ROAD"));
    }

    @Test
    public void getCellRef() {
        Cell cell = streetPropertyCard.getCellRef();
        assertTrue(cell.getTitle() == "BRIGHTON ROAD");
    }

    @Test
    public void getMortgageValue() {
        int mortgagevalue = streetPropertyCard.getMortgageValue();
        assertTrue(mortgagevalue == (streetPropertyCard.getPrice()/2));
    }

    @Test
    public void getPrice() {
        int price = streetPropertyCard.getPrice();
        assertTrue(price == 200);
    }


    @Test
    public void mortagage() {
        streetPropertyCard.mortagage();
        assertTrue(streetPropertyCard.isMortaged);
    }

    @Test
    public void unmortagage() {
        streetPropertyCard.mortagage();
        assertTrue(streetPropertyCard.isMortaged);
        streetPropertyCard.unmortagage();
        assertTrue(!streetPropertyCard.isMortaged);
    }
}