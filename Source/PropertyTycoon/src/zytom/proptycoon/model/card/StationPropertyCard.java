package zytom.proptycoon.model.card;

import java.util.Arrays;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.cell.Cell;

/**
 * Class represents a station property card
 * @author zenos
 */
public class StationPropertyCard extends PropertyCard {
    private final int[] rentCost;
    
    /**
     * Constructor assigns the StationPropertyCard with the card's associated cell,
     * the name of the PropertyCard, the buy price of the ProertyCard and the costs
     * of rent. 
     * @param cellRef The cell associated with the PropertyCard
     * @param title The name of the PropertyCard
     * @param price The buy price of the PropertyCard
     * @param rentCost The array of rent prices (i.e. prices when there are no buildings,
     * 1 house, 2 houses, 3 houses, 4 houses and a hotel). 
     */
    public StationPropertyCard(Cell cellRef, String title, int price, int[] rentCost) {
        super(cellRef, title, price);
        this.rentCost = rentCost;
    }
    
    /**
     * @return The costs of rent
     */
    public int[] getRentCosts() {
        return this.rentCost;
    }

    /**
     * Station property rent is decided by how many stations a player ownes.
     * @param dice 
     * @param owner
     * @param bank
     * @return The cost of rent
     */
    public int getRent(Dice dice, Player owner, Bank bank) {
        return rentCost[
                    owner.getAssetCollection().getStationPropertyCards().size()
                ];
    }


    @Override
    public String toString(){
        String info = super.toString();
        info+= "Rent Costs: "+ Arrays.toString(rentCost) + "\n" ;
        return info;
    }

}
