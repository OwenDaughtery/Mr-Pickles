/**
 * @author Max Pattman
 * @version 0.1
 */
package BackEnd.Classes;

import java.util.ArrayList;

public interface Player_interface {

    /**
        @return player number value

     */
    public int getPlayerNumber();

    /**
    @return player object cash balance
     */
    public int getPlayerCashBalance();

    /**
        @param Cash Cash to set to the player at initialization of the game
     */
    public void setCash(int Cash);

    /**
     function puts current player in jail , updates gamestate
     */
    public void putInJail();

    /**
     @return whether or not the player object is in jail
     */
    public boolean getisInJail();


    /**
    @return an integer that represents the current space that the player object occupies
     */
    public int getCurrentSpace();

    /**
    function set the current Cell for the player object to reside in
     */
    public void setCurrentCell(int space);

    /**
    @return arraylist of property cards that the player object owns
     */
    public ArrayList<PropertyCard> getOwnedProperties();

    /**
     * function adds a property card to the players portfolio
     */
    public void addToPropertyPortfolio(PropertyCard property);


}
