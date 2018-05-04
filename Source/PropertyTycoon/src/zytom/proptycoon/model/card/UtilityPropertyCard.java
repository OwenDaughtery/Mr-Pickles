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
