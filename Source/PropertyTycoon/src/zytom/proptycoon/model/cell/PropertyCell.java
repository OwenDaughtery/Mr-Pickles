/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.cell;
import zytom.proptycoon.model.card.PropertyCard;

/**
 *
 * @author Tom Chesters
 */
public abstract class PropertyCell extends Cell {
    
    private PropertyCard associatedCard;
    
    /**
     * @author Zenos Pavlakou
     * 
     * @param titleOfPropertyCell The name of the cell
     */
    public PropertyCell(String titleOfPropertyCell) {
        super(titleOfPropertyCell);
    }
    
    /**
     * @author Zenos Pavlakou
     * 
     * @param associatedCard The property card associated with this property
     * 
     * When creating the associated property card, how will constructor be initialized?
     */
    public void setAssociatedCard(PropertyCard associatedCard) {
        this.associatedCard = associatedCard;
    }
    
    /**
     * @author Zenos Pavlakou
     * 
     * @return The property card associated with this property
     */
    public PropertyCard getAssociatedCard() {
        return this.associatedCard;
    }
    
}
