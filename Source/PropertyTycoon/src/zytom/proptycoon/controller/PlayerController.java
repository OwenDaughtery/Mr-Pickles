package zytom.proptycoon.controller;

import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.FreeParking;
import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.cell.*;

public class PlayerController {

    private Game game;
    public PlayerController(Game game){

        this.game = game;
    }

    public void hasLanded(Cell cell){

        Player currentPlayer = game.getCurrentPlayer();
        int cellNumber = currentPlayer.getPosition();
        Cell currentCell = game.getBoard().getCell(cellNumber);
        //Property Cell Decision
        if(currentCell instanceof PropertyCell){
            PropertyCellLanded((PropertyCell) currentCell);
        }
        // Go cell Desision
        else if(currentCell instanceof GoCell) {
            //Do Nothing
        }
        // Just Visiting Cell Decision
        else if(currentCell instanceof PassingJailCell){
            //Do Nothing
        }
        //Free Parking Cell Decision
        else if(currentCell instanceof FreeParkingCell){
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
        }
        //Go to jail Cell
        else if(currentCell instanceof GoToJailCell){
            currentPlayer.moveTo(40,false,game.getBank());
        }
        //Opportunity Knocks Cell
        else if(currentCell instanceof OpportunityKnocksCell){
            //do shhit
        }
        //Pot luck
        else if(currentCell instanceof PotLuckCell){
            //do shit
        }
        //Income Tax
        else if (currentCell instanceof  IncomeTaxCell){
            FreeParking freeParking = game.getFreeParking();
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
        //SuperTax
        else if (currentCell instanceof SuperTaxCell){
            FreeParking freeParking = game.getFreeParking();
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
        else{
            throw new StartGame.CellNotFoundException();
        }
    }

    }
}
