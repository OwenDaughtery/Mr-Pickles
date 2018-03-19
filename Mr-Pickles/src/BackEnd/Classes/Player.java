package BackEnd.Classes;

import java.util.ArrayList;

public class Player implements Player_interface{

    private int playerNumber;
    private String playerName;
    private int cashBalance;
    private ArrayList<PropertyCard> ownedProperties;
    private boolean inJail;
    private int currentSpace;


    public Player(int playerNumber,String playerName,int cashBalance,boolean inJail, int currentSpace){
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.cashBalance = cashBalance;
        this.inJail = inJail;
        this.currentSpace = currentSpace;
        this.ownedProperties = new ArrayList<PropertyCard>();
    }

    /**
     * @return player number value
     */
    @Override
    public int getPlayerNumber() {
        return this.playerNumber;
    }

    /**
     * @return player object cash balance
     */
    @Override
    public int getPlayerCashBalance() {
        return this.cashBalance;
    }

    /**
     * @param Cash Cash to set to the player at initialization of the game
     */
    @Override
    public void setCash(int Cash) {
        this.cashBalance = Cash;

    }

    /**
     * function puts current player in jail , updates gamestate
     */
    @Override
    public void putInJail() {
        this.inJail = true;
    }

    /**
     * @return whether or not the player object is in jail
     */
    @Override
    public boolean getisInJail() {
        if(this.inJail){
            return true;
        }else {
            return false;
        }
    }

    /**
     * @return an integer that represents the current space that the player object occupies
     */
    @Override
    public int getCurrentSpace() {
        return this.currentSpace;
    }

    /**
     * function set the current Cell for the player object to reside in
     *
     * @param space
     */
    @Override
    public void setCurrentCell(int space) {


    }

    /**
     * @return arraylist of property cards that the player object owns
     */
    @Override
    public ArrayList<PropertyCard> getOwnedProperties() {
        return null;
    }

    /**
     * function adds a property card to the players portfolio
     *
     * @param property
     */
    @Override
    public void addToPropertyPortfolio(PropertyCard property) {

    }

}
