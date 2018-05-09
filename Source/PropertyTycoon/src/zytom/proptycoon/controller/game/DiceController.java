package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;

public class DiceController {

    private final Dice dice;

    public DiceController(
            Dice dice
    ) {
        this.dice = dice;
    }

    /**
     * Rolls the dice and moves the player. If they roll a double, increment the
     * tile.
     *
     * @param playerController
     */
    public void roll(
            PlayerController playerController
    ) {
        Player player = playerController.getPlayer();
        dice.roll();
        int dice1 = dice.getFirstValue();
        int dice2 = dice.getSecondValue();
        if (dice1 == dice2) {
            player.incrementDoublesRolled();
        }
    }
    
    
    public Dice getDice() {
        return this.dice;
    }
}
