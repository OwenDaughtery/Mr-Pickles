package zytom.proptycoon.model.card;
import zytom.proptycoon.model.cell.Cell;

public abstract class PropertyCard extends card {
    private final Cell cellRef;
    private final String title;
    private final int price;
    private static final double MORTGAGE_PROPORTION = 0.5;
    
    public PropertyCard(Cell cellRef, String title, int price) {
        this.cellRef = cellRef;
        this.title = title;
        this.price = price;
    }
    
    public Cell getCellRef() {
        return cellRef;
    }
    
    public int getMortgageValue() {
        return (int)(MORTGAGE_PROPORTION * (double)price);
    }
}
