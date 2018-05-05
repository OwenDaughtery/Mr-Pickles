package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.cell.StreetPropertyCell;

public class AssetManagementController {
    Player player;
    Bank bank;
    LeadController leadController;
    public AssetManagementController(Player player, Bank bank, LeadController leadController){

    this.player = player;
    this.bank = bank;
    this.leadController = leadController;

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


    /**
     * Method calls for a property to be mortaged and handles transactions ;
     * @param streetPropertyCard
     */
    public void mortagageProperty(StreetPropertyCard streetPropertyCard) throws MortagagingError {

        StreetPropertyCell propertyCell = (StreetPropertyCell) streetPropertyCard.getCellRef();
        int numBuildings= propertyCell.getNumberOfBuildings();
        if(numBuildings == 0){
            int value = streetPropertyCard.getMortgageValue();
            try {
                Transaction transaction = new Transaction(
                        player,
                        bank,
                        new AssetCollection(0),
                        new AssetCollection(value)
                );
                transaction.settleTransaction();
            } catch (AssetOwner.AssetNotFoundException ex) {

            }
            streetPropertyCard.mortagage(); // set card to be mortaged;

        }else {
            throw new MortagagingError(streetPropertyCard);
        }


    }

    public void unmortagageProperty(StreetPropertyCard streetPropertyCard) throws MortagagingError {
        //change property card from morgage to unmorgaged and pay the bank money
        int value = streetPropertyCard.getMortgageValue();
        if(streetPropertyCard.isMortaged){

            try {
                Transaction transaction = new Transaction(
                        player,
                        bank,
                        new AssetCollection(value),
                        new AssetCollection(0)
                );
                transaction.settleTransaction();
            } catch (AssetOwner.AssetNotFoundException ex) {

            }
            streetPropertyCard.unmortagage();

        }else {
            throw new MortagagingError(streetPropertyCard);
        }

    }

    public void sellProperty(StreetPropertyCard streetPropertyCard) throws MortagagingError {
        StreetPropertyCell propertyCell = (StreetPropertyCell) streetPropertyCard.getCellRef();
        int numBuildings = propertyCell.getNumberOfBuildings();
       //if no buildings and not mortaged
        if(numBuildings == 0 && streetPropertyCard.isMortaged == false) {
            try {
                Transaction transaction = new Transaction(
                        player,
                        bank,
                        new AssetCollection(streetPropertyCard),
                        new AssetCollection(streetPropertyCard.getPrice())
                );
                transaction.settleTransaction();
            } catch (AssetOwner.AssetNotFoundException ex) {

            }
        }
        else {
            throw new MortagagingError(streetPropertyCard);

        }


    }

    public static class MortagagingError extends Exception {
        public MortagagingError(StreetPropertyCard streetPropertyCard){
            super (
                    streetPropertyCard.toString() +" :   ERROR :Mortagaging "
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


    // purchase house on owned property
    // sell house on owned property
    //mortgage a property that the player owns
}
