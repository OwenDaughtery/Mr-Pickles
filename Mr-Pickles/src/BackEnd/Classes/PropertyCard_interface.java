
/**
    @author Max Pattman
    @version 0.1
 */
package BackEnd.Classes;

public interface PropertyCard_interface {


    /**

       @return True/False is the PropertyCard Mortgaged or not.

     */
    public boolean getisMortgaged();


    /**
     *
        function : sets the propertycard as mortgaged.
     */
    public void setIsMorgaged();

    /**
     * function : sets the propertycard to unmortagaged.

     */
    public void setNotMorgaged();


    /**
     *
     */
    public int getBaseRent();
    /**
     * function: gets the value of rent on a property with one house built.
     */
    public int getOneHouseRent();

    /**
     * function : gets the value of rent on a property with two houses built on it .
     */
    public int getTwoHouseRent();

    /**
    * function : gets the value of rent on a property with three houses built on it .
     */
    public int getThreeHouseRent();

    /**
     * function :  gets the value of rent on a property with four houses built on it .

     */
    public int getFourHouseRent();

    /**
     * function : gets the value of rent on a property with a hotel built on it .
     */
    public int getHotelRent();

    /**
     *  function : gets the number of houses currently on the property 0-5 , 5 being a hotel.
     */
    public int getNumHouses();


    /**
     * function : sets the number of houses currently on the property .
     */
    public int setNumHouses();


    /**
     * function : returns the colour group that the property is a part of .
     */
    public Enum getColourGroup();


}
