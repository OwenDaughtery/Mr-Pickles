package zytom.proptycoon.controller.game;

import java.util.ArrayList;
import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.FreeParking;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.card.PropertyCard;
import zytom.proptycoon.model.cell.Cell;

public class DiceController {

    private final Dice dice;
    private final GameController gameController;

    public DiceController(
            Dice dice,
            GameController gameController) {
        this.dice = dice;
        this.gameController = gameController;

    }

    /**
     * Rolls the dice and moves the player. If they roll a double, increment the
     * tile.
     *
     * @param playerController
     * @param otherPlayers
     * @param board
     * @param bank
     * @param freeParking
     * @throws Board.CellNotFoundException
     * @throws PlayerController.CellNotFoundException
     * @throws zytom.proptycoon.model.card.PropertyCard.TooManyHousesException
     * @throws zytom.proptycoon.model.assets.AssetOwner.AssetNotFoundException
     */
    public void roll(
            PlayerController playerController,
            ArrayList<Player> otherPlayers,
            Board board,
            Bank bank,
            FreeParking freeParking
    ) throws
            Board.CellNotFoundException,
            PlayerController.CellNotFoundException,
            PropertyCard.TooManyHousesException,
            AssetOwner.AssetNotFoundException {
        Player player = playerController.getPlayer();
        dice.roll();
        int dice1 = dice.getFirstValue();
        int dice2 = dice.getSecondValue();
        if (dice1 == dice2) {
            player.incrementDoublesRolled();
        }
    }

}
