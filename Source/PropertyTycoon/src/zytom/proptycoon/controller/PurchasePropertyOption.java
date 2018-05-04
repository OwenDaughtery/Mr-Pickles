package zytom.proptycoon.controller;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.PropertyCard;
import zytom.proptycoon.model.card.StationPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;

public class PurchasePropertyOption {
    private Player player;
    private Bank bank ;
    public PurchasePropertyOption(Player player, Bank bank ){

        this.bank = bank ;
        this.player =player;




    }
    //takes us to auction class
    //TODO
    public void auction(){

        //throw to auction class

    }

    public void purchaseProperty(StreetPropertyCard card){
        try{

            Transaction transaction = new Transaction(
                    player,
                    bank,
                    new AssetCollection(card),
                    new AssetCollection(card.getPrice()));
            transaction.settleTransaction();
        }catch (AssetOwner.AssetNotFoundException ex){
            //TODO
            // Asset manager will be passed an int of how much is outstanding

        }
    }

    public void purchaseProperty(StationPropertyCard card){
        try{

            Transaction transaction = new Transaction(
                    player,
                    bank,
                    new AssetCollection(card),
                    new AssetCollection(card.getPrice()));
            transaction.settleTransaction();
        }catch (AssetOwner.AssetNotFoundException ex){
            //TODO
            // Asset manager will be passed an int of how much is outstanding

        }
    }
    public void purchaseProperty(UtilityPropertyCard card){
        try{

            Transaction transaction = new Transaction(
                    player,
                    bank,
                    new AssetCollection(card),
                    new AssetCollection(card.getPrice()));
            transaction.settleTransaction();
        }catch (AssetOwner.AssetNotFoundException ex){
            //TODO
            // Asset manager will be passed an int of how much is outstanding

        }
    }
}
