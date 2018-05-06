package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.*;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.card.OpportunityKnocksCard;

public class OpportunityKnocksController {
    private final Game game;
    private final LeadController leadController;
    private final Board board ;
    private final Dice dice;
    private final Player currentplayer;
    private final Bank bank;
    private final FreeParking freeParking;

    public OpportunityKnocksController(Game game , LeadController leadController, Board board,Bank bank, Dice dice, Player currentPlayer){
        this.game = game;
        this.freeParking = game.getFreeParking();
        this.bank  = bank;
        this.leadController = leadController;
        this.board = board;
        this.dice = dice;
        this.currentplayer = currentPlayer;
    }

    /**
     * Method Calls the model to pick up the first card, performs the actions on the card , returns the card to the bank
     */
    public OpportunityKnocksCard pickupCard() throws Board.CellNotFoundException, AssetOwner.AssetNotFoundException {
        OpportunityKnocksCard opportunityKnocksCard = bank.getAssetCollection().getOpportunityKnocksCards().get(0);
        bank.getAssetCollection().getOpportunityKnocksCards().remove(0);
        return opportunityKnocksCard;
    }

    /**
     * Call this method to perform the card action .
     * @param opportunityKnocksCard
     * @throws AssetOwner.AssetNotFoundException
     */
    public void performCardAction(OpportunityKnocksCard opportunityKnocksCard) throws AssetOwner.AssetNotFoundException {
        opportunityKnocksCard.getCardAction().performAction(freeParking,bank,currentplayer,game.getPlayers(),opportunityKnocksCard);

    }


}
