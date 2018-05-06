package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.StationPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;

public class PurchasePropertyOption {
    private Bank bank;
    private LeadController leadController;
    public PurchasePropertyOption (Bank bank,LeadController leadController){
        this.bank = bank;
        this.leadController = leadController;



    }
    //takes us to auction class
    //TODO
    public void auction(){

        //throw to auction class

    }

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
