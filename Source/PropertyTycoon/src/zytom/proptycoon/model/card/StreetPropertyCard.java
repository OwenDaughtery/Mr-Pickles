package zytom.proptycoon.model.card;

import zytom.proptycoon.model.cell.StreetPropertyCell;

/**
 *
 @author Ayman Free
 *
 * Stores rent prices and house prices.
 */
public class StreetPropertyCard extends PropertyCard {
    private int[] rentCost;
    private int houseCost;
    private int hotelCost;
    private StreetPropertyCell cellRef;


    /**
     *
     * @param rentCost
     * @param houseCost
     * @param hotelCost
     * @param cellRef
     */
    public StreetPropertyCard(int[] rentCost, int houseCost, int hotelCost, StreetPropertyCell cellRef){
        this.rentCost = rentCost;
        this.houseCost = houseCost;
        this.hotelCost = hotelCost;
        this.cellRef = cellRef;
    }

    /**
     * Gets the relevent rent that is needed to be paid
     * @return int
     */
    public int getRent() {
        if(cellRef.getNumberOfHotels == 1){
            return rentCost[5]
        }
        else if(cellRef.getNumberOfHouses >=1){
            return rentCost[cellRef.getNumberOfHouses];
        }
        //If condition needs to be done
        else if('check owner has all'){
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
