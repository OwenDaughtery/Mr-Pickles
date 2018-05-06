/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.preGame.gUITest;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.view.StreetPropertyCardPanel;

/**
 *
 * @author aymanfree
 */
public class StreetPropertyCardPanelTest {
    
    public StreetPropertyCardPanelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void makeCard() {
        String title = "Cunt";
        int price = 50;
        int[] rentCost = {5, 10, 15, 20, 50};
        int buildCost = 50;
        StreetPropertyCard.Colour colour = StreetPropertyCard.Colour.DEEPBLUE;
        //System.out.println(rentCost[0]);
        StreetPropertyCardPanel panel = new StreetPropertyCardPanel(title, price, rentCost, buildCost, colour);
    }
}
