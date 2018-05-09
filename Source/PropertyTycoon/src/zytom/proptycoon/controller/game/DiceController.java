package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.card.PropertyCard;

public class DiceController {
    private final Dice dice;
    private final GameController gameController;

    public DiceController(Dice dice,GameController gameController) {
        this.dice = dice;
        this.gameController = gameController;

    }


    /**
     * Rolls the dice and moves the player. If they roll a double, increment the tile.
     * @param player
     * @param board
     * @param bank
     * @throws Board.CellNotFoundException
     * @throws PlayerController.LandedOnJailException
     * @throws PlayerController.CellNotFoundException
     * @throws zytom.proptycoon.model.card.PropertyCard.TooManyHousesException
     * @throws zytom.proptycoon.model.assets.AssetOwner.AssetNotFoundException
     */
    public void roll(Player player, Board board, Bank bank) throws Board.CellNotFoundException, PlayerController.LandedOnJailException, PlayerController.CellNotFoundException, PropertyCard.TooManyHousesException, AssetOwner.AssetNotFoundException {
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
            //gameController.getPlayerController().hasLanded(board.getCell(player.getPosition()),board,dice,player);
        }

    }

}
