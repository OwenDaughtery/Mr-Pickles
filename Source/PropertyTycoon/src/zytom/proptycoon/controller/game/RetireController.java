package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;

public class RetireController {

    private final GameController gameController;
    private final Game game;

    public RetireController(GameController gameController, Game game) {
        this.gameController = gameController;
        this.game = game;
    }

    public void retire() throws AssetOwner.AssetNotFoundException {
        Player currentPlayer = game.getCurrentPlayer();

        gameController.incrementPlayerTurn();
        int turn = gameController.getPlayerTurn() % game.getPlayers().size();
        gameController.setPlayerTurn(turn);
        game.setCurrentPlayer(game.getPlayers().get(game.getPlayers().indexOf(gameController.getPlayerTurn())));
        
        AssetCollection fromPlayer = currentPlayer.getAssetCollection();
        AssetCollection fromBank = new AssetCollection(0);
        
        Transaction tx = new Transaction(currentPlayer, game.getBank(), fromPlayer, fromBank);
        tx.settleTransaction();
        
        game.getPlayers().remove(currentPlayer);
        gameController.getStartTurn().startTurnSequence(game.getCurrentPlayer());
    }
}