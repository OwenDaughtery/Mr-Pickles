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
     * @param title The name of the cell
     */
    public PropertyCell(String title) {
        super(title);
    }
    
    /**
     * @author Zenos Pavlakou
     * 
     * @param associatedCard The property card associated with this property
     */
    public void setAssociatedCard(PropertyCard associatedCard) {
        // When creating the associated property card, how will constructor be initialized?
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

    @Override
    public String toString(){
       String info = super.toString();
       info += "Associated Card Information : " + getAssociatedCard().toString()+"\n";
    }
    
}
