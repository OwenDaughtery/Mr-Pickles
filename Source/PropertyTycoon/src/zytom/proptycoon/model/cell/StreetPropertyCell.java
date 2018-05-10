package zytom.proptycoon.model.cell;

import zytom.proptycoon.model.card.StreetPropertyCard;

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

    /**
     * Method adds a new building to the StreetPropertyCell if and only if the current number
     * of buildings is less than 5. 
     * @throws zytom.proptycoon.model.cell.StreetPropertyCell.ConstructionError 
     */
    public void addBuilding() throws ConstructionError {
        if (this.getNumberOfBuildings() < 5){
            this.numberOfBuildings += 1;
        }else {
            throw new ConstructionError(this.getNumberOfBuildings());
        }
    }
    
    /**
     * Method removes a building from the StreetPropertyCell so long as there is at least 
     * 1 property on the cell. 
     * @throws zytom.proptycoon.model.cell.StreetPropertyCell.ConstructionError 
     */
    public void removeBuilding() throws ConstructionError {
        if (this.getNumberOfBuildings()>0){
            this.numberOfBuildings -= 1;
        }else {
            throw new ConstructionError(this.getNumberOfBuildings());
        }
    }
    
    /**
     * @return True if the number of buildings is 5 (i.e. when there is a hotel)
     */
    public boolean hasHotel() {
        return this.numberOfBuildings == 5;
    }
    
    public static class ConstructionError extends Exception {
        public ConstructionError(int numberOfBuildings){
            super (
                    numberOfBuildings+" number of Buildings . there was a construction error"
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
