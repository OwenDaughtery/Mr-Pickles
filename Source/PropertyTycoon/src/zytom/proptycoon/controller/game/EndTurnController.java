package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;

/**
 * @author aymanfree
 */
public class EndTurnController {
    private Game game;
    private LeadController leadController;

    /**
     *
     * @param game
     * @param leadController
     */
    public EndTurnController(Game game,LeadController leadController) {
        this.game = game;
        this.leadController = leadController;
    }

    /**
     * ends the turn of the current player and sets current player to the next player unless current player rolls doubles.
     * @param currentPlayer
     */
    public void endTurn(Player currentPlayer){
            if (game.getDice().getFirstValue() != game.getDice().getSecondValue()) {
                if(game.getCurrentPlayer().getPosition()!=40) {
                leadController.playerTurn = leadController.playerTurn++ % game.getPlayers().size();
                game.setCurrentPlayer(game.getPlayers().get(game.getPlayers().indexOf(leadController.playerTurn)));
            }
        }
        leadController.startTurn.startTurnSequence(game.getCurrentPlayer());
    }

}
