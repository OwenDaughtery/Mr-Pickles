package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;

public class EndTurnController {
    private Game game;
    private LeadController leadController;

    public EndTurnController(Game game,LeadController leadController) {
        this.game = game;
        this.leadController = leadController;
    }

    public void endTurn(Player currentPlayer){
        if(game.getCurrentPlayer().getPosition()!=40) {
            if (game.getDice().getFirstValue() != game.getDice().getSecondValue()) {
                leadController.playerTurn = leadController.playerTurn++ % game.getPlayers().size();
                game.setCurrentPlayer(game.getPlayers().get(game.getPlayers().indexOf(leadController.playerTurn)));
            }
        }
    }

}
