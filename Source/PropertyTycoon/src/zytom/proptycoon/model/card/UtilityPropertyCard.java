/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.card;

import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.cell.Cell;

import java.util.ArrayList;

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

    @Override
    public int getRent(Dice dice, Player owner) {
        return
                (dice.getFirstValue() + dice.getSecondValue()) *
                    (
                        (owner.getAssetCollection().getUtilityPropertyCards().size() == 2) ?
                            rentMultiplierOnPair : rentMultiplierOnSingle
                    )
        ;
    }
 
}
