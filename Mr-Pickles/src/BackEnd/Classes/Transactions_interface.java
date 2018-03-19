package BackEnd.Classes;

public interface Transactions_interface {

    /**
     * function that mitigates the exchange of cash from one player to another
     * Example cases : Rent payment for landing on properties
     *@param to : player sending cash
     *@param from : player receiving cash
     *@param value : value to be exchanged
     */
    public void cashPlayerToPlayer(Player to, Player from ,int value);

    /**
     * function mitigates the transfer of cash assets from a player to the bank
        @param from : player to transfer assets
        @param to : the Bank
        @param value : the value of the transaction
     */
    public void cashPlayerToBank(Player from , Bank to, int value);

    /**
     * function mitigates the transfer of cash assets from the bank to the player
     * example_use : if a player lands on free parking ,
     *             : if a player passes go ,
     *             : if a player mortgages a property
                   : if a player is rewarded by a potluck card .
     */
    public void cashBankToPlayer(Bank from , Player to , int value);

    /**
     * function mitigates the sale of a property from a player to another player
     * MAY NOT BE NEEDED . BUT HAS BEEN HINTED AT .
        @param from : the player whos card is wished to exchange
        @param to   : the player to receive the property
        @param card : the property to be exchanged
     */
    public void propPlayerToPlayer(Player from , Player to , PropertyCard card);

    /**
     * function mitigates the sale of a player owned property back to the bank
     * @param from : the player wishing to sell a property
     * @param to : the bank receiving the property
     * @param card : the property to be sold

     */
    public void propPlayerToBank(Player from , Bank to , PropertyCard card);


    /**
     *
     * function: mitigates the sale of an unsold property from the bank to the player
     * @param from : the Bank
     * @param to : the player
     * @param card : the property the player wishes to purchase

     */
    public void propBankToPlayer(Bank from , Player to , PropertyCard card);

}
