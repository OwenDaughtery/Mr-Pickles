package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;

/**
 * @author aymanfree
 */
public class EndTurnController {
    private final Game game;
    private final GameController gameController;

    /**
     *
     * @param game
     * @param gameController
     */
    public EndTurnController(Game game,GameController gameController) {
        this.game = game;
        this.gameController = gameController;
    }

    /**
     * ends the turn of the current player and sets current player to the next player unless current player rolls doubles.
     * @param currentPlayer
     */
    public void endTurn(Player currentPlayer){
            if (game.getDice().getFirstValue() != game.getDice().getSecondValue()) {
                if(game.getCurrentPlayer().getPosition()!=40) {
                    gameController.incrementPlayerTurn();
                int turn = gameController.getPlayerTurn() % game.getPlayers().size();
                gameController.setPlayerTurn(turn);
                game.setCurrentPlayer(game.getPlayers().get(game.getPlayers().indexOf(gameController.getPlayerTurn())));
            }
        }
        //gameController.getStartTurn().startTurnSequence(game.getCurrentPlayer());
    }

}
