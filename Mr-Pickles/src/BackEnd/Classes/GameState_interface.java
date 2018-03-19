package BackEnd.Classes;

import java.util.ArrayList;

public interface GameState_interface {
    /**
     * Description:
     *  GameState will call the GameActions function GameActions.rolldice()
        @param player :the player that is going to be acted upon.
     */
    public void rollDice(Player player);

    /**
        @return : a list of player objects currently taking part int he game
     */
    public ArrayList<Player> getPlayers();

    /**
        @return : number of total turns taken in the game so far.
     */
    public int getTotalTurns();


    /**
        @return : return the player object whos current turn it is.
     */
    public Player getCurrentPlayerTurn();

    /**
        @return : an array list of players who are in jail.
     */
    public ArrayList<Player> getPlayersInJail();


    /**
        function sets the next players turn.
     */
    public void setNextPlayerTurn();


    /**
        function increments the total turns taken in the game.
     */
    public void IncrementTotalTurns();


    /**
     * @param player : player to be removed from jail if in jail.
        @return : player removed from jail
     */
    public Player removePlayerFromJail(Player player);

    /**
    @param player : player to be put in jail.
     */
    public void addPlayerToJail(Player player);

    /**
        @param player : player to be added to the game on initalization of the game
     */
    public void addPlayerToGame(Player player);

    /**
        @param player : player to be removed from the game , this could
                        be due to Bankruptcy or retirement
     */
    public void removePlayerFromGame(Player player);

}


