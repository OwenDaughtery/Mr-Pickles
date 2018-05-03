package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class FreeParkingCellTest {

    @Test
    public void getTitle() {
        FreeParkingCell fpCell = new FreeParkingCell();
        assertTrue(fpCell.getTitle() == "Free Parking");
    }
}