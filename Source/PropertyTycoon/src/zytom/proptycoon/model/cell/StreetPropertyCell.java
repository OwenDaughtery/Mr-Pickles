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

    public void addBuilding() throws ConstructionError {
        if (this.getNumberOfBuildings() < 5){
            this.numberOfBuildings += 1;
        }else {
            throw new ConstructionError(this.getNumberOfBuildings());
        }
    }
    
    public void removeBuilding() throws ConstructionError {
        if (this.getNumberOfBuildings()>0){
            this.numberOfBuildings -= 1;
        }else {
            throw new ConstructionError(this.getNumberOfBuildings());
        }
    }
    
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
