package zytom.proptycoon.model.card;

import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.cell.Cell;

public class StationPropertyCard extends PropertyCard {
    private final int[] rentCost;
    
    public StationPropertyCard(Cell cellRef, String title, int price, int[] rentCost) {
        super(cellRef, title, price);
        this.rentCost = rentCost;
    }

    public int getRent(Dice dice, Player owner) {
        return rentCost[
                    owner.getAssetCollection().getStationPropertyCards().size()
                ];
    }


    @Override
    public String toString(){
        String info = super.toString();
        info+= "Rent Costs: "+ rentCost.toString() + "\n" ;
        return info;
    }

}
