package zytom.proptycoon.model;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
//import org.testng.annotations.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceTest {



   @Test
    public void getFirstValue() {
       Dice dice  = null;
       int value =  dice.getFirstValue();
       assertEquals(0,value);
    }

    @Test
    public void getSecondValue() {
       Dice dice =  new Dice();
       int value = dice.getSecondValue();
       assertEquals(0,value);
    }

    @Test
    public void roll() {
       Dice dice =  new Dice();
       dice.roll();
       assertTrue(dice.getFirstValue() != 0);
       assertTrue(dice.getSecondValue() != 0 );
    }
}