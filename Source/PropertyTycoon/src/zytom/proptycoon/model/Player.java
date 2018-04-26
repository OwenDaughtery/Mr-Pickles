/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model;

import zytom.proptycoon.model.assets.Asset;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.CardsAsset;
import zytom.proptycoon.model.assets.MoneyAsset;
import zytom.proptycoon.model.card.Card;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.PropertyCard;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Tom Chesters
 */
public class Player implements AssetOwner {

    String name ;
    int position;
    int balance ;
    ArrayList<Card> cards;
    ArrayList<PropertyCard> propertyCards;
    ArrayList<PotLuckCard> potLuckCards;


    public Player(String name , int position , int balance){
        this.name = name;
        this.position = position;
        this.balance = balance;
        this.cards = new ArrayList<>();
        this.propertyCards = new ArrayList<>();
        this.potLuckCards = new ArrayList<>();
    }
    
    /**
     * @author Zenos
     * 
     * @return The name of the player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @return The amount of money this asset owner is in possesion of.
     */
    @Override
    public int getBalance() {
        return this.balance;
    }

    /**
     * @author Zenos
     * 
     * @return the position of the player
     */
    public int getPosition(){
        return this.position;
    }

    /**
     * @author Zenos
     * 
     * @param numberOfSpaces
     */
    public void move(int numberOfSpaces){
        this.position = (this.position + numberOfSpaces) % 40;
    }


    /**
     * Not sure why the movingForwards boolean is needed here. 
     */
    public void moveTo(int position,boolean movingForewards){

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

    /**
     * Copies cards, does not remove.
     *
     * @return All the pot luck cards that this asset owner is in possesion of.
     */
    @Override
    public ArrayList<PotLuckCard> getPotLuckCards() {
        return this.potLuckCards;
    }


    /**
     * Copies cards, does not remove.
     *
     * @return All the property cards that this asset owner is in possesion of.
     */
    @Override
    public ArrayList<PropertyCard> getPropertyCards() {
        return this.propertyCards;
    }




    /**
     * @author Zenos
     * @author Tom
     * 
     * @param requested A CardAsset describing the Card requested from th eplayer.
     * @return The requested Card
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     */

    @Override
    public Asset takeAsset(CardsAsset requested) throws AssetOwner.AssetNotFoundException {
        if(!this.cards.containsAll(requested.getCards())) {
            throw new AssetNotFoundException(this,requested);
        }
        this.cards.removeAll(requested.getCards());
        return requested;
    }
    
    /**
     * @author Tom
     * @author Zenos
     * 
     * @param requested MoneyAsset describing the requested amount of money from the player.
     * @return An instance of a MoneyAsset.
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     */

    @Override
    public MoneyAsset takeAsset(MoneyAsset requested) throws AssetOwner.AssetNotFoundException {
        if(this.balance >= requested.getMoney() && requested.getMoney() > 0) 
            this.balance -= requested.getMoney();
        else 
            throw new AssetNotFoundException(this, requested);
        return requested;
    }




    /**
     * @author Tom
     * @author Zenos
     * 
     * @param giving The card that the player will receive.
     */
    @Override
    public void giveAsset(CardsAsset giving){
        cards.addAll(giving.getCards());
    }
    
    /**
     * @author Tom
     * @author Zenos
     * 
     * @param giving A money asset describing the money that the player will receive 
     */
    @Override
    public void giveAsset(MoneyAsset giving) {
        this.balance += giving.getMoney();
    }
}
