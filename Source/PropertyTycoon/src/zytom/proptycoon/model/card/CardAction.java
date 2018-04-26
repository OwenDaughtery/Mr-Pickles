/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.card;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Player;

/**
 *
 * @author Tom Chesters
 */
public class CardAction {
    enum type{};
    int value;
    boolean movingForewards;

    public CardAction(enum type, int value ){


    }

    /**
     *
     * @param bank
     * @param player
     * @param value
     */
    public void payPlayer(Bank bank , Player player , int value){


    }

    /**
     *
     * @param bank
     * @param player
     * @param value
     */
    public void payBank(Bank bank , Player player , int value){

    }

    
}
