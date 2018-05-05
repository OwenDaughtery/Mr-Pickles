package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;

public class RetireController {

    private LeadController leadController;
    private Game game;

    public RetireController(LeadController leadController, Game game) {
        this.leadController = leadController;
        this.game = game;
    }

    public void retire() {
        Player currentPlayer = game.getCurrentPlayer();
        leadController.playerTurn = leadController.playerTurn++ % game.getPlayers().size();
        game.setCurrentPlayer(game.getPlayers().get(leadController.playerTurn));
        game.getPlayers().remove(currentPlayer);
        leadController.startTurn.startTurnSequence(game.getCurrentPlayer());
    }
}
