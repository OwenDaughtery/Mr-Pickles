/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tom Chesters
 */
public class DiceTest {
    
    public DiceTest() {
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

    /**
     * Test of getFirstValue method, of class Dice.
     */
    @Test
    public void testGetFirstValue() {
        System.out.println("getFirstValue");
        Dice instance = new Dice();
        int expResult = 0;
        int result = instance.getFirstValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecondValue method, of class Dice.
     */
    @Test
    public void testGetSecondValue() {
        System.out.println("getSecondValue");
        Dice instance = new Dice();
        int expResult = 0;
        int result = instance.getSecondValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of roll method, of class Dice.
     */
    @Test
    public void testRoll() {
        System.out.println("roll");
        Dice instance = new Dice();
        instance.roll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
