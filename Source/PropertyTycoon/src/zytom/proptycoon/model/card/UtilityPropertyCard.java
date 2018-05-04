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
    
    /**
     *
     * @param cellRef The cell the Utility property card is associated with
     * @param title The name of the property
     * @param price The buy price of the property
     * @param rentMultiplierOnSingle The cost of rent when single utility property is owned by a single player
     * @param rentMultiplierOnPair The rent cost when both utility properties are owned by the same player
     */
    public UtilityPropertyCard(Cell cellRef, String title, int price, int rentMultiplierOnSingle,
                               int rentMultiplierOnPair) {
        super(cellRef, title, price);
        this.rentMultiplierOnSingle = rentMultiplierOnSingle;
        this.rentMultiplierOnPair = rentMultiplierOnPair;
    }
    
    /**
     * @author Zenos Pavlakou
     * @param diceValue The sum of the dice numbers rolled
     * @param propertyIsOwned True if the property is owned by a player
     * @param propertyOwnerOwnsOtherUtilityProperty True if this property and the other utility property is owned by the same player
     * @return The cost of rent
     */
    public int getRent(int diceValue, boolean propertyIsOwned, boolean propertyOwnerOwnsOtherUtilityProperty) {
        if(propertyIsOwned) {
            if(propertyOwnerOwnsOtherUtilityProperty) {
                return diceValue * this.rentMultiplierOnPair;
            }
            return diceValue * this.rentMultiplierOnSingle;
        }
        return diceValue; //should this return 0??
        
    }
 
}
