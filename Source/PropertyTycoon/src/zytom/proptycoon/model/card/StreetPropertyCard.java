package zytom.proptycoon.model.card;

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
    private final Cell cellRef;

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
        this.cellRef = cellRef;

    }

    /**
     * @author Ayman
     * @author Tom
     * @param cell
     * @return the relevent rent that is needed to be paid for this property.
     */
    public int getRent(StreetPropertyCell cell) {
        if (cell.getNumberOfBuildings() == 5) {
            return rentCost[5];
        }
        else if (cell.getNumberOfBuildings() >=1 ) {
            return rentCost[cell.getNumberOfBuildings()];
        }
        //If condition needs to be done
        else if (cell.getNumberOfBuildings() == 0 )  {
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
         info += "Cell Referenced" + "\n" +
                 "Base Rent  : " + this.getRent((StreetPropertyCell) this.cellRef)+"\n"+
                 "Build Cost : " + this.buildCost+"\n"+
                 "Current Rent :" + this.getRent((StreetPropertyCell) this.cellRef) + "\n";
        return info;


    }
}
