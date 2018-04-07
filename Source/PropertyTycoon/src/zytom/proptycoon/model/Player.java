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
     * @return The amount of money this asset owner is in possesion of.
     */
    @Override
    public int getBalance() {
        return this.balance;
    }

    /**
     *
     * @return
     */
    public int getPosition(){
        return this.position;
    }

    /**
     *
     * @param numberOfSpaces
     */
    public void move(int numberOfSpaces){

    }


    /**
     *
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
     * Remove the contents of the specified asset
     * from this asset owner and return them within
     * the asset instance.
     *
     * @param requested The asset to look for in this asset owner.
     * @return An asset instance containing the requested contents.
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     * //TODO
     */
    @Override
    public Asset takeAsset(Asset requested) throws AssetNotFoundException {
        return null;
    }

    /**
     *
     * @param giving
     * @return
     * @throws AssetNotFoundException
     */
    public Asset giveAsset(Asset giving) throws AssetNotFoundException {

    }
}
