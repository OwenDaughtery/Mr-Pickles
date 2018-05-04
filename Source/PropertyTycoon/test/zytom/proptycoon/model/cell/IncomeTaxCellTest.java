package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class IncomeTaxCellTest {

    @Test
    public void getTitle() {
        IncomeTaxCell incomeTaxCell = new IncomeTaxCell();
        assertTrue("INCOME TAX".equals(incomeTaxCell.getTitle()));
    }
}