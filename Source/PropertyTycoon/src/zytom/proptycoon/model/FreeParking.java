package zytom.proptycoon.model;


import zytom.proptycoon.model.assets.Asset;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.CardsAsset;
import zytom.proptycoon.model.assets.MoneyAsset;
import zytom.proptycoon.model.card.Card;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.PropertyCard;

import java.util.ArrayList;

public class FreeParking implements AssetOwner {
    int balance;

    public FreeParking(){

    }

    /**
     * @return The amount of money this asset owner is in possesion of.
     */
    @Override
    public int getBalance() {
        return this.balance;
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
    public ArrayList<PropertyCard> getPropertyCards() {
        return null;
    }

    /**
     * Copies cards, does not remove.
     *
     * @return All the property cards that this asset owner is in possesion of.
     */

    @Override
    public void giveAsset(CardsAsset giving) {
        return;
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
    public MoneyAsset takeAsset(MoneyAsset requested) throws AssetOwner.AssetNotFoundException {
        if(this.balance >= requested.getMoney() && requested.getMoney() > 0)
            this.balance -= requested.getMoney();
        else
            throw new AssetNotFoundException(this, requested);
        return requested;
    }
    
    @Override
    public void giveAsset(MoneyAsset giving) {this.balance +=giving.getMoney();}

    @Override
    public Asset takeAsset(CardsAsset requested) throws AssetNotFoundException {
        return null;
    }


}



