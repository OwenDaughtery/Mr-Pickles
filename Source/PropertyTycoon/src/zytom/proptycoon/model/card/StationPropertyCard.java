package zytom.proptycoon.model.card;

import zytom.proptycoon.model.cell.Cell;
import zytom.proptycoon.model.cell.StationPropertyCell;

public class StationPropertyCard extends PropertyCard {
    private final int[] rentCost;
    
    public StationPropertyCard(Cell cellRef, String title, int price, int[] rentCost) {
        super(cellRef, title, price);
        this.rentCost = rentCost;
    }

    @Override
    public String toString(){
        String info = super.toString();
        info+= "Rent Costs: "+ rentCost.toString() + "\n" ;
        return info;
    }

}
