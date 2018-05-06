package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.Card;
import zytom.proptycoon.model.card.PropertyCard;
import zytom.proptycoon.model.cell.PropertyCell;
import java.util.ArrayList;

public class PropertyLandedLogic {

<<<<<<< Updated upstream
    private final ArrayList<Player> players;
    private final Bank bank;
    private final LeadController leadController;
    
    public PropertyLandedLogic( ArrayList<Player> players,Bank bank, LeadController leadController){
=======
    private ArrayList<Player> players;
    private Bank bank;
    private GameController gameController;
    public PropertyLandedLogic( ArrayList<Player> players,Bank bank, GameController gameController){
>>>>>>> Stashed changes
        this.players = players;
        this.bank = bank;
        this.gameController = gameController;
    }

    public void landedOnProperty(PropertyCell cell, Player currentPlayer,Dice dice) throws PropertyCard.ToManyDaymHousesException{
        PropertyCard card = cell.getAssociatedCard();
        if(currentPlayer.checkHasAsset(card)){
            //do nothing
        }else if(bank.checkHasAsset(card)){
            //do shit
        }else{//paying player
            boolean cardFound=false;
            int x = 0;
            while (!cardFound && x<players.size()) {
                if(players.get(x).checkHasAsset(card)){
                    cardFound = true;
                }
                x++;
            }
            if(!cardFound) {

            }else {
                try{
                    Player receiverOfRent = players.get(x);
                    Transaction transaction = new Transaction(
                            currentPlayer,
                            receiverOfRent,
                            new AssetCollection(card.getRent(dice ,receiverOfRent,bank)),
                            new AssetCollection(0));
                    transaction.settleTransaction();
                }catch (AssetOwner.AssetNotFoundException ex){

                }

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
