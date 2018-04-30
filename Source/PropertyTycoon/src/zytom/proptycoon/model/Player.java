/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model;

import zytom.proptycoon.model.assets.*;
import zytom.proptycoon.model.card.Card;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.PropertyCard;

import java.util.ArrayList;

/**
 * @author Tom Chesters
 */
public class Player implements AssetOwner {

    String name;
    int position;
    int balance;
    ArrayList<Card> cards;


    /**
     *
     */
    public Player(String name, int position, int balance) {
        this.name = name;
        this.position = position;
        this.balance = balance;
        this.cards = new ArrayList<>();
    }

    /**
     * @return The name of the player.
     * @author Zenos
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return The amount of money this asset owner is in possesion of.
     */
    @Override
    public int getBalance() {
        return this.balance;
    }

    /**
     * @return the position of the player
     * @author Zenos
     */
    public int getPosition() {
        return this.position;
    }

    /**
     *
     * @author Zenos + Ayman
     * @param numberOfSpaces
     */
    public void move(int numberOfSpaces) {
        int currentPosition = this.position;
        this.position = (this.position + numberOfSpaces) % 40;
        if (numberOfSpaces > 0 && position < currentPosition) {
            try {
                Bank bank = Game.getBank();
                (new Transaction(bank, this, new MoneyAsset(200),
                        new MoneyAsset(0))).settleTransaction();
            } catch (AssetNotFoundException ex) {

            }

        }
    }
    
    /**
     *
     * @author Ayman
     * @param position
     * @param movingForewards
     */
    public void moveTo(int position, boolean movingForewards) throws AssetNotFoundException {
        int currentPosition = this.position;
        this.position = position;

        if (movingForewards == true && position < currentPosition) {
            try {
                Bank bank = Game.getBank();
                (new Transaction(bank, this, new MoneyAsset(200),
                        new MoneyAsset(0))).settleTransaction();
            } catch (AssetNotFoundException ex) {


            }
        }
    }

    /**
     * Copies cards, does not remove.
     *
     * @return All the cards that this asset owner is in possesion of.
     */
    @Override
    public ArrayList<Card> getCards() {
        return this.cards;
    }

    @Override
    public ArrayList<PotLuckCard> getPotLuckCards() {
        return null;
    }

    /**
     * @author Ayman
     * Copies cards, does not remove.
     *
     * @return All the opportunity Knocks cards that this asset owner is in possesion of.
     */
    @Override
    public ArrayList<PotLuckCard> getOpportunityKnocksCards() {
        return null;
    }

    /**
     * Copies cards, does not remove.
     *
     * @return All the property cards that this asset owner is in possesion of.
     */
    @Override
    public ArrayList<PropertyCard> getPropertyCards() {
        return null;
    }


    /**
     * @param requested A CardAsset describing the Card requested from th eplayer.
     * @return The requested Card
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     * @author Zenos
     * @author Tom
     */
    @Override
    public Asset takeAsset(CardsAsset requested) throws AssetOwner.AssetNotFoundException {
        if (!this.cards.containsAll(requested.getCards())) {
            throw new AssetNotFoundException(this, requested);
        }
        this.cards.removeAll(requested.getCards());
        return requested;
    }

    /**
     * @param requested MoneyAsset describing the requested amount of money from the player.
     * @return An instance of a MoneyAsset.
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     * @author Tom
     * @author Zenos
     */
    @Override
    public MoneyAsset takeAsset(MoneyAsset requested) throws AssetOwner.AssetNotFoundException {
        if (this.balance >= requested.getMoney() && requested.getMoney() > 0)
            this.balance -= requested.getMoney();
        else
            throw new AssetNotFoundException(this, requested);
        return requested;
    }


    /**
     * @param giving The card that the player will receive.
     * @author Tom
     * @author Zenos
     */
    @Override
    public void giveAsset(CardsAsset giving) {
        cards.addAll(giving.getCards());
    }

    /**
     * @param giving A money asset describing the money that the player will receive
     * @author Tom
     * @author Zenos
     */
    public void giveAsset(MoneyAsset giving) {
        this.balance += giving.getMoney();
    }

}