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
                this.game.getDice()
        );
        //Start first turn.
        startTurn();
    }
    
    public BoardController getBoardController() {
        return this.boardController;
    }
    
    private void startTurn() {
        //Show/enable roll dice UI.
        //TODO.
    }
    
    public void diceRolled() {
        //Get current player controller.
        PlayerController playerController = getCurrentPlayerController();
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
    }

    public void rollDice() {
        //Get current player controller.
        PlayerController playerController = getCurrentPlayerController();
        //Roll dice.
        this.diceController.roll(
                playerController
        );
        //Move to next phase.
        diceRolled();
    }
    
    public void nextTurn() {
        incrementPlayerTurn();
        startTurn();
    }

    private PlayerController getCurrentPlayerController() {
        return this.playerControllers.get(playerTurn);
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
    private void incrementPlayerTurn() {
        playerTurn = playerTurn++ % game.getPlayers().size();
    }

    /**
     * Sets players turn
     *
     * @param turn
     */
    private void setPlayerTurn(int turn) {
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
