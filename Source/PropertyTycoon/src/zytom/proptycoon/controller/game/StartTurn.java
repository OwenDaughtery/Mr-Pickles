package zytom.proptycoon.controller.game;

import zytom.proptycoon.controller.game.LeadController;
import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Player;

public class StartTurn {

    private Bank bank;

    LeadController leadController;
    public StartTurn(Bank bank, LeadController leadController) {
        this.bank = bank;
        this.leadController = leadController;
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
