package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class GoToJailCellTest {

    @Test
    public void getTitle() {
        GoToJailCell goToGailCell = new GoToJailCell();
        assertTrue("GO TO JAIL".equals(goToGailCell.getTitle()));
    }
}