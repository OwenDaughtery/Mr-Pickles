package zytom.proptycoon.controller;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;

public class DiceController {
    private Dice dice;
    private LeadController leadController;

    public DiceController(Dice dice,LeadController leadController) {
        this.dice = dice;
        this.leadController = leadController;

    }


    /**
     * method calls model to roll dice in game
     */
    public void roll(Player player, Board board, Bank bank) throws Board.CellNotFoundException, PlayerController.LandedOnJailException, PlayerController.CellNotFoundException {
        dice.roll();
        int dice1 = dice.getFirstValue();
        int dice2 = dice.getSecondValue();
        int moveAmount = dice1 + dice2;
        if (dice1 == dice2) {
            player.setDoublesRolled(player.getDoublesRolled()+1);
        }
        if (player.getDoublesRolled() > 3) {
            player.moveTo(40, false, bank);
            player.setDoublesRolled(0);
        } else {
            player.move(moveAmount, bank);
            player.setDoublesRolled(0);
            leadController.playerController.hasLanded(board.getCell(player.getPosition()),board,dice);
        }

    }

}
