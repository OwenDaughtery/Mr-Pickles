package zytom.proptycoon.model;

import zytom.proptycoon.model.assets.Asset;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.MoneyAsset;
import zytom.proptycoon.model.card.Card;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.PropertyCard;

import java.util.ArrayList;

/**
 * @author Max Pattman
 */
public class Bank implements AssetOwner {
    
    ArrayList<Card> cards;
    ArrayList<PropertyCard> propertyCards;
    ArrayList<PotLuckCard> potLuckCards;
    
    /**
     * @author Zenos Pavlakou
     */
    public Bank(){
        this.cards = new ArrayList<>();
        this.propertyCards = new ArrayList<>();
        this.potLuckCards = new ArrayList<>();
    }

    /**
     * @return The amount of money this asset owner is in possesion of.
     */
    @Override
    public int getBalance() {
        return Integer.MAX_VALUE; //because the bank has unlimited money
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
     * @author Zenos Pavlakou
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
     * @author Zenos Pavlakou
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
     * @author Zenos Pavlakou
     * 
     * @param money The amount of money that will be taken from the player 
     * @return An instance of a MoneyAsset.
     * 
     * Parameter has been changed here as I could not see any other way of creating a MoneyAsset instance
     * because the MoneyAssset constructor takes an integer as a parameter
     * 
     * No need for the method to throw the AssetNotFoundException as the bank has unlimited money
     */
    @Override
    public Asset takeAsset(int money) {
        return new MoneyAsset(money);
    }
}
