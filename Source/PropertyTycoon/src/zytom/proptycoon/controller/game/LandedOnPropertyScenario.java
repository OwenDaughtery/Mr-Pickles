package zytom.proptycoon.controller.game;

import java.util.ArrayList;
import zytom.proptycoon.model.Bank;
import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.Card;
import zytom.proptycoon.model.card.StationPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;
import zytom.proptycoon.model.cell.StationPropertyCell;
import zytom.proptycoon.model.cell.StreetPropertyCell;
import zytom.proptycoon.model.cell.UtilityPropertyCell;

public class LandedOnPropertyScenario {
    private final PlayerController currentPlayerController;
    private final Player currentPlayer;
    private final ArrayList<Player> otherPlayers;
    private final Bank bank;
    private final Dice dice;

    public LandedOnPropertyScenario (
            PlayerController currentPlayerController,
            ArrayList<Player> otherPlayers,
            Bank bank,
            Dice dice
    ) {
        this.currentPlayerController = currentPlayerController;
        this.currentPlayer = currentPlayerController.getPlayer();
        this.otherPlayers = otherPlayers;
        this.bank = bank;
        this.dice = dice;
    }


    public void landedOnProperty(StreetPropertyCell cell) {
        StreetPropertyCard card = (StreetPropertyCard) cell.getAssociatedCard();
        if (currentPlayer.getAssetCollection().checkHasAsset(card)) {
            //Do nothing.
            //Current player owns this property.
        } else if (bank.getAssetCollection().checkHasAsset(card)) {
            //Commence buying scenario.
            //TODO
        } else {
            Player propertyOwner = findPropertyOwner(card);
            //Calculate rent.
            int rent = card.getRent(
                    this.dice,
                    propertyOwner,
                    this.bank
            );
            tryToPayRent(propertyOwner, rent);
        }

    }
    
    public void landedOnProperty(StationPropertyCell cell) {
        StationPropertyCard card = (StationPropertyCard) cell.getAssociatedCard();
        if (currentPlayer.getAssetCollection().checkHasAsset(card)) {
            //Do nothing.
            //Current player owns this property.
        } else if (bank.getAssetCollection().checkHasAsset(card)) {
            //Commence buying scenario.
            //TODO
        } else {
            Player propertyOwner = findPropertyOwner(card);
            //Calculate rent.
            int rent = card.getRent(
                    this.dice,
                    propertyOwner,
                    this.bank
            );
            tryToPayRent(propertyOwner, rent);
        }
    }
    
    public void landedOnProperty(UtilityPropertyCell cell) {
        UtilityPropertyCard card = (UtilityPropertyCard) cell.getAssociatedCard();
        if (currentPlayer.getAssetCollection().checkHasAsset(card)) {
            //Do nothing.
            //Current player owns this property.
        } else if (bank.getAssetCollection().checkHasAsset(card)) {
            //Commence buying scenario.
            //TODO
        } else {
            Player propertyOwner = findPropertyOwner(card);
            //Calculate rent.
            int rent = card.getRent(
                    this.dice,
                    propertyOwner,
                    this.bank
            );
            tryToPayRent(propertyOwner, rent);
        }
    }

    private void tryToPayRent(Player propertyOwner, int rent) {
        //Attempt to pay rent.
        try {
            //Generate transaction.
            Transaction transaction = new Transaction(
                    this.currentPlayer,
                    propertyOwner,
                    //Must pass dice due to utility rent calculation.
                    new AssetCollection(rent),
                    new AssetCollection(0)
            );
            //Attempt to settle it.
            transaction.settleTransaction();
        } catch (AssetOwner.AssetNotFoundException ex) {
            //Can't pay rent.
            //Record amount of debt in player controller.
            this.currentPlayerController.setDebt(
                    this.currentPlayer.getAssetCollection().getMoney()
                    - rent
            );
        }
    }

    private Player findPropertyOwner(StreetPropertyCard card) {
        //Find who owns the card for this property.
        Player propertyOwner = null;
        for (Player p : otherPlayers) {
            if (p.getAssetCollection().checkHasAsset(card)) {
                propertyOwner = p;
                break;
            }
        }
        return propertyOwner;
    }
    private Player findPropertyOwner(StationPropertyCard card) {
        //Find who owns the card for this property.
        Player propertyOwner = null;
        for (Player p : otherPlayers) {
            if (p.getAssetCollection().checkHasAsset(card)) {
                propertyOwner = p;
                break;
            }
        }
        return propertyOwner;
    }
    
    private Player findPropertyOwner(UtilityPropertyCard card) {
        //Find who owns the card for this property.
        Player propertyOwner = null;
        for (Player p : otherPlayers) {
            if (p.getAssetCollection().checkHasAsset(card)) {
                propertyOwner = p;
                break;
            }
        }
        return propertyOwner;
    }

    public static class CardNotFoundException extends Exception {

        public CardNotFoundException(Card card) {
            super(
                    card.toString() + " not found."
            );
        }

        /**
         * Gets the message
         *
         * @return The exception message.
         */
        @Override
        public String getMessage() {
            return super.getMessage();
        }
    }
}
