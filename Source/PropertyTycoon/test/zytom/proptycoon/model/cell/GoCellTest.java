package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class GoCellTest {

    @Test
    public void getTitle() {
        GoCell gocell = new GoCell();
        assertTrue(gocell.getTitle() == "Go");
    }
}