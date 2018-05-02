package zytom.proptycoon.model.card;

public abstract class PropertyCard extends Card {
    private final int cellRef;
    private final String title;
    private final int price;
    private static final double MORTGAGE_PROPORTION = 0.5;
    
    public PropertyCard(int cellRef, String title, int price) {
        this.cellRef = cellRef;
        this.title = title;
        this.price = price;
    }

    public String getTitle(){
        return title;
    }
    public int getCellRef() {
        return cellRef;
    }
    
    public int getMortgageValue() {
        return (int)(MORTGAGE_PROPORTION * (double)price);
    }


    @Override
    public String toString(){
        String info = "CELL Reference "
    }
}