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
 * Stores rent prices and House prices.
 */
public class StreetPropertyCard extends PropertyCard {
    private final int[] rentCost;
    private final int buildCost;

    private Colour colour;


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
    public StreetPropertyCard(Cell cellRef, String title, int price, int[] rentCost,int buildCost, String colour) throws InvalidColourGroupException {
        super(cellRef, title, price);
        this.rentCost = rentCost;
        this.buildCost = buildCost;
        
        switch(colour) {
            case "BROWN":
                this.colour = Colour.BROWN;
                break;
            case "DEEPBLUE":
                this.colour = Colour.DEEPBLUE;
                break;
            case "BLUE":
                this.colour = Colour.BLUE;
                break;
            case "ORANGE":
                this.colour = Colour.ORANGE;
                break;
            case "YELLOW":
                this.colour = Colour.YELLOW;
                break;
            case "PURPLE":
                this.colour = Colour.PURPLE;
                break;
            case "RED":
                this.colour = Colour.RED;
                break;
            case "GREEN":
                this.colour = Colour.GREEN;
                break;
        }
        
        if(this.colour == null) {
            throw new InvalidColourGroupException(colour);
        }

    }

    public int getRent(Dice dice, Player player, Bank bank) throws TooManyHousesException {
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
            throw new TooManyHousesException(propCell.getNumberOfBuildings());
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
    
    
    public static class InvalidColourGroupException extends Exception {
        
        /**
         * Generate the exception message.
         * @param errorMessage
         */
        public InvalidColourGroupException(
                String errorMessage
        ) {
            super ("Invalid group colour: " + errorMessage);
        }


        /**
         * @return The exception message.
         */
        @Override
        public String getMessage()
        {
            return super.getMessage();
        }
    }

}
