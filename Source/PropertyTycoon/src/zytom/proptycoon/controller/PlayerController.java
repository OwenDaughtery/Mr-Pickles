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
    Player currentPlayer;
    Game game;
    public PlayerController(Player player , Game game){

        this.currentPlayer = player;
        this.game = game;

    }

    public void hasLanded(Cell cell,Board board){

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

                //TODO
                break;
            case POT_LUCK:

                //draw a potluck card
                break;
            case GO_TO_JAIL:
                currentPlayer.moveTo(40,false,game.getBank());
                //move player to jail
                break;
            case FREE_PARKING:
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
                //player receives free parking
                break;
            case JUST_VISITING:
                //Do nothing
                break;
            case STREET_PROPERTY:

                break;
            case STATION_PROPERTY:

                break;
            case UTILITY_PROPERTY:break;
            case OPPORTUNITY_KNOCKS:break;

            default: throw new Board.CellNotFoundException();


        }

}
}
