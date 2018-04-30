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
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import zytom.proptycoon.model.assets.CardAsset;

/**
 * @author Max Pattman
 */
public class Bank<A extends Asset> implements AssetOwner {

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
        ArrayList<Card> cards = new ArrayList<>();
        cards.addAll(propertyCards);
        cards.addAll(potLuckCards);
        cards.addAll(opportunityKnocksCards);
        return cards;
    }

    /**
     * Copies cards, does not remove.
     * @return All the pot luck cards that this asset owner is in possesion of.
     */
    @Override
    public ArrayList<PotLuckCard> getPotLuckCards() {
        ArrayList<PotLuckCard> cards = new ArrayList<>();
        cards.addAll(this.potLuckCards);
        return cards;
    }
    
    /**
     * Copies cards, does not remove.
     * @return All the pot luck cards that this asset owner is in possesion of.
     */
    @Override
    public ArrayList<OpportunityKnocksCard> getOpportunityKnocksCards() {
        ArrayList<OpportunityKnocksCard> cards = new ArrayList<>();
        cards.addAll(this.opportunityKnocksCards);
        return cards;
    }
    
    /**
     * Copies cards, does not remove.
     * @return All the property cards that this asset owner is in possesion of.
     */
    @Override
    public ArrayList<PropertyCard> getPropertyCards() {
        return new ArrayList<>(this.propertyCards);
    }

    /**
     * Remove the contents of the specified money asset
     * from this asset owner and return them within
     * the asset instance.
     *
     * @param requested The asset to look for in this asset owner.
     * @return An asset instance containing the requested contents.
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     */
    @Override
    public Asset takeAsset(MoneyAsset requested) throws AssetNotFoundException {
        return new MoneyAsset(
                requested.getMoney()
        );
    }
    
    /**
     * Remove the contents of the specified cards asset
     * from this asset owner and return them within
     * the asset instance.
     *
     * @param requested The asset to look for in this asset owner.
     * @return An asset instance containing the requested contents.
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     */
    @Override
    public Asset takeAsset(CardsAsset requested) throws AssetNotFoundException {
        for (CardAsset cardAsset : requested.getCardAssets()) {
            
        }
    }


}
