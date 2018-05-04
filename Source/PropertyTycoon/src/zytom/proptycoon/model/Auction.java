package zytom.proptycoon.model;

import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.PropertyCard;
import zytom.proptycoon.model.card.StationPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class Auction generates an Auction for an unsold property a player has landed on
 */
public class Auction {
    private ArrayList<Player> players;
    private Bank bank;

    public Auction(ArrayList<Player> players,Bank bank){
        this.players = players;
        this.bank =bank;
    }

    public void startAuction(UtilityPropertyCard propertyCard, Player currentPlayer){
        //find out who has passed go

        //put them into an array
        ArrayList<Player> takingPart = new ArrayList<>();
        for (Player player:
             players) {
            if(player != currentPlayer && player.hasPlayerPassedGo()){
                takingPart.add(player);
            }
        }

        if(takingPart.size() == 0){

        }else if(takingPart.size() == 1){
            // option for that player to purchase
        }
        else if (takingPart.size() > 1){
            int[] amountAndWinner = bidding(takingPart);

            try {

                Transaction transaction = new Transaction(
                        takingPart.get(amountAndWinner[1]),
                        bank,
                        new AssetCollection(amountAndWinner[0]),
                        new AssetCollection(propertyCard)
                );
                transaction.settleTransaction();
            } catch (AssetOwner.AssetNotFoundException ex) {

            }

        }
    }

    public void startAuction(StationPropertyCard propertyCard, Player currentPlayer){
        //find out who has passed go

        //put them into an array
        ArrayList<Player> takingPart = new ArrayList<>();
        for (Player player:
                players) {
            if(player != currentPlayer && player.hasPlayerPassedGo()){
                takingPart.add(player);
            }
        }

        if(takingPart.size() == 0){

        }else if(takingPart.size() == 1){
            // option for that player to purchase
        }
        else if (takingPart.size() > 1){
            int[] amountAndWinner = bidding(takingPart);

            try {

                Transaction transaction = new Transaction(
                        takingPart.get(amountAndWinner[1]),
                        bank,
                        new AssetCollection(amountAndWinner[0]),
                        new AssetCollection(propertyCard)
                );
                transaction.settleTransaction();
            } catch (AssetOwner.AssetNotFoundException ex) {

            }

        }
    }

    public void startAuction(StreetPropertyCard propertyCard, Player currentPlayer){
        //find out who has passed go

        //put them into an array
        ArrayList<Player> takingPart = new ArrayList<>();
        for (Player player:
                players) {
            if(player != currentPlayer && player.hasPlayerPassedGo()){
                takingPart.add(player);
            }
        }

        if(takingPart.size() == 0){

        }else if(takingPart.size() == 1){
            // option for that player to purchase
        }
        else if (takingPart.size() > 1){
            int[] amountAndWinner = bidding(takingPart);

            try {

                Transaction transaction = new Transaction(
                        takingPart.get(amountAndWinner[1]),
                        bank,
                        new AssetCollection(amountAndWinner[0]),
                        new AssetCollection(propertyCard)
                );
                transaction.settleTransaction();
            } catch (AssetOwner.AssetNotFoundException ex) {

            }

        }
    }

    public int[] bidding(ArrayList<Player> takingPart){
        ArrayList<Integer>bids = new ArrayList<>();
        for (Player player: takingPart
             ) {
            bids.add(bid(player));
        }
        int[] amountAndWinner = getWinner(bids);
        return amountAndWinner;

    }
    public int bid(Player player){
        int balance = player.getAssetCollection().getMoney();
        //TODO should return number written in a box, cant be over  player balance;
        return 5000;
    }

    public int[] getWinner(ArrayList<Integer>bids){
        int maxBid = 0;
        int indexOfWinner = 0;
        //TODO if can be fucked, check for 2 same bids
        for (int bid:bids
             ) {
            if (bid>maxBid){
                maxBid = bid;
                indexOfWinner = bids.indexOf(bid);
            }
        }
        return new int[] { maxBid, indexOfWinner };

    }
}
