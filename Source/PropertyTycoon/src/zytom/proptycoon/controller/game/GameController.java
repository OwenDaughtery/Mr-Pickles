package zytom.proptycoon.controller.game;

import jdk.nashorn.internal.runtime.NumberToString;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;
<<<<<<< Updated upstream:Source/PropertyTycoon/src/zytom/proptycoon/controller/game/LeadController.java
import zytom.proptycoon.model.card.PotLuckCard;
=======
import zytom.proptycoon.model.cell.Cell;
import zytom.proptycoon.model.cell.StationPropertyCell;
import zytom.proptycoon.model.cell.StreetPropertyCell;
import zytom.proptycoon.model.cell.UtilityPropertyCell;
>>>>>>> Stashed changes:Source/PropertyTycoon/src/zytom/proptycoon/controller/game/GameController.java

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

    public GameController(ArrayList<Player> players, Player startingPlayer, Game game) throws FileNotFoundException, Board.CellNotFoundException, Game.PlayerNumberException {
        this.game = game;

    }

    public BoardController getBoardController(){
        return boardController;
    }
}
