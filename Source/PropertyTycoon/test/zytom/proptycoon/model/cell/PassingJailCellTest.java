package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class PassingJailCellTest {

    @Test
    public void getTitle() {
        PassingJailCell passingJailCell = new PassingJailCell();
        assertTrue("JUST VISITING JAIL".equals(passingJailCell.getTitle()));
    }
}