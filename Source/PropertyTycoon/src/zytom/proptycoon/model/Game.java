/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model;

//import zytom.proptycoon.model.assets.Asset; //no longer a class
//import zytom.proptycoon.model.assets.AssetOwner; //not used

import java.util.ArrayList;


/**
 *
 * @author Ayman Free
 *
 * Creates instaces of all players, board and dice. Stores current players turn.
 */
public class Game {
    
    private static Player currentPlayer;
    private static final Dice dice = new Dice();
    private static  ArrayList<Player> players;
    private static final Board board = new Board();
    //private static final Bank bank = new Bank(); //TODO

    /**
     * Initialises Game
     * Creates players if the number of players in between 2-6, if not throw exception.
     * @param players
     * @param startingPlayer
     * @throws PlayerNumberException
     */
    public Game(ArrayList<Player> players, Player startingPlayer) throws PlayerNumberException {
        if(1<players.size() || players.size()>6){
            throw new PlayerNumberException(players.size());
        } else {
            Game.players = players;
        }
        currentPlayer = startingPlayer;
    }


    /**
     * @author Tom Chesters
     * @return currentPlayer
     */
    public static Player getCurrentPlayer() {
      return currentPlayer;
    }

    /**
     * @author Tom Chesters
     * @return dice
     */
    public static Dice getDice() {
        return dice;
    }

    /**
     * @author Ayman Free
     * @return board
     */
    public static Board getBoard() {
        return board;
    }

    /**
     * @author Ayman Free
     * @return players
     */
    public static ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @author Ayman
     *
     * sets current player to new current player
     * @param newCurrentPlayer
     */
    public static void setCurrentPlayer(Player newCurrentPlayer) {
        Game.currentPlayer = newCurrentPlayer;
    }

    /**
     * @Author Ayman Free
     * @return bank
     */
    public static Bank getBank() {
        return bank;  //TODO
    }

    /**
     * An exception to be thrown if playerSize is not between 2-6
     */
    public static class PlayerNumberException extends Exception {
        /**
         * Generate the exception message.
         * @param playersSize The size of array list 'players'.
         */
        public PlayerNumberException(int playersSize) {
            super (
                    "player size of  " +
                            playersSize +
                            " is not between 2-6"
            );
        }
        /**
         * Gets the message containing details of the current player size
         * @return The exception message.
         */
        @Override
        public String getMessage()
        {
            return super.getMessage();
        }
    }
}
