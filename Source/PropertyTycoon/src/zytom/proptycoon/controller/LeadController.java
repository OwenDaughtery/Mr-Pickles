package zytom.proptycoon.controller;

import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LeadController {
    Game game;
    PlayerController playerController = new PlayerController(game,this);
    PropertyLandedLogic propertyLandedLogic = new PropertyLandedLogic(game.getPlayers(),game.getBank(),this);
    PurchasePropertyOption purchasePropertyOption = new PurchasePropertyOption(game.getBank(),this);
    DiceController diceController = new DiceController(game.getDice(),this);
    AssetManagementController assetManagementController = new AssetManagementController(game.getCurrentPlayer(),game.getBank(),this);

    public LeadController(ArrayList<Player> players, Player startingPlayer,Game game) throws FileNotFoundException, Board.CellNotFoundException, Game.PlayerNumberException {
        this.game = game;
    }
}
