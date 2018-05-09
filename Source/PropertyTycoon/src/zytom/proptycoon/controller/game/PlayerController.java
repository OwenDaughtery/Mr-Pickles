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

    public Player getPlayer() {
        return this.player;
    }

    public void setDebt(int amount) {
        this.debt = amount;
    }

    public void setBoardView(BoardCanvas boardView) {
        this.boardView = boardView;
    }

    public void updateTokenView() {
        if (this.boardView == null) {
            return;
        }
        this.boardView.movePlayerToken(
                player.getTokenType(),
                player.getPosition()
        );
    }
    
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
            case SUPER_TAX:
                hasLandedSuperTax(player, freeParking);
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

    private void hasLandedProperty(
            ArrayList<Player> otherPlayers,
            Bank bank,
            Dice dice,
            StreetPropertyCell cell)
            throws PropertyCard.TooManyHousesException {

    }

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

    private void hasLandedSuperTax(Player currentPlayer, FreeParking freeParking) {
        try {
            Transaction transaction = new Transaction(
                    currentPlayer,
                    freeParking,
                    new AssetCollection(100),
                    new AssetCollection(0)
            );
            transaction.settleTransaction();
        } catch (AssetOwner.AssetNotFoundException ex) {

        }
    }

    private void hasLandedIncomeTax(Player currentPlayer, FreeParking freeParking) {
        try {
            Transaction transaction = new Transaction(
                    currentPlayer,
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
