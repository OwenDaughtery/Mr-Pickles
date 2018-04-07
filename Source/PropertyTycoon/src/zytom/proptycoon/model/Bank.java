package zytom.proptycoon.model;

import zytom.proptycoon.model.assets.Asset;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.card.Card;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.PropertyCard;

import java.util.ArrayList;

/**
 * @author Max Pattman
 */
public class Bank implements AssetOwner {

    public Bank(){

    }

    /**
     * @return The amount of money this asset owner is in possesion of.
     */
    @Override
    public int getBalance() {
        return 0;
    }

    /**
     * Copies cards, does not remove.
     *
     * @return All the cards that this asset owner is in possesion of.
     */
    @Override
    public ArrayList<Card> getCards() {
        return null;
    }

    /**
     * Copies cards, does not remove.
     *
     * @return All the pot luck cards that this asset owner is in possesion of.
     */
    @Override
    public ArrayList<PotLuckCard> getPotLuckCards() {
        return null;
    }

    /**
     * Copies cards, does not remove.
     *
     * @return All the property cards that this asset owner is in possesion of.
     */
    @Override
    public ArrayList<PropertyCard> getProperties() {
        return null;
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
        return null;
    }
}
