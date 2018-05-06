package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;

public class RetireController {

    private LeadController leadController;
    private Game game;

    public RetireController(LeadController leadController, Game game) {
        this.leadController = leadController;
        this.game = game;
    }

    public void retire() throws AssetOwner.AssetNotFoundException {
        Player currentPlayer = game.getCurrentPlayer();
        leadController.playerTurn = leadController.playerTurn++ % game.getPlayers().size();
        game.setCurrentPlayer(game.getPlayers().get(leadController.playerTurn));
        
        AssetCollection fromPlayer = currentPlayer.getAssetCollection();
        AssetCollection fromBank = new AssetCollection(0);
        
        Transaction tx = new Transaction(currentPlayer, game.getBank(), fromPlayer, fromBank);
        tx.settleTransaction();
        
        game.getPlayers().remove(currentPlayer);
        leadController.startTurn.startTurnSequence(game.getCurrentPlayer());
    }
}