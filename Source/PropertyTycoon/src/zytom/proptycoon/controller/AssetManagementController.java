package zytom.proptycoon.controller;
import zytom.proptycoon.controller.game.LeadController;
import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.cell.StreetPropertyCell;

/**
 * Class AssetManagementController is the controller class for the management of a players associated assets.
 */
public class AssetManagementController {
    Player player;
    Bank bank;
    LeadController leadController;
    public AssetManagementController(Player player, Bank bank, LeadController leadController){

    this.player = player;
    this.bank = bank;
    this.leadController = leadController;

    }

    /**
     * Method buyHouse allows the purchase of houses on properties owned by the player
     * @param streetPropertyCard
     * @throws StreetPropertyCell.ConstructionError
     */
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

    /**
     * Method sellhouse allows the removal and refund of a house previously build on a player owned property
     * @param streetPropertyCard
     * @throws StreetPropertyCell.ConstructionError
     */
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
     * Method calls for a property to be mortaged and handles transactions between the player and the bank ;
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

    /**
     * Method unmortagageProperty calls for a player owned property that is mortagaged to become unmortaged
     * @param streetPropertyCard
     * @throws MortagagingError
     */
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

    /**
     * Method sellProperty facilitates the sale of a player owned asset to the bank
     * @param streetPropertyCard
     * @throws MortagagingError
     */
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
                    streetPropertyCard.toString() +" :   ERROR : Banks are dicks  "
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
