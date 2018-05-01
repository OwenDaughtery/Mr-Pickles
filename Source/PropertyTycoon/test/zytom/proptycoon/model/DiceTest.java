package zytom.proptycoon.model;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
//import org.testng.annotations.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceTest {

    Dice dice  = new Dice();

   @Test
    public void getFirstValue() {
       int value =  dice.getFirstValue();
       assertEquals(0,value);
    }

    @Test
    public void getSecondValue() {
       int value = dice.getSecondValue();
       assertEquals(0,value);
    }

    @Test
    public void roll() {
       dice.roll();
       assertTrue(dice.getFirstValue() != 0);
       assertTrue(dice.getSecondValue() != 0 );
    }
}