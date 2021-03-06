package zytom.proptycoon.controller.game;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import zytom.proptycoon.model.*;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.PropertyCard;
import zytom.proptycoon.model.cell.*;
import zytom.proptycoon.view.board.BoardCanvas;

public class PlayerController {

    private final Player player;
    private int debt;

    /**
     * Reference needed for communicating with board view in order to move
     * around corresponding player token.
     */
    private BoardCanvas boardView;

    public PlayerController(Player player) {
        this.player = player;
        this.debt = 0;
    }

    /**
     * 
     * @return player model.
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Record debt for player (if player cannot make a payment and 
     * is in asset selling or resign phase).
     * @param amount 
     */
    public void setDebt(int amount) {
        this.debt = amount;
    }

    /**
     * Assign board view to this controller.
     * @param boardView 
     */
    public void setBoardView(BoardCanvas boardView) {
        this.boardView = boardView;
    }

    /**
     * Tells board view to move player token view
     * to correct cell.
     */
    public void updateTokenView() {
        if (this.boardView == null) {
            return;
        }
        System.out.println(player.getPosition());
        this.boardView.movePlayerToken(
                player.getTokenType(),
                player.getPosition()
        );
    }

    /**
     * Moves the player based on the numbers on the dice
     * @param dice1
     * @param dice2
     * @param board
     * @param bank
     * @param dice
     * @param freeParking
     * @param otherPlayers
     */
    public void diceRolled(
            int dice1, 
            int dice2,
            Board board,
            Bank bank,
            Dice dice,
            FreeParking freeParking,
            ArrayList<Player> otherPlayers
    ) {
        int moveAmount = dice1 + dice2;
        if (player.getDoublesRolled() == 3) {
            player.sendToJail();
            player.clearDoublesRolled();
        } else {
            player.move(moveAmount, bank);
            
            try {
                Cell newCell = board.getCell(
                        player.getPosition()
                );
                System.out.println(
                        board.getCellClass(newCell)
                );
                System.out.println(
                        player.getPosition()
                );
                this.hasLanded(
                    newCell,
                    board.getCellClass(newCell),
                    otherPlayers,
                    bank,
                    dice,
                    freeParking
                );
            } catch (Board.CellNotFoundException ex) {
                Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Calls the relevant methods depending on which cell the player has landed on
     * @param cell
     * @param cellType
     * @param otherPlayers
     * @param bank
     * @param dice
     * @param freeParking
     */
    public void hasLanded(
            Cell cell,
            Board.CellType cellType,
            ArrayList<Player> otherPlayers,
            Bank bank,
            Dice dice,
            FreeParking freeParking
    ) {
        //Update the positioning of the token view.
        updateTokenView();
        //Carry out resulting scenario.
        switch (cellType) {
            case GO:
                //hands off to asset management controller 
                break;
            case INCOME_TAX:
                hasLandedIncomeTax(player, freeParking);
                break;
            case SUPER_TAX:
                hasLandedSuperTax(freeParking);
                break;
            case JAIL:
                //TODO
                //Pay fee...
                //Or get stuck in jail.
                break;
            case POT_LUCK:
                //potLuckController.pickupCard(); 
                break;
            case OPPORTUNITY_KNOCKS:
                //gameController.getOpportunityKnocksController().pickupCard(); 
                break;
            case GO_TO_JAIL:
                player.sendToJail();
                break;
            case FREE_PARKING:
                hasLandedFreeParking(freeParking);
                break;
            case JUST_VISITING:
                //Do nothing 
                break;
            case STREET_PROPERTY:
                //Set up a 'landed on property' scenario.
                //(Pass it necessery information.)
                LandedOnPropertyScenario streetScenario = new LandedOnPropertyScenario(
                        this,
                        otherPlayers,
                        bank,
                        dice
                );
                //(Process the scenario.)
                streetScenario.landedOnProperty(
                        (StreetPropertyCell) cell
                );
                break;
            case STATION_PROPERTY:
                //Set up a 'landed on property' scenario.
                //(Pass it necessery information.)
                LandedOnPropertyScenario stationScenario = new LandedOnPropertyScenario(
                        this,
                        otherPlayers,
                        bank,
                        dice
                );
                //(Process the scenario.)
                stationScenario.landedOnProperty(
                        (StationPropertyCell) cell
                );
                break;
            case UTILITY_PROPERTY:
                //Set up a 'landed on property' scenario.
                //(Pass it necessery information.)
                LandedOnPropertyScenario utilityScenario = new LandedOnPropertyScenario(
                        this,
                        otherPlayers,
                        bank,
                        dice
                );
                //(Process the scenario.)
                utilityScenario.landedOnProperty(
                        (UtilityPropertyCell) cell
                );
                break;
            default:
                //throw new CellNotFoundException();
        }
    }
    
    public void manageAssets() {
        
    }

    /**
     * Calls the relevant method depending on which type of property a player has landed on.
     * @param otherPlayers
     * @param bank
     * @param dice
     * @param cell
     * @throws PropertyCard.TooManyHousesException
     */
    private void hasLandedProperty(
            ArrayList<Player> otherPlayers,
            Bank bank,
            Dice dice,
            StreetPropertyCell cell)
            throws PropertyCard.TooManyHousesException {

    }

    /**
     * settles transaction if player lands on free parking
     * @param freeParking
     */
    private void hasLandedFreeParking(FreeParking freeParking) {
        //Hand over free parking's entire asset collection
        //to player.
        try {
            Transaction transaction = new Transaction(
                    freeParking,
                    player,
                    freeParking.getAssetCollection(),
                    new AssetCollection(0)
            );
            transaction.settleTransaction();
        } catch (AssetOwner.AssetNotFoundException ex) {
            //Do nothing.
            //(Won't happen anyway.)
        }
    }

    /**
     * settles transaction if player lands on super tax
     * @param freeParking
     */
    private void hasLandedSuperTax(FreeParking freeParking) {
        try {
            Transaction transaction = new Transaction(
                    player,
                    freeParking,
                    new AssetCollection(100),
                    new AssetCollection(0)
            );
            transaction.settleTransaction();
        } catch (AssetOwner.AssetNotFoundException ex) {

        }
    }
    /**
     * settles transaction if player lands on income tax
     * @param freeParking
     */
    private void hasLandedIncomeTax(FreeParking freeParking) {
        try {
            Transaction transaction = new Transaction(
                    player,
                    freeParking,
                    new AssetCollection(200),
                    new AssetCollection(0)
            );
            transaction.settleTransaction();
        } catch (AssetOwner.AssetNotFoundException ex) {

        }
    }

    public static class CellNotFoundException extends Exception {
        public CellNotFoundException() {
            super(
                    "Cell not Found"
            );
        }

        /**
         * Gets the message
         *
         * @return The exception message.
         */
        @Override
        public String getMessage() {
            return super.getMessage();
        }
    }
}
