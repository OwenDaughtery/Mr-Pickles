package zytom.proptycoon.model.cell;

public class StreetPropertyCell extends PropertyCell {

    private int numberOfBuildings;

    
    /**
     * @author Zenos Pavlakou
     * 
     * @param titleOfStreetProperty The name of the street property
     */
    public StreetPropertyCell(String titleOfStreetProperty) {
        super(titleOfStreetProperty);
        this.numberOfBuildings = 0;

    }
    
    /**
     * @author Zenos Pavlakou
     * 
     * @return The number of houses on this cell
     */
    public int getNumberOfBuildings() {
        return this.numberOfBuildings;
    }
  

}
