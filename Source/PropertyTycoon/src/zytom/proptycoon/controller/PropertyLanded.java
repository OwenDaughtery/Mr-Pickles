package zytom.proptycoon.controller;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.card.Card;
import zytom.proptycoon.model.cell.Cell;
import zytom.proptycoon.model.cell.PropertyCell;

import java.util.ArrayList;

public class PropertyLanded {

    private ArrayList<Player> players;
    private Bank bank;
    public PropertyLanded( ArrayList<Player> players,Bank bank){
        this.players = players;
        this.bank = bank;
    }

    public void landedOnProperty(PropertyCell cell, Player currentPlayer){
        Card card = cell.getAssociatedCard();
        if(currentPlayer.checkHasAsset(card)){
            //do shit
        }else if(bank.checkHasAsset(card)){
            //do shit
        }else{
            boolean cardFound=false;
            int x = 0;
            while (!cardFound || x<players.size()) {
                if(players.get(x).checkHasAsset(card)){
                    cardFound = true;
                }
                x++;
            }
            if(!cardFound){

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
