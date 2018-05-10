package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.StationPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;

/**
 *  @author Ayman, Max, Tom
 */
public class PurchasePropertyOption {
    private final Bank bank;
    private final GameController gameController;
    public PurchasePropertyOption (Bank bank,GameController gameController){
        this.bank = bank;
        this.gameController = gameController;



    }
    //takes us to auction class
    //TODO
    public void auction(){

        //throw to auction class

    }

    /**
     *
     * Player purchases a street property from the bank
     * @param card
     * @param player
     */
    public void purchaseProperty(StreetPropertyCard card,Player player){
        try{

            Transaction transaction = new Transaction(
                    player,
                    bank,
                    new AssetCollection(card.getPrice()),
                    new AssetCollection(card));
            transaction.settleTransaction();
        }catch (AssetOwner.AssetNotFoundException ex){
            //TODO
            // Asset manager will be passed an int of how much is outstanding

        }
    }

    /**
     * Player purchases a station property from the bank
     * @param card
     * @param player
     */
    public void purchaseProperty(StationPropertyCard card,Player player){
        try{

            Transaction transaction = new Transaction(
                    player,
                    bank,
                    new AssetCollection(card.getPrice()),
                    new AssetCollection(card));
            transaction.settleTransaction();
        }catch (AssetOwner.AssetNotFoundException ex){
            //TODO
            // Asset manager will be passed an int of how much is outstanding

        }
    }

    /**
     * Player purchases a utility property from the bank
     * @param card
     * @param player
     */
    public void purchaseProperty(UtilityPropertyCard card,Player player){
        try{

            Transaction transaction = new Transaction(
                    player,
                    bank,
                    new AssetCollection(card.getPrice()),
                    new AssetCollection(card));
            transaction.settleTransaction();
        }catch (AssetOwner.AssetNotFoundException ex){
            //TODO
            // Asset manager will be passed an int of how much is outstanding

        }
    }
}
