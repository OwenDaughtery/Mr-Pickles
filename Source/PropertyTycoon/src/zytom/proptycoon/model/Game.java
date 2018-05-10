/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model;

import zytom.proptycoon.model.card.CardAction;
import zytom.proptycoon.model.deckCreator.DeckCreator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import zytom.proptycoon.model.card.StreetPropertyCard;

/**
 *
 * @author Ayman Free
 *
 * Creates instaces of all players, board and dice. Stores current players turn.
 */
public class Game{

    private ArrayList<Player> players;
    private Player currentPlayer;
    private final Bank bank;
    private final Board board;
    private final Dice dice;
    private final FreeParking freeParking;

    /**
     * Initialises Game Creates players if the number of players in between 2-6,
     * if not throw exception.
     *
     * @param players
     * @param startingPlayer
     * @throws PlayerNumberException
     * @throws java.io.FileNotFoundException
     */
    public Game(ArrayList<Player> players, Player startingPlayer) throws PlayerNumberException, FileNotFoundException, Board.CellNotFoundException, CardAction.InvalidActionException, StreetPropertyCard.InvalidColourGroupException {
        //Check number of players is valid.
        if (players.size() < 1  || players.size() > 6) {
            throw new PlayerNumberException(players.size());
        } else {
            this.players = players;
        }
        currentPlayer = startingPlayer;
        DeckCreator deckCreator = new DeckCreator();
        board = new Board(deckCreator.getPropertyData());
        bank = new Bank(
                deckCreator.createPotLuckDeck(),
                deckCreator.createOpportunityKnocksDeck(),
                deckCreator.createStreetPropertyCardDeck(this.board),
                deckCreator.createStationPropertyCardDeck(this.board),
                deckCreator.createUtilityPropertyCardDeck(this.board)
        );
        freeParking = new FreeParking();
        dice = new Dice();
    }

    /**
     * @author Tom Chesters
     * @return currentPlayer
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @author Tom Chesters
     * @return dice
     */
    public Dice getDice() {
        return dice;
    }

    /**
     * @author Ayman Free
     * @return board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @author Ayman Free
     * @return players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @author Ayman
     *
     * sets current player to new current player
     * @param newCurrentPlayer
     */
    public void setCurrentPlayer(Player newCurrentPlayer) {
        currentPlayer = newCurrentPlayer;
    }

    /**
     * @Author Ayman Free
     * @return bank
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * An exception to be thrown if playerSize is not between 2-6
     */
    public static class PlayerNumberException extends Exception {

        /**
         * Generate the exception message.
         *
         * @param playersSize The size of array list 'players'.
         */
        public PlayerNumberException(int playersSize) {
            super(
                    "player size of  "
                    + playersSize
                    + " is not between 2-6"
            );
        }

        /**
         * Gets the message containing details of the current player size
         *
         * @return The exception message.
         */
        @Override
        public String getMessage() {
            return super.getMessage();
        }
    }

    /**
     * @author Ayman Free
     * @return bank
     */
    public FreeParking getFreeParking() {
        return freeParking;
    }
}
