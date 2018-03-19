package BackEnd.Classes;

import java.util.ArrayList;

public class Bank implements Bank_interface {

    public int BankFunds ;
    public ArrayList<PropertyCard> unsoldProperties;

    public Bank (){

    }




    /**
     * function returns total funds of the bank
     */
    @Override
    public int getCash() {
        return 0;
    }

    /**
     * function sets the cash assets of the bank
     *
     * @param value
     */
    @Override
    public void setCash(int value) {

    }

    /**
     * returns a Property Card object with the same name , if unsold and still owned by the bank
     *
     * @param name : name of the card.
     */
    @Override
    public PropertyCard getPropertyCard(String name) {
        return null;
    }

    /**
     * function receives a property card from a player sale and stores the property card as an unsold property
     *
     * @param card : property to be stored .
     */
    @Override
    public void receivePropertyCard(PropertyCard card) {

    }
}
