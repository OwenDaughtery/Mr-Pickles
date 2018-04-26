/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.card;

import zytom.proptycoon.model.cell.UtilityPropertyCell;

/**
 *
 * @author utopia
 */
public class UtilityPropertyCard extends PropertyCard {
    private final int rentMultiplierOnSingle;
    private final int rentMultiplierOnPair;
    private final String description;
    
    public UtilityPropertyCard(UtilityPropertyCell cellRef, String title, int price, int rentMultiplierOnSingle,
            int rentMultiplierOnPair, String description) {
        super(cellRef, title, price);
        this.rentMultiplierOnSingle = rentMultiplierOnSingle;
        this.rentMultiplierOnPair = rentMultiplierOnPair;
        this.description = description;
    }
    
    public int getRent() {
        //TODO
        return 0;
    }
    
    public String getDescription() {
        return description;
    }
}
