package zytom.proptycoon.model.card;

import zytom.proptycoon.model.cell.StationPropertyCell;

public class StationPropertyCard extends PropertyCard {
    private final int[] rentCost;
    
    public StationPropertyCard(StationPropertyCell cellRef, int mortgageValue, int[] rentCost) {
        super(cellRef, mortgageValue);
        this.rentCost = rentCost;
    }
}
