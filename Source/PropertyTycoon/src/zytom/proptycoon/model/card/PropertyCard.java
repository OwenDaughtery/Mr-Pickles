package zytom.proptycoon.model.card;
import zytom.proptycoon.model.cell.Cell;

public abstract class PropertyCard {
    private final Cell cellRef;
    private final int mortgageValue;
    
    public PropertyCard(Cell cellRef, int mortgageValue) {
        this.cellRef = cellRef;
        this.mortgageValue = mortgageValue;
    }
    
    public Cell getCellRef() {
        return cellRef;
    }
    
    public int getMortgageValue() {
        return mortgageValue;
    }
}
