package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Game;

import java.io.FileNotFoundException;

/**
 * Creates
 */
public class GameController {
    private final Game game;
    private int playerTurn;
    private final LandedOnCell playerController;
    private final PropertyLandedLogic propertyLandedLogic;
    private final PurchasePropertyOption purchasePropertyOption;
    private final OpportunityKnocksController opportunityKnocksController;
    private final PotLuckController potLuckController;
    private final DiceController diceController;
    private final AssetManagementController assetManagementController;
    private final StartTurn startTurn;
    private final EndTurnController endTurnController;
    private final BoardController boardController ;

    public GameController(Game game) throws FileNotFoundException, Board.CellNotFoundException, Game.PlayerNumberException {

        this.game = game;
        this.playerController = new LandedOnCell(this.game,this);
        this.propertyLandedLogic = new PropertyLandedLogic(game.getPlayers(),game.getBank(),this);
        this.purchasePropertyOption = new PurchasePropertyOption(game.getBank(),this);
        this.opportunityKnocksController = new OpportunityKnocksController(this.game,this,game.getBoard(),game.getBank(),game.getDice(),game.getCurrentPlayer());
        this.potLuckController = new PotLuckController(this.game,this,game.getBoard(),game.getBank(),game.getDice(),game.getCurrentPlayer());
        this.diceController = new DiceController(game.getDice(),this);
        this.assetManagementController = new AssetManagementController(game.getBank(),this);
        this.startTurn = new StartTurn(game.getBank(),this);
        this.endTurnController = new EndTurnController(this.game,this);
        this.boardController = new BoardController(game.getBoard());
    }

    public int getPlayerTurn() {
        return playerTurn;
    }
    public void incrementPlayerTurn(){
        playerTurn++;
    }
    public void setPlayerTurn(int turn){
        playerTurn = turn;

    }

    public Game getGame() {
        return game;
    }

    public LandedOnCell getPlayerController() {
        return playerController;
    }

    public BoardController getBoardController() {
        return boardController;
    }

    public PropertyLandedLogic getPropertyLandedLogic() {
        return propertyLandedLogic;
    }

    public PurchasePropertyOption getPurchasePropertyOption() {
        return purchasePropertyOption;
    }

    public OpportunityKnocksController getOpportunityKnocksController() {
        return opportunityKnocksController;
    }

    public PotLuckController getPotLuckController() {
        return potLuckController;
    }

    public DiceController getDiceController() {
        return diceController;
    }

    public AssetManagementController getAssetManagementController() {
        return assetManagementController;
    }

    public StartTurn getStartTurn() {
        return startTurn;
    }

    public EndTurnController getEndTurnController() {
        return endTurnController;
    }

}
