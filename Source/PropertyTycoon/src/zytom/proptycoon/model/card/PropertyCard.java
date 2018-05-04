package zytom.proptycoon.model.card;

import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.cell.Cell;

public abstract class PropertyCard extends Card {
    protected final Cell cellRef;
    protected final String title;
    protected final int price;
    protected static final double MORTGAGE_PROPORTION = 0.5;
    
    public PropertyCard(Cell cellRef, String title, int price) {
        this.cellRef = cellRef;
        this.title = title;
        this.price = price;
    }

    public String getTitle(){
        return title;
    }
    public Cell getCellRef() {
        return cellRef;
    }
    
    public int getMortgageValue() {
        return (int)(MORTGAGE_PROPORTION * (double)price);
    }

    public int getPrice() {
        return this.price;
    }

    public abstract int getRent(Dice dice, Player owner);


    @Override
    public String toString(){
        String info = "Card Title : "+ this.title + "\n"+
                "Cell Reference :"+ this.cellRef.toString() + "\n"+
                "Property Price : "+ this.price + "\n"+
                "Morgage Value : " + this.getMortgageValue() + "\n";
        return info;
    }
}