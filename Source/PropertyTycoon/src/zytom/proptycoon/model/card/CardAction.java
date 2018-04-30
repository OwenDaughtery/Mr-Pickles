/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.card;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.FreeParking;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.Asset;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.MoneyAsset;
import zytom.proptycoon.model.assets.Transaction;

import static zytom.proptycoon.model.assets.AssetOwner.*;

/**
 *
 * @author Ayman Free
 *
 * Has all methods that can be made by PotLuck and Opertunity Knocks cards.
 * Execute will call relevent methods to implement
 */
public class CardAction {
    enum Type{GAIN,PAY,FORWARD,BACKWARD,STEP,CALCULATE,MULTI,CHOOSE};
    Type type;
    int value;

    public CardAction(Type type, int value){
        this.type = type;
        this.value = value;

    }

    /**
     * @author Ayman Free
     * function pays the player from the bank
     * @param bank
     * @param player
     * @param value
     */
    private void payPlayer(Bank bank , Player player , int value){
        try {
            (new Transaction(bank,player,new MoneyAsset(value),
                    new MoneyAsset(0))).settleTransaction();
        } catch (AssetNotFoundException ex) {

        }

    }

    /**
     * @author Ayman Free
     * player pays bank
     * @param bank
     * @param player
     * @param value
     */
    private void payBank(Bank bank , Player player , int value) throws AssetNotFoundException{
        Asset bankAsset = new MoneyAsset(0);
        Asset playerAsset = new MoneyAsset(value);
        try {
            (new Transaction(bank,player,bankAsset ,
                    playerAsset)).settleTransaction();
        } catch (AssetNotFoundException ex) {
            throw new AssetNotFoundException(player,playerAsset);
        }
    }


    /**
     * @author Ayman Free
     * player payes free parking fine
     * @param freeParking
     * @param player
     * @param value
     */
    private void payFreeParking(FreeParking freeParking , Player player , int value) throws AssetNotFoundException {
        Asset freeParkingAsset = new MoneyAsset(0);
        Asset playerAsset = new MoneyAsset(value);
        try {
            (new Transaction(freeParking,player,freeParkingAsset,
                    playerAsset)).settleTransaction();
        } catch (AssetNotFoundException ex) {
            throw new AssetNotFoundException(player,playerAsset);
        }
    }

    /**
     * @author Ayman Free
     * Player1 pays player 2.
     * @param player1
     * @param player2
     * @param value
     */
    private void playerPayPlayer(Player player1 , Player player2 , int value) throws AssetNotFoundException {

        Asset player1Asset = new MoneyAsset(0);
        Asset player2Asset = new MoneyAsset(value);
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
    private void moveForward(Player player, int space){
        player.moveTo(space,true);
    }

    /**
     * @author Ayman Free
     * Move player backwards to space
     * @param player
     * @param space
     */
    private void moveBackwards(Player player, int space){
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
