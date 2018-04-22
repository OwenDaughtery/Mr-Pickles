/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model;

import zytom.proptycoon.model.assets.Asset;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.card.Card;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.PropertyCard;

import java.util.ArrayList;

/**
 *
 * @author Tom Chesters
 */
public class Player implements AssetOwner {

    String name ;
    int position;
    int balance ;
    ArrayList<Card> cards = new ArrayList<>();
    ArrayList<PropertyCard> propertyCards = new ArrayList<>();
    ArrayList<PotLuckCard> potLuckCards = new ArrayList<>();


    public Player(String name , int position , int balance){
        this.name = name;
        this.position = position;
        this.balance = balance;
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
     * @author Zenos
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
    public ArrayList<PropertyCard> getProperties() {
        return this.propertyCards;
    }
    
    /**
     * @author Zenos
     * 
     * @param requested 
     * @return A PropertyCard instance containing the requested card.
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     */
    @Override
    public Asset takeAsset(PropertyCard requested) throws AssetNotFoundException {
        if(!cards.contains(requested)) {
            throw AssetNotFoundException;
        } 
        propertyCards.remove(requested);
        cards.remove(requested);
        return requested;
    }    
    
    /**
     * @author Zenos
     * 
     * @param requested 
     * @return A PotLuckCard instance containing the requested card.
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     */
    @Override
    public Asset takeAsset(PotLuckCard requested) throws AssetNotFoundException {
        if(!cards.contains(requested)) {
            throw AssetNotFoundException;
        } 
        potLuckCards.remove(requested);
        cards.remove(requested);
        return requested;
    }
    
    /**
     * @author Zenos
     * 
     * @param money The amount of money that will be taken from the player 
     * @return An instance of a MoneyAsset.
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     * 
     * Parameter has been changed here as I could not see any other way of creating a MoneyAsset instance
     * because the MoneyAssset constructor takes an integer as a parameter
     */
    @Override
    public Asset takeAsset(int money) throws AssetNotFoundException {
        MoneyAsset moneyAsset;
        if(this.balance >= money && this.balance - money < this.balance) {
            moneyAsset = new MoneyAsset(money);
            this.balance -= money;
        } else {
            throw AssetNotFoundException;
        }
        return moneyAsset;
    }  
  
    /**
     * @author Zenos
     * 
     * @param giving The property card the player will receive
     */
    public void giveAsset(PropertyCard giving) throws AssetNotFoundException {
        propertyCards.add(giving);
        cards.add(giving);
    }
    
    /**
     * @author Zenos
     * 
     * @param giving The potluck card the player will receive
     */
    public void giveAsset(PotLuckCard giving) throws AssetNotFoundException {
        potLuckCards.add(giving);
        cards.add(giving);
    }
    
    /**
     * @author Zenos
     * 
     * @param giving The money which the player will receive 
     */
    public void giveAsset(MoneyAsset giving) throws AssetNotFoundException {
        this.balance += giving.getMoney();
    }
}
