package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class JailCellTest {

    @Test
    public void getTitle() {
        JailCell jailCell = new JailCell();
        assertTrue("JAIL CELL".equals(jailCell.getTitle()));
    }
}