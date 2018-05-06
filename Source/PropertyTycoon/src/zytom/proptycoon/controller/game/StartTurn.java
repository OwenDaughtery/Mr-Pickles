package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Player;

public class StartTurn {

    private Bank bank;

    GameController gameController;
    public StartTurn(Bank bank, GameController gameController) {
        this.bank = bank;
        this.gameController = gameController;
    }

    public void startTurnSequence(Player currentPlayer) {
        if (currentPlayer.getPosition() == 40)
        {
            if (currentPlayer.getTurnsInJail() > 2) {
                currentPlayer.moveTo(10, false, bank);
                //Roll Dice Button
            } else {
                currentPlayer.setTurnsInJail(currentPlayer.getTurnsInJail() + 1);
                //End turn button
            }
        } else

        {
            //Roll Dice Button
        }
    }
}
