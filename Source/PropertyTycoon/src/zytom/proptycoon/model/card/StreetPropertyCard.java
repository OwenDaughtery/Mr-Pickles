package zytom.proptycoon.model.card;

import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.cell.Cell;
import zytom.proptycoon.model.cell.StreetPropertyCell;

/**
 * 
 * @author Ayman Free
 *
 * Stores rent prices and house prices.
 */
public class StreetPropertyCard extends PropertyCard {
    private final int[] rentCost;
    private final int buildCost;

    /**
     *
     * @param rentCost
     * @param title
     * @param price
     * @param cellRef
     * @param buildCost
     */
    public StreetPropertyCard(Cell cellRef, String title, int price, int[] rentCost,int buildCost) {
        super(cellRef, title, price);
        this.rentCost = rentCost;
        this.buildCost = buildCost;

    }

    public int getRent(Dice dice, Player player) {
        StreetPropertyCell propCell = (StreetPropertyCell)cellRef;
        if (propCell.getNumberOfHotels() == 1) {
            return rentCost[5];
        }
        else if (propCell.getNumberOfHouses() >=1 ) {
            return rentCost[propCell.getNumberOfHouses()];
        }
        //If condition needs to be done
        else if (propCell.getNumberOfHouses() == 0 )  {
            return rentCost[0]*2;
        }
        else{
            return rentCost[0];
        }
    }

    public int getBuildCost() {
        return this.buildCost;
    }
    
 

    @Override
    public String toString() {
        String info = super.toString();
        Dice dice = new Dice();
        Player player = new Player("Temp");
         info += "Cell Referenced" + "\n" +
                 "Base Rent  : " + this.rentCost[0]+"\n"+
                 "Build Cost : " + this.buildCost+"\n"+
                 "Current Rent :" + this.getRent(dice,player) + "\n";
        return info;


    }
}
