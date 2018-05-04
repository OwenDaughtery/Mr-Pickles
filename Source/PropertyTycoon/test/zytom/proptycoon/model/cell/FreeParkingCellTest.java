package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class FreeParkingCellTest {

    @Test
    public void getTitle() {
        FreeParkingCell freeParkingCell = new FreeParkingCell();
        assertTrue("FREE PARKING".equals(freeParkingCell.getTitle()));
    }
}