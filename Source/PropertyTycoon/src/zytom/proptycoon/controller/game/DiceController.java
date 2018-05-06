package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.card.PropertyCard;

public class DiceController {
    private Dice dice;
    private LeadController leadController;

    public DiceController(Dice dice,LeadController leadController) {
        this.dice = dice;
        this.leadController = leadController;

    }


    /**
     * Rolls the dice and moves the player. If they roll a double, increment the tile.
     * @param player
     * @param board
     * @param bank
     * @throws Board.CellNotFoundException
     * @throws PlayerController.LandedOnJailException
     * @throws PlayerController.CellNotFoundException
     */
    public void roll(Player player, Board board, Bank bank) throws Board.CellNotFoundException, PlayerController.LandedOnJailException, PlayerController.CellNotFoundException, PropertyCard.ToManyDaymHousesException {
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
            leadController.playerController.hasLanded(board.getCell(player.getPosition()),board,dice,player);
        }

    }

}
