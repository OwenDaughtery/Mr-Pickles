package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.*;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.card.PotLuckCard;

public class PotLuckController {
    private final Game game;
    private final GameController gameController;
    private final Board board ;
    private final Dice dice;
    private final Player currentplayer;
    private final Bank bank;
    private final FreeParking freeParking;

    /**
     * 
     * @param game
     * @param gameController
     * @param board
     * @param bank
     * @param dice
     * @param currentPlayer 
     */
    public PotLuckController(Game game , GameController gameController, Board board, Bank bank, Dice dice, Player currentPlayer){
        this.game = game;
        this.freeParking = game.getFreeParking();
        this.bank  = bank;
        this.gameController = gameController;
        this.board = board;
        this.dice = dice;
        this.currentplayer = currentPlayer;
    }

    /**
     * Method Calls the model to pick up the first card, performs the actions on the card , returns the card to the bank
     */
    public PotLuckCard pickupCard() throws Board.CellNotFoundException, AssetOwner.AssetNotFoundException {
        PotLuckCard potLuckCard = bank.getAssetCollection().getPotLuckCards().get(0);
        bank.getAssetCollection().getPotLuckCards().remove(0);
        return potLuckCard;
    }

    /**
     * Call this method to perform the card action .
     * @param potLuckCard
     * @throws AssetOwner.AssetNotFoundException
     */
    public void performCardAction(PotLuckCard potLuckCard) throws AssetOwner.AssetNotFoundException {
        potLuckCard.getCardAction().performAction(freeParking,bank,currentplayer,game.getPlayers(),potLuckCard);

    }
}