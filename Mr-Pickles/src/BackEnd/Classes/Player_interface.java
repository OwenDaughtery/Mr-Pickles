package BackEnd.Classes;

public interface Player_interface {



    /**
     *  getter method , returns the name of the player
     * @return name of the player
     */

    public String getName();

    /**
     * getter method , returns the balance of the player
     * @return current cash that a player holds
     */
    public int getBalance();

    /**
     * getter method returns the number of Cards a player holds
     * @return number of cards a player is currently holding
     */
    public int getCards();

    /**
     * getter method , returns the current position of the player
     * @return the current position of the player
     */
    public int getPosition();


    /**
     * method moves a player around the board and changes the current position of the player
     * @param numberOfSpaces the number of spaces of which to move
     */
    public void move(int numberOfSpaces);


    /**
     * TODO // TOM PROVIDE EXPLAINATION PLEASE !
     *
     * @param position the position that a player is moving towards
     * @param movingForewards boolean signals forwards or backwards movement
     */
    public void moveTo(int position , boolean movingForwards);

}
