/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.card;

import java.util.ArrayList;
import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.FreeParking;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.Transaction;

import static zytom.proptycoon.model.assets.AssetOwner.*;

/**
 *
 * @author Ayman Free, Zenos Pavlakou
 *
 * Has all methods that can be made by PotLuck and Opertunity Knocks cards.
 * Execute will call relevent methods to implement
 */
public class CardAction {
    
    enum Type{BANK_PAYS_PLAYER, PLAYER_PAYS_BANK, PAY_FREE_PARKING, 
              MOVE_FORWARD, MOVE_BACKWARD, GO_TO_JAIL, GET_OUT_OF_JAIL_POT_LUCK, 
              GET_OUT_OF_JAIL_OPP_KNOCKS, COLLECT_FROM_ALL, MOVE_FORWARD_TO};
    
    Type type;
    int value;

    
    /**
     * 
     * @param action The string action read fromt he CSV of PropertyCells.csv
     * @param value The value associated with the action
     * @throws zytom.proptycoon.model.card.CardAction.InvalidActionException
     */
    public CardAction(String action, int value) throws InvalidActionException {
        switch(action) {
            case "BANK PAYS PLAYER":
                this.type = Type.BANK_PAYS_PLAYER;
                break;
            case "PLAYER PAYS BANK":
                this.type = Type.PLAYER_PAYS_BANK;
                break;
            case "PAY FREE PARKING":
                this.type = Type.PAY_FREE_PARKING;
                break;
            case "MOVE FORWARD":
                this.type = Type.MOVE_FORWARD;
            case "MOVE BACKWARD":
                this.type = Type.MOVE_BACKWARD;
                break;
            case "GO TO JAIL":
                this.type = Type.GO_TO_JAIL;
                break;
            case "COLLECT FROM ALL":
                this.type = Type.COLLECT_FROM_ALL;
                break;
            case "GET OUT OF JAIL POT LUCK":
                this.type = Type.GET_OUT_OF_JAIL_POT_LUCK;
                break;
            case "GET OUT OF JAIL OPP KNOCKS":
                this.type = Type.GET_OUT_OF_JAIL_OPP_KNOCKS;
                break;

        }
        
        if(this.type == null) {
            throw new InvalidActionException(action);
        }
        
        this.value = value;
    }
    
    
    /**
     * @author Zenos Pavlakou
     * 
     * Performs the action of the card
     * 
     * @param freeParking The instance of FreeParking (incase it is necessary to pay free parking)
     * @param bank The instance of the bank
     * @param player The player who picked up the card
     * @param players The array of players (incase it is necessary to collect fund from all)
     * @param card The instance of the ActionCard
     * @throws zytom.proptycoon.model.assets.AssetOwner.AssetNotFoundException 
     */
    public void performAction(FreeParking freeParking, Bank bank, Player player, ArrayList<Player> players, ActionCard card) throws AssetNotFoundException{
        switch(this.type) {
            case BANK_PAYS_PLAYER:
                bankPayPlayer(bank, player, this.value);
                giveCardBackToBank(bank, player, card);
                break;
            case PLAYER_PAYS_BANK:
                playerPayBank(bank, player, this.value);
                giveCardBackToBank(bank, player, card);
                break;
            case PAY_FREE_PARKING:
                payFreeParking(freeParking, player, this.value);
                giveCardBackToBank(bank, player, card);
                break;
            case MOVE_FORWARD:
                moveForward(player, this.value, bank);
                giveCardBackToBank(bank, player, card);
                break;
            case MOVE_BACKWARD:
                moveBackward(player, this.value, bank);
                giveCardBackToBank(bank, player, card);
                break;
            case GO_TO_JAIL:
                moveToJail(player, bank);
                giveCardBackToBank(bank, player, card);
                break;
            case COLLECT_FROM_ALL:
                collectFromAll(players, player, value);
                giveCardBackToBank(bank, player, card);
                break;
            case GET_OUT_OF_JAIL_POT_LUCK:
                giveJailFreeCardFromPotLuck(bank, player, (PotLuckCard) card);
                break;
            case GET_OUT_OF_JAIL_OPP_KNOCKS:
                giveJailFreeCardFromOppKnocks(bank, player, (OpportunityKnocksCard) card);
                break;
        }  
    }
    
    
    private void giveCardBackToBank(Bank bank, Player player, ActionCard card) {
        if(card instanceof PotLuckCard) {
            player.getAssetCollection().getPotLuckCards().remove((PotLuckCard)card);
            bank.getAssetCollection().getPotLuckCards().add((PotLuckCard)card);
        } else if(card instanceof OpportunityKnocksCard) {
            player.getAssetCollection().getOpportunityKnocksCards().remove((OpportunityKnocksCard)card);
            bank.getAssetCollection().getOpportunityKnocksCards().add((OpportunityKnocksCard)card);
        }
    }
    
    /**
     * @author Zenos Pavlakou
     * 
     * Gives player GET OUT OF JAIL FREE card from potLuck deck in bank
     * 
     * @param bank The bank
     * @param player The player receiving the card
     * @param getOutOfJailFreeCard The instance of the card
     * @throws zytom.proptycoon.model.assets.AssetOwner.AssetNotFoundException 
     */
    public void giveJailFreeCardFromPotLuck(Bank bank, Player player, PotLuckCard getOutOfJailFreeCard) throws AssetNotFoundException {

        AssetCollection fromBank = new AssetCollection(getOutOfJailFreeCard);
        AssetCollection fromPlayer = new AssetCollection(0);
        
        Transaction tx = new Transaction(bank, player, fromBank, fromPlayer);
        tx.settleTransaction();
    }
    
    
    /**
     * @author Zenos Pavlakou
     * 
     * Gives player GET OUT OF JAIL FREE card from opportunityKnocks deck in bank
     * 
     * @param bank The bank
     * @param player The player receiving the card
     * @param getOutOfJailFreeCard The instance of the card
     * @throws zytom.proptycoon.model.assets.AssetOwner.AssetNotFoundException 
     */
    public void giveJailFreeCardFromOppKnocks(Bank bank, Player player, OpportunityKnocksCard getOutOfJailFreeCard) throws AssetNotFoundException {
        
        AssetCollection fromBank = new AssetCollection(getOutOfJailFreeCard);
        AssetCollection fromPlayer = new AssetCollection(0);
        
        Transaction tx = new Transaction(bank, player, fromBank, fromPlayer);
        tx.settleTransaction(); 
    }
    
    

    /**
     * @author Ayman Free, Zenos Pavlakou (Ayman did most the work here!)
     * function pays the player from the bank
     * @param bank
     * @param player
     * @param value
     */    
    private void bankPayPlayer(Bank bank , Player player , int value){
        try {
            (new Transaction(bank,player,new AssetCollection(value),
                   new AssetCollection(0))).settleTransaction();
        } catch (AssetNotFoundException ex) {
          //  Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @author Ayman Free, Zenos Pavlakou (Ayman did most the work here!)
     * player pays bank
     * @param bank
     * @param player
     * @param value
     */
    private void playerPayBank(Bank bank , Player player , int value) throws AssetNotFoundException{
        AssetCollection bankAsset = new AssetCollection(0);
        AssetCollection playerAsset = new AssetCollection(value);
        try {
            (new Transaction(bank,player,bankAsset ,
                    playerAsset)).settleTransaction();
        } catch (AssetNotFoundException ex) {
            throw new AssetNotFoundException(player,playerAsset);
        }
    }

    

    /**
     * @author Ayman Free, Zenos Pavlakou (Ayman did most the work here!)
     * player payes free parking fine
     * @param freeParking
     * @param player
     * @param value
     */
    private void payFreeParking(FreeParking freeParking , Player player , int value) throws AssetNotFoundException {
        AssetCollection freeParkingAsset = new AssetCollection(0);
        AssetCollection playerAsset = new AssetCollection(value);
        try {
            (new Transaction(freeParking,player,freeParkingAsset,
                    playerAsset)).settleTransaction();
        } catch (AssetNotFoundException ex) {
            throw new AssetNotFoundException(player,playerAsset);
        }
    }

    
    
    /**
     * @author Ayman Free, Zenos Pavlakou (Ayman did most the work here!)
     * Player1 pays player 2.
     * @param player1
     * @param player2
     * @param value
     */
    private void playerPayPlayer(Player player1 , Player player2 , int value) throws AssetNotFoundException {

        AssetCollection player1Asset = new AssetCollection(0);
        AssetCollection player2Asset = new AssetCollection(value);
        try {
            (new Transaction(player1,player2,player1Asset ,
                    player2Asset)).settleTransaction();
        } catch (AssetNotFoundException ex) {
            throw new AssetNotFoundException(player2,player2Asset);
        }
    }
    
    
    /**
     * @author Zenos Pavlakou
     * 
     * Collects funds from all players
     * 
     * @param players The array of players currently playing the game
     * @param recipient The player who will receive the funds
     * @param value The amount of money to collect from each player
     * @throws zytom.proptycoon.model.assets.AssetOwner.AssetNotFoundException 
     */
    private void collectFromAll(ArrayList<Player> players, Player recipient, int value) throws AssetNotFoundException{
        for(Player player : players) {
            if(!player.equals(recipient)) {
                playerPayPlayer(recipient, player, value);
            }
        }
    }
    
    

    /**
     * @author Ayman Free
     * Move player forward to space
     * @param player
     * @param space
     */
    private void moveForward(Player player, int space, Bank bank) throws AssetNotFoundException {
        player.moveTo(space,true,bank);
    }
    
    

    /**
     * @author Ayman Free
     * Move player backwards to space
     * @param player
     * @param space
     */
    private void moveBackward(Player player, int space, Bank bank) throws AssetNotFoundException {
        player.moveTo(space,false,bank);
    }
    
    
    
    private void moveToJail(Player player, Bank bank) {
        player.moveTo(40, false, bank);
    }
    

    /**
     * @author Ayman Free
     * Move player backwards a specified number of spaces
     * @param player
     * @param space
     */
    private void stepBack(Player player, int space, Bank bank){
        player.move(space,bank);
    }
    
    
    public static class InvalidActionException extends Exception {
        
        /**
         * Generate the exception message.
         * @param errorMessage
         */
        public InvalidActionException(
                String errorMessage
        ) {
            super ("Invalid action " + errorMessage);
        }


        /**
         * @return The exception message.
         */
        @Override
        public String getMessage()
        {
            return super.getMessage();
        }
    }
}
