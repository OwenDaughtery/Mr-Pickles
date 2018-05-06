package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.*;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.PropertyCard;
import zytom.proptycoon.model.cell.*;

/**
 *
 */
public class PlayerController {
    private Game game;
    private GameController gameController;
    public PlayerController(Game game,GameController gameController) {
        this.game = game;
        this.gameController = gameController;
    }
    public void hasLanded(Cell cell, Board board, Dice dice,Player currentPlayer) throws CellNotFoundException, LandedOnJailException, PropertyCard.ToManyDaymHousesException, Board.CellNotFoundException, AssetOwner.AssetNotFoundException {

        Board.CellType cellType = board.getCellClass(cell);

        switch (cellType) {

            case GO:
                //hands off to asset management controller
                break;

            case INCOME_TAX:
                FreeParking incomeTaxPayment = game.getFreeParking();
                try {
                    Transaction transaction = new Transaction(
                            currentPlayer,
                            incomeTaxPayment,
                            new AssetCollection(200),
                            new AssetCollection(0)
                    );
                    transaction.settleTransaction();
                } catch (AssetOwner.AssetNotFoundException ex) {

                }
                //try transaction to pay taxman
                break;
            case SUPER_TAX:
                FreeParking superTaxPayment = game.getFreeParking();
                try {
                    Transaction transaction = new Transaction(
                            currentPlayer,
                            superTaxPayment,
                            new AssetCollection(100),
                            new AssetCollection(0)
                    );
                    transaction.settleTransaction();
                } catch (AssetOwner.AssetNotFoundException ex) {

                }
                break;
            case JAIL:
                throw new LandedOnJailException();
            case POT_LUCK:
                gameController.getPotLuckController().pickupCard();

                //draw a potluck card
                break;
            case GO_TO_JAIL:
                currentPlayer.moveTo(40, false, game.getBank());
                //move player to jail
                break;
            case FREE_PARKING:
                //player receives free parking
                FreeParking freeParking = game.getFreeParking();
                try {
                    Transaction transaction = new Transaction(
                            freeParking,
                            currentPlayer,
                            new AssetCollection(game.getFreeParking().getAssetCollection().getMoney()),
                            new AssetCollection(0)
                    );
                    transaction.settleTransaction();
                } catch (AssetOwner.AssetNotFoundException ex) {
                }
                break;
            case JUST_VISITING:
                //Do nothing
                break;
            case STREET_PROPERTY:
                gameController.getPropertyLandedLogic().landedOnProperty((StreetPropertyCell)cell,currentPlayer,dice);
                break;
            case STATION_PROPERTY:
                gameController.getPropertyLandedLogic().landedOnProperty((StationPropertyCell)cell,currentPlayer,dice);
                break;
            case UTILITY_PROPERTY:
                gameController.getPropertyLandedLogic().landedOnProperty((UtilityPropertyCell)cell,currentPlayer,dice);
                break;
            case OPPORTUNITY_KNOCKS:
                gameController.getOpportunityKnocksController().pickupCard();
                break;
            default:
                throw new CellNotFoundException();


        }

    }

    public static class CellNotFoundException extends Exception {
        public CellNotFoundException(
        ) {
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

    public static class LandedOnJailException extends Exception {
        public LandedOnJailException(
        ) {
            super(
                    "Landed on jail cell"
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
