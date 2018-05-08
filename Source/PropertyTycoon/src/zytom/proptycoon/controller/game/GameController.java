package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;

import java.io.FileNotFoundException;

/**
 * Creates
 */
public class GameController {
    private final Game game;
    private int playerTurn;
    private LandedOnCell landedOnCell;
    private PropertyLandedLogic propertyLandedLogic;
    private PurchasePropertyOption purchasePropertyOption;
    private OpportunityKnocksController opportunityKnocksController;
    private PotLuckController potLuckController;
    private DiceController diceController;
    private AssetManagementController assetManagementController;
    private StartTurn startTurn;
    private EndTurnController endTurnController;
    private BoardController boardController ;
    private ArrayList<PlayerController> playerControllers;

    public GameController(Game game){

        this.game = game;
        this.landedOnCell = new LandedOnCell(this.game,this);
        this.propertyLandedLogic = new PropertyLandedLogic(game.getPlayers(),game.getBank(),this);
        this.purchasePropertyOption = new PurchasePropertyOption(game.getBank(),this);
        this.opportunityKnocksController = new OpportunityKnocksController(this.game,this,game.getBoard(),game.getBank(),game.getDice(),game.getCurrentPlayer());
        this.potLuckController = new PotLuckController(this.game,this,game.getBoard(),game.getBank(),game.getDice(),game.getCurrentPlayer());
        this.diceController = new DiceController(game.getDice(),this);
        this.assetManagementController = new AssetManagementController(game.getBank(),this);
        this.startTurn = new StartTurn(game.getBank(),this);
        this.endTurnController = new EndTurnController(this.game,this);
        this.boardController = new BoardController(game.getBoard());
        for (Player player:game.getPlayers()){
            playerControllers.add(new PlayerController(player));
        }
    }

    /**
     *
     * @return players
     */
    public int getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Changes player turn
     */
    public void incrementPlayerTurn(){
        playerTurn = playerTurn++ % game.getPlayers().size();
    }

    /**
     * Sets players turn
     * @param turn
     */
    public void setPlayerTurn(int turn){
        playerTurn = turn;

    }

    /**
     *
     * @return game
     */
    public Game getGame() {
        return game;
    }

    /**
     *
     * @return landOnCell
     */
    public LandedOnCell getLandedOnCell() {
        return landedOnCell;
    }

    /**
     *
     * @return boardController
     */
    public BoardController getBoardController() {
        return boardController;
    }

    /**
     *
     * @return propertyLandedLogic
     */
    public PropertyLandedLogic getPropertyLandedLogic() {
        return propertyLandedLogic;
    }

    /**
     *
     * @return purchasePropertyOption
     */
    public PurchasePropertyOption getPurchasePropertyOption() {
        return purchasePropertyOption;
    }

    /**
     *
     * @return opportunityKnocksController
     */
    public OpportunityKnocksController getOpportunityKnocksController() {
        return opportunityKnocksController;
    }

    /**
     *
     * @return potLuckController
     */
    public PotLuckController getPotLuckController() {
        return potLuckController;
    }

    /**
     *
     * @return diceController
     */
    public DiceController getDiceController() {
        return diceController;
    }

    /**
     *
     * @return assetManagementController
     */
    public AssetManagementController getAssetManagementController() {
        return assetManagementController;
    }

    /**
     *
     * @return startTurn
     */
    public StartTurn getStartTurn() {
        return startTurn;
    }

    /**
     *
     * @return endTurnController
     */
    public EndTurnController getEndTurnController() {
        return endTurnController;
    }

    /**
     *
     * @return playerControllers
     */
    public ArrayList<PlayerController> getPlayerControllers() {
        return playerControllers;
    }
}
