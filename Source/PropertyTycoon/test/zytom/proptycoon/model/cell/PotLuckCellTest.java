package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class PotLuckCellTest {

    @Test
    public void getTitle() {
        PotLuckCell potLuckCell = new PotLuckCell();
        assertTrue("POT LUCK".equals(potLuckCell.getTitle()));
    }
}