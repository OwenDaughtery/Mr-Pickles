package zytom.proptycoon.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class OpportunityKnocksCellTest {

    @Test
    public void getTitle() {
        OpportunityKnocksCell opportunityKnocksCell = new OpportunityKnocksCell();
        assertTrue("OPPORTUNITY KNOCKS".equals(opportunityKnocksCell.getTitle()));
    }
}