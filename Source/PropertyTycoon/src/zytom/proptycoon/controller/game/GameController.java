package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Creates
 */
public class GameController {
    private final Game game;
    private BoardController boardController;
    private ArrayList<PlayerController> playerControllers;
    private DiceController diceController;
    private int playerTurn;

    public GameController(Game game){
        this.game = game;
        //Set up player controllers.
        game.getPlayers().stream().forEach((player) -> {
            this.playerControllers.add(
                    new PlayerController(
                            player
                    )
            );
        });
        playerTurn = 0;
    }
    
    

    /**
     *
     * @return players
     */
    private int getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Changes player turn
     */
    private void incrementPlayerTurn(){
        playerTurn = playerTurn++ % game.getPlayers().size();
    }

    /**
     * Sets players turn
     * @param turn
     */
    private void setPlayerTurn(int turn){
        playerTurn = turn;
    }

    /**
     *
     * @return game
     */
    public Game getGame() {
        return game;
    }

    /**
     *
     * @return playerControllers
     */
    public ArrayList<PlayerController> getPlayerControllers() {
        return playerControllers;
    }
}
