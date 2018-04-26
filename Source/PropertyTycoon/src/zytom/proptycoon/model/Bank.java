package zytom.proptycoon.model;

import zytom.proptycoon.model.assets.Asset;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.CardsAsset;
import zytom.proptycoon.model.assets.MoneyAsset;
import zytom.proptycoon.model.card.Card;
import zytom.proptycoon.model.card.OpportunityKnocksCard;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.PropertyCard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Max Pattman
 */
public class Bank implements AssetOwner {

    ArrayList<PropertyCard> propertyCards;
    Queue<PotLuckCard> potLuckCards;
    Queue<OpportunityKnocksCard> opportunityKnocksCards;
    
    /**
     * @author Zenos Pavlakou
     */
    public Bank(){
        this.propertyCards = new ArrayList<>();
        this.potLuckCards = new LinkedList<>();
        this.opportunityKnocksCards = new LinkedList<>();
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
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.addAll(propertyCards);
        cards.addAll(potLuckCards);
        cards.addAll(opportunityKnocksCards);
        return cards;
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
     */
    @Override
    public Asset takeAsset(Asset requested) throws AssetNotFoundException {
        if(!cards.contains(requested)){
            throw new AssetNotFoundException(this,requested);
        }
        propertyCards.remove(requested);
        cards.remove(requested);
        return requested;
    }

    @Override
    public void giveAsset() {

    }

    /**
     * @author Zenos Pavlakou
     * 
     * @param requested 
     * @return A PropertyCard instance containing the requested card.
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     */
    @Override
    public Asset takeAsset(PropertyCard requested) throws AssetOwner.AssetNotFoundException {
        if(!cards.containsAll(requested)) {
            throw new AssetNotFoundException(this ,requested);
        } 
//        propertyCards.removeAll(requested.getCards());
//        cards.remove(requested.getCards());
        //removeCards(requested.getCards());

        for(Card card : requested.getCards()) {
            removeCard(card);
        }
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
    public Asset takeAsset(CardsAsset requested) throws AssetOwner.AssetNotFoundException {
        if(!cards.contains(requested)) {
            throw new AssetNotFoundException(this,requested);
        } 
        potLuckCards.remove(requested);
        cards.remove(requested);
        return requested;
    }

    private void removeCard(Card card) {

        this.propertyCards.remove(card);
    }

//    private void removeCards(ArrayList<PropertyCard> cards) {
//        this.propertyCards.removeAll(cards);
//    }

//    private void removeCards(ArrayList<PropertyCard> cards) {
//        propertyCards.removeAll(cards);
//    }



    
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
