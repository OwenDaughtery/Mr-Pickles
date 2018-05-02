/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.card;

import zytom.proptycoon.model.cell.Cell;

/**
 *
 * @author utopia
 */
public class UtilityPropertyCard extends PropertyCard {
    private final int rentMultiplierOnSingle;
    private final int rentMultiplierOnPair;
    
    public UtilityPropertyCard(Cell cellRef, String title, int price, int rentMultiplierOnSingle,
            int rentMultiplierOnPair) {
        super(cellRef, title, price);
        this.rentMultiplierOnSingle = rentMultiplierOnSingle;
        this.rentMultiplierOnPair = rentMultiplierOnPair;
    }
    
    public int getRent() {
        //TODO
        return 0;
    }
    
}
