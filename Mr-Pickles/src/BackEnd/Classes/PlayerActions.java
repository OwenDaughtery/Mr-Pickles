package BackEnd.Classes;

public class PlayerActions implements PlayerActions_interface {

    public PlayerActions(){

    }

    /**
     * function will call transactions that will mitigate the interaction between the player and the bank to sell
     * a house .
     *
     * @param player player wishing to sell a house they have built
     * @param card   the specific property that has one or more houses built on it that the player owns
     */
    @Override
    public void sellHouse(Player player, PropertyCard card) {

    }

    /**
     * function will call transactions that will mitigate the interaction between the player and
     * the bank for this purchase
     *
     * @param player player wishing to buy a house for one of their properties
     * @param card   the specific property they wish the house to be build on
     */
    @Override
    public void buyHouse(Player player, PropertyCard card) {

    }

    /**
     * function will call the transactions class to mitigate the purchase of a property from the bank
     *
     * @param player
     * @param card
     */
    @Override
    public void buyProperty(Player player, PropertyCard card) {

    }

    /**
     * function will call the transactions class to mitigate selling to the bank.
     *
     * @param player : the player wishing to sell
     * @param card   : the card that the selected player would like to sell
     */
    @Override
    public void sellProperty(Player player, PropertyCard card) {

    }

    /**
     * function morgagesProperty
     *
     * @param player
     * @param card
     */
    @Override
    public void morgageProperty(Player player, PropertyCard card) {

    }

    /**
     * function that Unmortgages a player owned property that is mortagaged
     *
     * @param player
     * @param card
     */
    @Override
    public void unmortgageProperty(Player player, PropertyCard card) {

    }

    /**
     * function tells the game state that this player is retireing from the game
     *
     * @param player
     */
    @Override
    public void retire(Player player) {

    }

    /**
     * function calls Transactions class to mitigate paying of fine to the bank
     *
     * @param player player that needs to pay the jail fine
     */
    @Override
    public void payJailFine(Player player) {

    }
}
