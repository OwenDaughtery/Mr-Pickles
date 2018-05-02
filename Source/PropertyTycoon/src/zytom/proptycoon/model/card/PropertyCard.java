package zytom.proptycoon.model.card;

import zytom.proptycoon.model.cell.Cell;

public abstract class PropertyCard extends Card {
    private final Cell cellRef;
    private final String title;
    private final int price;
    private static final double MORTGAGE_PROPORTION = 0.5;
    
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

    @Override
    public String toString(){
        String info = "Card Title : "+ this.title + "\n"+
                "Cell Reference :"+ this.cellRef.toString() + "\n"+
                "Property Price : "+ this.price + "\n"+
                "Morgage Value : " + this.getMortgageValue() + "\n";
        return info;
    }
}