package zytom.proptycoon.controller;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.PropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.cell.Cell;
import zytom.proptycoon.model.cell.PropertyCell;
import zytom.proptycoon.model.cell.StreetPropertyCell;

public class AssetManagementController {
    Player player;
    Bank bank;

    public AssetManagementController(Player player, Bank bank){

    this.player = player;
    this.bank = bank;


    }


    public void buyHouse(StreetPropertyCard streetPropertyCard) throws StreetPropertyCell.ConstructionError {

        int houseCost = streetPropertyCard.getBuildCost();
        StreetPropertyCell propCell = (StreetPropertyCell) streetPropertyCard.getCellRef();

        try {
            Transaction transaction = new Transaction(
                    player,
                    bank,
                    new AssetCollection(houseCost),
                    new AssetCollection(0)
            );
            transaction.settleTransaction();
        } catch (AssetOwner.AssetNotFoundException ex) {

        }
        propCell.addBuilding();

    }

    public void sellHouse(StreetPropertyCard streetPropertyCard) throws StreetPropertyCell.ConstructionError {
        int houseCost = streetPropertyCard.getBuildCost();
        StreetPropertyCell propCell = (StreetPropertyCell) streetPropertyCard.getCellRef();

        try {
            Transaction transaction = new Transaction(
                    player,
                    bank,
                    new AssetCollection(0),
                    new AssetCollection(houseCost)
            );
            transaction.settleTransaction();
        } catch (AssetOwner.AssetNotFoundException ex) {

        }
        propCell.removeBuilding();

    }



    public void mortagageProperty(StreetPropertyCard streetPropertyCard){
        // change property card to mortag
    }

    public void sellProperty(StreetPropertyCard streetPropertyCard){
        initi

        if ()

    }

    // purchase house on owned property
    // sell house on owned property
    //mortgage a property that the player owns
}
