package zytom.proptycoon.controller.preGame;

import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;

import java.util.ArrayList;

public class TurnOrderDecider {

    /**
     *
     */
    ArrayList<Player> players;
    Player firstPlayer;
    int diceMax = 0;
    Dice dice;

    /**
     * @param players
     */
    public TurnOrderDecider(ArrayList<Player> players){
        this.players = players;
        dice = new Dice();

    }


    /**
     * rolls the dice if its the highest value, set player to first player.
     * @param currentPlayer
     */
    public void rollDice(Player currentPlayer) {
        dice.roll();
        int diceValue = dice.getFirstValue()+dice.getSecondValue();
        if(diceValue>diceMax){
            diceMax = diceValue;
            firstPlayer = currentPlayer;
        }
    }

    /**
     *
     * @return firstPlayer
     */
    public Player getFirstPlayer(){
        return firstPlayer;
    }




}
