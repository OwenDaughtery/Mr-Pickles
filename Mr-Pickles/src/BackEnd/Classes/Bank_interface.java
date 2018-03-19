package BackEnd.Classes;

public interface Bank_interface {



    /**
     * function returns total funds of the bank
     */
    public int getCash();

    /**
     * function sets the cash assets of the bank
     */
    public void setCash(int value);

    /**
     * returns a Property Card object with the same name , if unsold and still owned by the bank
     * @param name : name of the card.
     */
    public PropertyCard getPropertyCard(String name);

    /**
     * function receives a property card from a player sale and stores the property card as an unsold property
     * @param card : property to be stored .
     */
    public void receivePropertyCard(PropertyCard card);
}
