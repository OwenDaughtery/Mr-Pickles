/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.card;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.MoneyAsset;
import zytom.proptycoon.model.assets.Transaction;

/**
 *
 * @author Tom Chesters
 */
public class CardAction {
    enum type{};
    int value;
    boolean movingForewards;

    public CardAction(enum type, int value){


    }

    /**
     * function pays the player from the bank
     * @param bank
     * @param player
     * @param value
     */
    public void payPlayer(Bank bank , Player player , int value){
        Transaction.settleTransaction(bank,player,new MoneyAsset(value),new MoneyAsset(0));

    }

    /**
     * player pays bank
     * @param bank
     * @param player
     * @param value
     */
    public void payBank(Bank bank , Player player , int value){
        Transaction.settleTransaction(bank,player,new MoneyAsset(0),new MoneyAsset(value));
    }

    /**
     *@author Ayman Free
     */

    /**
     *
     * player payes free parking fine
     * @param freeParking
     * @param player
     * @param value
     */
    public void payFreeParking(FreeParking freeParking , Player player , int value){
        Transaction.settleTransaction(freeParking ,player,new MoneyAsset(0),new MoneyAsset(value));
    }

    /**
     * Player1 pays player 2.
     * @param player1
     * @param player2
     * @param value
     */
    public void playerPayPlayer(Player player1 , Player player2 , int value){
        Transaction.settleTransaction(player1 ,player2,new MoneyAsset(value),new MoneyAsset(0));
    }
    
}
