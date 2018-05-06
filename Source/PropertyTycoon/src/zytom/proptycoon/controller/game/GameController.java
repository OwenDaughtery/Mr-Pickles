package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.cell.Cell;
import zytom.proptycoon.model.cell.StationPropertyCell;
import zytom.proptycoon.model.cell.StreetPropertyCell;
import zytom.proptycoon.model.cell.UtilityPropertyCell;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Creates
 */
public class GameController {
    Game game;
    int playerTurn;
    PlayerController playerController = new PlayerController(game,this);
    PropertyLandedLogic propertyLandedLogic = new PropertyLandedLogic(game.getPlayers(),game.getBank(),this);
    PurchasePropertyOption purchasePropertyOption = new PurchasePropertyOption(game.getBank(),this);
    OpportunityKnocksController opportunityKnocksController = new OpportunityKnocksController(game,this,game.getBoard(),game.getBank(),game.getDice(),game.getCurrentPlayer());
    PotLuckController potLuckController  =new PotLuckController(game,this,game.getBoard(),game.getBank(),game.getDice(),game.getCurrentPlayer());
    DiceController diceController = new DiceController(game.getDice(),this);
    AssetManagementController assetManagementController = new AssetManagementController(game.getBank(),this);
    StartTurn startTurn = new StartTurn(game.getBank(),this);
    EndTurnController endTurnController = new EndTurnController(game,this);

    private BoardController boardController = new BoardController(game.getBoard());

    public GameController(Game game) throws FileNotFoundException, Board.CellNotFoundException, Game.PlayerNumberException {
        this.game = game;
    }
}
