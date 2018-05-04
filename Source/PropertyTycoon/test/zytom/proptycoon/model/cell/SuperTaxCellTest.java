package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class SuperTaxCellTest {

    @Test
    public void getTitle() {
        SuperTaxCell superTaxCell = new SuperTaxCell();
        assertTrue("SUPER TAX".equals(superTaxCell.getTitle()));
    }
}