package zytom.proptycoon.controller;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.Card;
import zytom.proptycoon.model.card.PropertyCard;
import zytom.proptycoon.model.cell.Cell;
import zytom.proptycoon.model.cell.PropertyCell;

import java.util.ArrayList;

public class PropertyLandedLogic {

    private ArrayList<Player> players;
    private Bank bank;
    public PropertyLandedLogic( ArrayList<Player> players,Bank bank){
        this.players = players;
        this.bank = bank;
    }

    public void landedOnProperty(PropertyCell cell, Player currentPlayer,Dice dice){
        PropertyCard card = cell.getAssociatedCard();
        if(currentPlayer.checkHasAsset(card)){
            //do shit
        }else if(bank.checkHasAsset(card)){
            //

        }else{//paying player
            boolean cardFound=false;
            int x = 0;
            while (!cardFound && x<players.size()) {
                if(players.get(x).checkHasAsset(card)){
                    cardFound = true;
                }
                x++;
            }
            if(!cardFound){

            }else {
                try{
                    Player receiverOfRent = players.get(x);
                    Transaction transaction = new Transaction(
                            currentPlayer,
                            receiverOfRent,
                            new AssetCollection(card.getRent(dice ,receiverOfRent)),
                            new AssetCollection(0));
                    transaction.settleTransaction();
                }catch (AssetOwner.AssetNotFoundException ex){
                    //TODO
                    // Asset manager will be passed an int of how much is outstanding

                }

                players.get(x);
            }
        }

    }

    public static class CardNotFoundException extends Exception {
        public CardNotFoundException(Card card){
            super (
                    card.toString()+" not found."
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
