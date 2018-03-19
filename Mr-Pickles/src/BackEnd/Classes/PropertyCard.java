package BackEnd.Classes;

public class PropertyCard implements PropertyCard_interface {


    public PropertyCard(){

    }


    /**
     * @return True/False is the PropertyCard Mortgaged or not.
     */
    @Override
    public boolean getisMortgaged() {
        return false;
    }

    /**
     * function : sets the propertycard as mortgaged.
     */
    @Override
    public void setIsMorgaged() {

    }

    /**
     * function : sets the propertycard to unmortagaged.
     */
    @Override
    public void setNotMorgaged() {

    }

    /**
     *
     */
    @Override
    public int getBaseRent() {
        return 0;
    }

    /**
     * function: gets the value of rent on a property with one house built.
     */
    @Override
    public int getOneHouseRent() {
        return 0;
    }

    /**
     * function : gets the value of rent on a property with two houses built on it .
     */
    @Override
    public int getTwoHouseRent() {
        return 0;
    }

    /**
     * function : gets the value of rent on a property with three houses built on it .
     */
    @Override
    public int getThreeHouseRent() {
        return 0;
    }

    /**
     * function :  gets the value of rent on a property with four houses built on it .
     */
    @Override
    public int getFourHouseRent() {
        return 0;
    }

    /**
     * function : gets the value of rent on a property with a hotel built on it .
     */
    @Override
    public int getHotelRent() {
        return 0;
    }

    /**
     * function : gets the number of houses currently on the property 0-5 , 5 being a hotel.
     */
    @Override
    public int getNumHouses() {
        return 0;
    }

    /**
     * function : sets the number of houses currently on the property .
     */
    @Override
    public int setNumHouses() {
        return 0;
    }

    /**
     * function : returns the colour group that the property is a part of .
     */
    @Override
    public Enum getColourGroup() {
        return null;
    }
}