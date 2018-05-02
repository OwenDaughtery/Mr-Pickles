package zytom.proptycoon.model.card;

import zytom.proptycoon.model.cell.StreetPropertyCell;

/**
 * 
 * @author Ayman Free
 *
 * Stores rent prices and house prices.
 */
public class StreetPropertyCard extends PropertyCard {
    private final int[] rentCost;
    private final int houseCost;
    private final int hotelCost;
    private final int cellRef;

    /**
     *
     * @param rentCost
     * @param houseCost
     * @param hotelCost
     * @param cellRef
     */
    public StreetPropertyCard(int cellRef, String title, int price, int[] rentCost,
             int houseCost, int hotelCost) {
        super(cellRef, title, price);
        this.rentCost = rentCost;
        this.houseCost = houseCost;
        this.hotelCost = hotelCost;
        this.cellRef = cellRef;

    }

    /**
     * @author Ayman
     * @author Tom
     * @return the relevent rent that is needed to be paid for this property.
     */
    public int getRent(StreetPropertyCell cell) {
        if (cell.getNumberOfHotels() == 1) {
            return rentCost[5];
        }
        else if (cell.getNumberOfHouses() >=1 ) {
            return rentCost[cell.getNumberOfHouses()];
        }
        //If condition needs to be done
        else if (cell.getNumberOfHouses() == 0 )  {
            return rentCost[0]*2;
        }
        else{
            return rentCost[0];
        }

    }

    public int getHouseCost() {
        return houseCost;
    }

    public int getHotelCost() {
        return hotelCost;
    }
}
