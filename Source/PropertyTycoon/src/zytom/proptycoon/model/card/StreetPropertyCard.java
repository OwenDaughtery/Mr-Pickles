package zytom.proptycoon.model.card;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.cell.Cell;
import zytom.proptycoon.model.cell.StreetPropertyCell;

import java.util.ArrayList;

/**
 * 
 * @author Ayman Free
 *
 * Stores rent prices and house prices.
 */
public class StreetPropertyCard extends PropertyCard {
    private final int[] rentCost;
    private final int buildCost;

    private final Colour colour;


    public enum Colour{BROWN,BLUE,PURPLE,ORANGE,RED,YELLOW,GREEN,DEEPBLUE}
    /**
     *
     * @param rentCost
     * @param title
     * @param price
     * @param cellRef
     * @param buildCost
     * @param colour
     */
    public StreetPropertyCard(Cell cellRef, String title, int price, int[] rentCost,int buildCost, Colour colour) {
        super(cellRef, title, price);
        this.rentCost = rentCost;
        this.buildCost = buildCost;
        this.colour = colour;
    }

    public int getRent(Dice dice, Player player, Bank bank) throws ToManyDaymHousesException {
        StreetPropertyCell propCell = (StreetPropertyCell)cellRef;
        if (propCell.getNumberOfBuildings() > 0 && propCell.getNumberOfBuildings() < 6 ) {
            return rentCost[propCell.getNumberOfBuildings()];
        }
        //If condition needs to be done
        else if(propCell.getNumberOfBuildings() == 0 )  {
            ArrayList<StreetPropertyCard> propOfSameColour = bank.getGroupOfStreetProperties(colour);
            Boolean ownsAllProperly = true;
            for (StreetPropertyCard p: propOfSameColour
                    ) {
                if(!player.checkHasAsset(p)){
                    ownsAllProperly = false;
                }

            }
            if (ownsAllProperly){
                return rentCost[0]*2;
            } else {
                return rentCost[0];
            }
        }else{
            throw new ToManyDaymHousesException(propCell.getNumberOfBuildings());
        }
    }

    
    public int getBuildCost() {
        return this.buildCost;
    }
    
    
    public Colour getColour() {
        return this.colour;
    } 
 

    @Override
    public String toString() {
        String info = super.toString();
         info += "Cell Referenced" + "\n" +
                 "Base Rent  : " + this.rentCost[0]+"\n"+
                 "Build Cost : " + this.buildCost+"\n";
        return info;
    }

}
