/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model;

/**
 *
 * @author Tom Chesters
 */
public class Game {
    private Player currentPlayer;
    private Dice dice;

    public Game() {
        
    }

    public Player getCurrentPlayer() {
      return currentPlayer;
    }

    public Dice getDice() {
        return dice;
    }
}
