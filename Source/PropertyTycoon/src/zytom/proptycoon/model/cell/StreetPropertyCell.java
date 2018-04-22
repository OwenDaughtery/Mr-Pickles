package zytom.proptycoon.model.cell;

public class StreetPropertyCell extends PropertyCell {

    private int numberOfHouses;
    private int numberOfHotels;
    
    /**
     * @author Zenos Pavlakou
     * 
     * @param titleOfStreetProperty The name of the street property
     */
    public StreetPropertyCell(String titleOfStreetProperty) {
        super(titleOfStreetProperty);
        this.numberOfHouses = 0;
        this.numberOfHotels = 0;
    }
    
//    public boolean validateHouseAndHotelNumbers() {
//        ?????????
//    }
    
    /**
     * @author Zenos Pavlakou
     * 
     * @return The number of houses on this cell
     */
    public int getNumberOfHouses() {
        return this.numberOfHouses;
    }
  
    /**
     * @author Zenos Pavlakou
     * 
     * @return The number of hotels on this cell
     */
    public int getNumberOfHotels() {
        return this.numberOfHotels;
    }
}
