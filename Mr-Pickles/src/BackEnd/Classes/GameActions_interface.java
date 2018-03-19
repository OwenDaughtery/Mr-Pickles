package BackEnd.Classes;

public interface GameActions_interface {
    
    /**
     * Function will initialize the entire game and is called when a new game is created

     */
    public void initializeGame();


    /**
     *function : when a player has to pay tax , use transactions class to mitigate interaction
     * between player and the bank.
     *
        @param player : player to pay tax to the bank
     */
    public void payTax(Player player);

    /**
     * function sends the player to jail
        @param player : player to send to jail
     */
    public void sendPlayerToJail(Player player);

    /**
     * function sends the player to the selected space on the board
     */
    public void sendPlayerToSpace(Player player , int space);

    /**
     function rolls the dice for the selected player and moves the player to the selected board space
     @param player player to be moved
     */
    public void rollDice(Player player);

    /**
     function called when the player passes go , use the transactions
     class to mitigate payment from the bank to the player
     @param player : player that has passed go .
     */
    public void passedGo(Player player);

    /**
     function : when a player lands on free parking , use the transactions class to mitigate payment from the bank to the player
     @param player : player to receive free parking reward .
     */
    public void freeParking(Player player);


    /**
     function : when a player lands on a pot luck square they take part in the functionality of that card
     @param player : player to receive card .
     */
    public void drawPotluck(Player player);

    /**
     * function : when a player lands on a pot luck square they take part in the functionality of that card
     * @param player player to receive oppertunity knocks card

     */
    public void drawOppertunityKnocks(Player player);

    
}
