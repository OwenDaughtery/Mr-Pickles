package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class GoCellTest {

    @Test
    public void getTitle() {
        GoCell goCell = new GoCell();
        assertTrue("Go".equals(goCell.getTitle()));
    }
}