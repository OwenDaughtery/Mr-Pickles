package BackEnd.Classes;

public interface Action_interface {


    /**
     *
     * @param type
     * @param value
     * @return
     */
    private Action _Action(Enum type, int value){
        return new Action(type,value);
    };


    /**
     *
     * Method Pays a player from the bank
     * @param bank
     * @param player
     * @param value
     */
    public void payPlayer(Bank bank, Player player , int value);

    /**
     *
     * @param bank
     * @param player
     * @param value
     */
    public void payBank(Bank bank , Player player , int value);

    /**
     *
     * @param player
     * @param value
     */
    public void movePlayer(Player player , int value);

    /**
     *
     * @param player
     * @param position
     * @param movingForwards
     */
    public void movePlayerTo(Player player , int position , boolean movingForwards );

    /**
     *
     * @param player
     * @param value
     * @return
     */
    public boolean payFreeParking(Player player , int value);


}
