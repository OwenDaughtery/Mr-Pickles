package zytom.proptycoon.model.card;

import zytom.proptycoon.model.cell.StationPropertyCell;

public class StationPropertyCard extends PropertyCard {
    private final int[] rentCost;
    
    public StationPropertyCard(StationPropertyCell cellRef, String title, int price, int[] rentCost) {
        super(cellRef, title, price);
        this.rentCost = rentCost;
    }
}
