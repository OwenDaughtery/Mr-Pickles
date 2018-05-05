package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.cell.StreetPropertyCell;

/**
 * Settles Buying and selling houses, morgaging and selling propertys.
 * @author ayman and maxxx
 */
public class AssetManagementController {
    Bank bank;
    LeadController leadController;

    /**
     *
     * @param bank
     * @param leadController
     */
    public AssetManagementController(Bank bank, LeadController leadController){
    this.bank = bank;
    this.leadController = leadController;

    }


    /**
     * buys a house on given property
     * TODO check player owns all prop of same colour
     * @param player
     * @param streetPropertyCard
     * @throws StreetPropertyCell.ConstructionError
     */
    public void buyHouse(Player player,StreetPropertyCard streetPropertyCard) throws StreetPropertyCell.ConstructionError {

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

    /**
     * sells a house on a given property
     * @param player
     * @param streetPropertyCard
     * @throws StreetPropertyCell.ConstructionError
     */
    public void sellHouse(Player player,StreetPropertyCard streetPropertyCard) throws StreetPropertyCell.ConstructionError {
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
     * morgages a property and handles transactions ;
     * @param streetPropertyCard
     */
    public void mortagageProperty(Player player,StreetPropertyCard streetPropertyCard) throws MortagagingError {

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

    /**
     *  unmorgages a property and handles transactions ;
     * @param player
     * @param streetPropertyCard
     * @throws MortagagingError
     */
    public void unmortagageProperty(Player player,StreetPropertyCard streetPropertyCard) throws MortagagingError {
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

    /**
     *  sells a property back to the bank and handles transactions ;
     * @param player
     * @param streetPropertyCard
     * @throws MortagagingError
     */
    public void sellProperty(Player player,StreetPropertyCard streetPropertyCard) throws MortagagingError {
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

}
