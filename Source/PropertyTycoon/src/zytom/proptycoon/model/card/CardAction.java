/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.card;

//import java.util.logging.Level;
//import java.util.logging.Logger;
import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.FreeParking;
import zytom.proptycoon.model.Player;
//import zytom.proptycoon.model.assets.Asset; //Asset no longer exists
//import zytom.proptycoon.model.assets.MoneyAsset; //MoneyAsset no longer exists
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
    enum Type{GAIN,PAY,FORWARD,BACKWARD,STEP,CALCULATE,MULTI,CHOOSE};
    Type type;
    int value;

    public CardAction(String action, int value){
        
        switch(action) {
            case "GAIN":
                this.type = Type.GAIN;
                break;
            case "PAY":
                this.type = Type.PAY;
                break;
            case "FORWARD":
                this.type = Type.FORWARD;
                break;
            case "BACKWARD":
                this.type = Type.BACKWARD;
            case "STEP":
                this.type = Type.STEP;
                break;
            case "CALCULATE":
                this.type = Type.CALCULATE;
                break;
            case "MULTI":
                this.type = Type.MULTI;
                break;
            case "CHOOSE":
                this.type = Type.CHOOSE;
                break;
        }
        
        this.value = value;
    }

    /**
     * @author Ayman Free, Zenos Pavlakou (Ayman did most the work here!)
     * function pays the player from the bank
     * @param bank
     * @param player
     * @param value
     */    
    private void payPlayer(Bank bank , Player player , int value){
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
    private void payBank(Bank bank , Player player , int value) throws AssetNotFoundException{
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
     * @author Ayman Free
     * Move player forward to space
     * @param player
     * @param space
     */
    private void moveForward(Player player, int space) throws AssetNotFoundException {
        player.moveTo(space,true);
    }

    /**
     * @author Ayman Free
     * Move player backwards to space
     * @param player
     * @param space
     */
    private void moveBackwards(Player player, int space) throws AssetNotFoundException {
        player.moveTo(space,false);
    }

    /**
     * @author Ayman Free
     * Move player backwards a specified number of spaces
     * @param player
     * @param space
     */
    private void stepBack(Player player, int space){
        player.move(space);
    }

    public void execute(){

        
    }
}
