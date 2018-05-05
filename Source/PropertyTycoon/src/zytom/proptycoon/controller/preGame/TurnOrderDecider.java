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
    int rollDiceTurn = 0;
    /**
     * @param players
     */
    public TurnOrderDecider(ArrayList<Player> players){
        this.players = players;
        dice = new Dice();

    }


    /**
     * rolls the dice if its the highest value, set player to first player.
     */
    public void rollDice() throws EveryPlayerHasRolledException {
        if(rollDiceTurn>players.size()-2){
            throw new EveryPlayerHasRolledException();
        }
        Player currentPlayer = players.get(rollDiceTurn);
        dice.roll();
        int diceValue = dice.getFirstValue()+dice.getSecondValue();
        if(diceValue>diceMax){
            diceMax = diceValue;
            firstPlayer = currentPlayer;
        }
        rollDiceTurn = rollDiceTurn+1;
    }

    /**
     *
     * @return firstPlayer
     */
    public Player getFirstPlayer(){
        return firstPlayer;
    }

    public static class EveryPlayerHasRolledException extends Exception {
        public EveryPlayerHasRolledException(){
            super (
                    "Every Player Has Rolled the dice, start the game!"
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
