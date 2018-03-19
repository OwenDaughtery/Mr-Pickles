package BackEnd.Classes;

import java.util.ArrayList;

public class GameState implements GameState_interface {
    GameActions gameActions;



    public GameState(){
        this.gameActions = new GameActions();
    }

    /**
     * Description:
     * GameState will call the GameActions function GameActions.rolldice()
     *
     * @param player :the player that is going to be acted upon.
     */
    @Override
    public void rollDice(Player player) {

    }

    /**
     * @return : a list of player objects currently taking part int he game
     */
    @Override
    public ArrayList<Player> getPlayers() {
        return null;
    }

    /**
     * @return : number of total turns taken in the game so far.
     */
    @Override
    public int getTotalTurns() {
        return 0;
    }

    /**
     * @return : return the player object whos current turn it is.
     */
    @Override
    public Player getCurrentPlayerTurn() {
        return null;
    }

    /**
     * @return : an array list of players who are in jail.
     */
    @Override
    public ArrayList<Player> getPlayersInJail() {
        return null;
    }

    /**
     * function sets the next players turn.
     */
    @Override
    public void setNextPlayerTurn() {

    }

    /**
     * function increments the total turns taken in the game.
     */
    @Override
    public void IncrementTotalTurns() {

    }

    /**
     * @param player : player to be removed from jail if in jail.@return : player removed from jail
     */
    @Override
    public Player removePlayerFromJail(Player player) {
        return null;
    }

    /**
     * @param player : player to be put in jail.
     */
    @Override
    public void addPlayerToJail(Player player) {

    }

    /**
     * @param player : player to be added to the game on initalization of the game
     */
    @Override
    public void addPlayerToGame(Player player) {

    }

    /**
     * @param player : player to be removed from the game , this could
     *               be due to Bankruptcy or retirement
     */
    @Override
    public void removePlayerFromGame(Player player) {

    }
}