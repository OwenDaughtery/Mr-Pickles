package zytom.proptycoon.model.card;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.cell.Cell;

/**
 * Class is extended by StationPropertyCard, StreetPropertyCard, and UtilityPropertyCard
 * @author zenos
 */
public abstract class PropertyCard extends Card {
    protected final Cell cellRef;
    protected final String title;
    protected final int price;
    protected static final double MORTGAGE_PROPORTION = 0.5;
    public boolean isMortaged;
    
    /**
     * @param cellRef The cell the PropertyCard is associated with
     * @param title The title of the PropertyCard
     * @param price The price of the PropertyCard
     */
    public PropertyCard(Cell cellRef, String title, int price) {
        this.cellRef = cellRef;
        this.title = title;
        this.price = price;
        this.isMortaged = false;
    }

    /**
     * @return The title of the PropertyCard
     */
    public String getTitle(){
        return title;
    }
    
    /**
     * @return The cell associated with the PropertyCard
     */
    public Cell getCellRef() {
        return cellRef;
    }
    
    /**
     * @return The mortgage value of the PropertyCard
     */
    public int getMortgageValue() {
        return (int)(MORTGAGE_PROPORTION * (double)price);
    }

    /**
     * @return The price of the PropertyCard
     */
    public int getPrice() {
        return this.price;
    }

    public abstract int getRent(Dice dice, Player owner,Bank bank);

    /**
     * Sets the PropertyCard as mortgaged 
     */
    public void mortagage(){
        this.isMortaged = true;
    }
    
    /**
     * Unmortgages the PropertyCard
     */
    public void unmortagage(){
        this.isMortaged =false;
    }
    
    
    @Override
    public String toString(){
        String info = "Card Title : "+ this.title + "\n"+
                "Cell Reference :"+ this.cellRef.toString() + "\n"+
                "Property Price : "+ this.price + "\n"+
                "Morgage Value : " + this.getMortgageValue() + "\n";
        return info;
    }


    public static class TooManyHousesException extends Exception {
        public TooManyHousesException(int numberOfHouses){
            super (
                    "Can't have "+String.valueOf(numberOfHouses) +"houses on property"
            );
        }
        /**
         * Gets the message
         * @return The exception message.
         */
        @Override
        public String getMessage()
        {
            return super.getMessage();
        }
    }
}