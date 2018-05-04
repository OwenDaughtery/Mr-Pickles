package zytom.proptycoon.controller;

import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.FreeParking;
import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.cell.*;

//public class PlayerController {
//
//    private Game game;
//    public PlayerController(Game game){
//
//        this.game = game;
//    }
//
//    public void hasLanded(Cell cell){
//
//        Player currentPlayer = game.getCurrentPlayer();
//        int cellNumber = currentPlayer.getPosition();
//        Cell currentCell = game.getBoard().getCell(cellNumber);
//        //Property Cell Decision
//        if(currentCell instanceof PropertyCell){
//            PropertyCellLanded((PropertyCell) currentCell);
//        }
//        // Go cell Desision
//        else if(currentCell instanceof GoCell) {
//            //Do Nothing
//        }
//        // Just Visiting Cell Decision
//        else if(currentCell instanceof PassingJailCell){
//            //Do Nothing
//        }
//        //Free Parking Cell Decision
//        else if(currentCell instanceof FreeParkingCell){
//            FreeParking freeParking = game.getFreeParking();
//            try {
//                Transaction transaction = new Transaction(
//                        freeParking,
//                        currentPlayer,
//                        new AssetCollection(game.getFreeParking().getAssetCollection().getMoney()),
//                        new AssetCollection(0)
//                );
//                transaction.settleTransaction();
//            } catch (AssetOwner.AssetNotFoundException ex) {
//
//            }
//        }
//        //Go to jail Cell
//        else if(currentCell instanceof GoToJailCell){
//            currentPlayer.moveTo(40,false,game.getBank());
//        }
//        //Opportunity Knocks Cell
//        else if(currentCell instanceof OpportunityKnocksCell){
//            //do shhit
//        }
//        //Pot luck
//        else if(currentCell instanceof PotLuckCell){
//            //do shit
//        }
//        //Income Tax
//        else if (currentCell instanceof  IncomeTaxCell){
//            FreeParking freeParking = game.getFreeParking();
//            try {
//                Transaction transaction = new Transaction(
//                        currentPlayer,
//                        freeParking,
//                        new AssetCollection(200),
//                        new AssetCollection(0)
//                );
//                transaction.settleTransaction();
//            } catch (AssetOwner.AssetNotFoundException ex) {
//
//            }
//        }
//        //SuperTax
//        else if (currentCell instanceof SuperTaxCell){
//            FreeParking freeParking = game.getFreeParking();
//            try {
//                Transaction transaction = new Transaction(
//                        currentPlayer,
//                        freeParking,
//                        new AssetCollection(100),
//                        new AssetCollection(0)
//                );
//                transaction.settleTransaction();
//            } catch (AssetOwner.AssetNotFoundException ex) {
//
//            }
//        }
//        else{
//            throw new StartGame.CellNotFoundException();
//        }
//    }
//
//    }
//}

public class PlayerController {
    Game game;
    Player currentPlayer;

    public PlayerController(Game game){
        this.game = game;
        currentPlayer = game.getCurrentPlayer();

    }

    public void hasLanded(Cell cell,Board board) throws CellNotFoundException, LandedOnJailException {

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

                //draw a potluck card
                break;
            case GO_TO_JAIL:
                currentPlayer.moveTo(40,false,game.getBank());
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

                break;
            case STATION_PROPERTY:
                break;
            case UTILITY_PROPERTY:
                break;
            case OPPORTUNITY_KNOCKS:break;

            default: throw new CellNotFoundException();


        }

}
    public static class CellNotFoundException extends Exception {
        public CellNotFoundException(
        ) {
            super (
                    "Cell not Found"
            );
        }
        /**
         * Gets the message
         * @return The exception message.
         */
        @Override
        public String getMessage()
        {
            return super.getMessage();
        }
    }

    public static class LandedOnJailException extends Exception {
        public LandedOnJailException(
        ) {
            super (
                    "Landed on jail cell"
            );
        }
        /**
         * Gets the message
         * @return The exception message.
         */
        @Override
        public String getMessage()
        {
            return super.getMessage();
        }
    }
}
