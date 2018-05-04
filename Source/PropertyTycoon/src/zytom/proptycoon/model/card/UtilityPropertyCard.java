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
    
    /**
     * @author Zenos Pavlakou
     * @param diceValue The sum of the dice numbers rolled
     * @param isSingle True if the utilitiy property is owned by a single player
     * @param isPair True if both utility properties are owned by the same player
     * @return The cost of rent
     */
    public int getRent(int diceValue, boolean isSingle, boolean isPair) {
        if(isPair) {
            return diceValue * this.rentMultiplierOnPair;
        } else if(isSingle) {
            return diceValue * this.rentMultiplierOnSingle;
        } else {
            return diceValue;
        }
    }
 
}
