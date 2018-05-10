package zytom.proptycoon.controller.game;

import java.util.ArrayList;
import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;

/**
 * Creates
 */
public class GameController {

    private final Game game;
    private BoardController boardController;
    private ArrayList<PlayerController> playerControllers;
    private final DiceController diceController;
    private int playerTurn;
    
    /**
     * Root controller.
     * @param game corresponding game model
     */
    public GameController(Game game) {
        //Store game reference.
        this.game = game;
        //Set up board controller.
        this.boardController = new BoardController(
                this.game.getBoard()
        );
        //Set up player controllers.
        this.playerControllers = new ArrayList<>();
        game.getPlayers().stream().forEach((player) -> {
            this.playerControllers.add(
                    new PlayerController(
                            player
                    )
            );
        });
        playerTurn = 0;
        //Set up dice controller.
        this.diceController = new DiceController(
                this.game.getDice(),
                this
        );
    }

    /**
     * 
     * @return controller for the board.
     */
    public BoardController getBoardController() {
        return this.boardController;
    }
    
    /**
     * 
     * @return controller for the dice.
     */
    public DiceController getDiceController() {
        return this.diceController;
    }
    
    /**
     * Event for when roll dice button is all set up
     */
    public void readyToRoll() {
        //Initial start turn.
        this.startTurn();
    }

    /**
     * Tell's the dice that they can be rolled.
     */
    private void startTurn() {
        //Show/enable roll dice UI.
        this.diceController.timeToRoll();
    }

    /**
     * Event called when dice have been rolled.
     * Tells player controller that dice have been rolled so
     * that it can move the current player.
     */
    public void diceRolled(boolean wasDouble) {
        //Get current player controller.
        PlayerController playerController = getCurrentPlayerController();
        //Roll dice.
        if (wasDouble) {
            playerController.getPlayer().incrementDoublesRolled();
        }
        //Get dice instance
        Dice dice = diceController.getDice();
        //Get other players (whose turn it is currently not).
        ArrayList<Player> otherPlayers = new ArrayList<>();
        game.getPlayers().stream().filter(
                (player) -> (player != playerController.getPlayer())
        ).forEach((player) -> {
            otherPlayers.add(player);
        });
        //Tell player that dice have been rolled.
        playerController.diceRolled(
                dice.getFirstValue(),
                dice.getSecondValue(),
                boardController.getBoard(),
                game.getBank(),
                dice,
                game.getFreeParking(),
                otherPlayers
        );
        //Enable the dice again.
        nextTurn();
    }

    /**
     * Move on to next turn.
     */
    public void nextTurn() {
        incrementPlayerTurn();
        startTurn();
    }

    /**
     * 
     * @return player controller
     */
    public PlayerController getCurrentPlayerController() {
        return this.playerControllers.get(playerTurn);
    }

    /**
     *
     * @return index of player whose turn it is.
     */
    public int getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Moves turn onto next player.
     */
    public void incrementPlayerTurn() {
        int numberOfPlayers = this.playerControllers.size();
        playerTurn = (playerTurn == numberOfPlayers - 1) ? 0 : playerTurn + 1;
    }

    /**
     * Sets players turn
     *
     * @param turn
     */
    public void setPlayerTurn(int turn) {
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
