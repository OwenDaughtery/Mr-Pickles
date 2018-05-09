package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.*;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.PropertyCard;
import zytom.proptycoon.model.cell.*;
import zytom.proptycoon.view.board.BoardCanvas;

public class PlayerController {
    private final Player player;
    
    /**
     * Reference needed for communicating with board view in order
     * to move around corresponding player token.
     */
    private BoardCanvas boardView;
    
    
    public PlayerController(Player player) {
        this.player = player;
    }
    
    public void setBoardView(BoardCanvas boardView) {
        this.boardView = boardView;
    }
    
    public void updateTokenView() {
        if (this.boardView == null) return;
        this.boardView.movePlayerToken(
                player.getTokenType(),
                player.getPosition()
        );
    }
    
    public void hasLanded(
            Cell cell, 
            Board board, 
            Dice dice,
            FreeParking freeParking,
            PotLuckController potLuckController
    ) 
            throws CellNotFoundException, 
            LandedOnJailException, 
            PropertyCard.TooManyHousesException, 
            Board.CellNotFoundException, 
            AssetOwner.AssetNotFoundException 
    {
        Board.CellType cellType = board.getCellClass(cell);

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
                throw new LandedOnJailException();
            case POT_LUCK:
                potLuckController.pickupCard();
                break;
            case GO_TO_JAIL:
                player.sendToJail();
                break;
            case FREE_PARKING:
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
                break;
            case JUST_VISITING:
                //Do nothing
                break;
            case STREET_PROPERTY:
                gameController.getPropertyLandedLogic().landedOnProperty((StreetPropertyCell)cell,player,dice);
                break;
            case STATION_PROPERTY:
                gameController.getPropertyLandedLogic().landedOnProperty((StationPropertyCell)cell,player,dice);
                break;
            case UTILITY_PROPERTY:
                gameController.getPropertyLandedLogic().landedOnProperty((UtilityPropertyCell)cell,player,dice);
                break;
            case OPPORTUNITY_KNOCKS:
                gameController.getOpportunityKnocksController().pickupCard();
                break;
            default:
                throw new CellNotFoundException();


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

    private void hasLandedIncomeTax(Player currentPlayer, FreeParking freeParking)  {
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
}
