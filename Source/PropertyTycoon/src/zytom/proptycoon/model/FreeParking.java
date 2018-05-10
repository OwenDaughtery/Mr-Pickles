package zytom.proptycoon.model;

import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.card.Card;

/**
 * Class represents the Free Parking entity of the game
 * @author zenos
 */
public class FreeParking implements AssetOwner {

    public static final int INITIAL_BALANCE = 0;
    AssetCollection assetCollection;

    public FreeParking() {
        assetCollection = new AssetCollection(INITIAL_BALANCE);
    }

    /**
     * @return All the assets that this asset owner is in possesion of.
     */
    @Override
    public AssetCollection getAssetCollection() {
        return this.assetCollection;
    }

    /**
     * Remove the contents of the specified money asset from this asset owner
     * and return them within the asset instance.
     *
     * @param requested The asset collection to look for in this asset owner.
     * @return An asset instance containing the requested contents.
     * @throws AssetNotFoundException If requested asset contents cannot be
     * found in this asset owner.
     */
    @Override
    public AssetCollection takeAssetCollection(AssetCollection requested) throws AssetNotFoundException {
        //Remove requested potluck cards. (Throw exception if not found).
        if (this.assetCollection.getPotLuckCards().containsAll(requested.getPotLuckCards())) {
            this.assetCollection.getPotLuckCards().removeAll(requested.getPotLuckCards());
        } else {
            throw new AssetOwner.AssetNotFoundException(this, requested);
        }

        //Remove requested opportunityknocks cards. (Throw exception if not found).
        if (this.assetCollection.getOpportunityKnocksCards().containsAll(requested.getOpportunityKnocksCards())) {
            this.assetCollection.getOpportunityKnocksCards().removeAll(requested.getOpportunityKnocksCards());
        } else {
            throw new AssetOwner.AssetNotFoundException(this, requested);
        }

        //Remove requested street property cards. (Throw exception if not found).
        if (this.assetCollection.getStreetPropertyCards().containsAll(requested.getStreetPropertyCards())) {
            this.assetCollection.getStreetPropertyCards().removeAll(requested.getStreetPropertyCards());
        } else {
            throw new AssetOwner.AssetNotFoundException(this, requested);
        }

        //Remove requested station property cards. (Throw exception if not found).
        if (this.assetCollection.getStationPropertyCards().containsAll(requested.getStationPropertyCards())) {
            this.assetCollection.getStationPropertyCards().removeAll(requested.getStationPropertyCards());
        } else {
            throw new AssetOwner.AssetNotFoundException(this, requested);
        }

        //Remove requested utility property cards. (Throw exception if not found).
        if (this.assetCollection.getUtilityPropertyCards().containsAll(requested.getUtilityPropertyCards())) {
            this.assetCollection.getUtilityPropertyCards().removeAll(requested.getUtilityPropertyCards());
        } else {
            throw new AssetOwner.AssetNotFoundException(this, requested);
        }

        //Remove requested money. (Throw exception if not found).
        if (this.assetCollection.getMoney() >= requested.getMoney()) {
            this.assetCollection.setMoney(
                    this.assetCollection.getMoney() - requested.getMoney()
            );
        } else {
            throw new AssetOwner.AssetNotFoundException(this, requested);
        }

        //Return the requested AssetCollection.
        return requested;
    }

    /**
     * Append the contents of the specified asset collection to the asset
     * owner's asset collection.
     *
     * @param giving
     */
    @Override
    public void giveAssetCollection(AssetCollection giving)
            throws AssetOwner.CannotAcceptAssetException {
        if (giving.getPotLuckCards().size() > 0)
            throw new CannotAcceptAssetException(this, giving);
        if (giving.getOpportunityKnocksCards().size() > 0)
            throw new CannotAcceptAssetException(this, giving);
        if (giving.getStreetPropertyCards().size() > 0)
            throw new CannotAcceptAssetException(this, giving);
        if (giving.getStationPropertyCards().size() > 0)
            throw new CannotAcceptAssetException(this, giving);
        if (giving.getUtilityPropertyCards().size() > 0)
            throw new CannotAcceptAssetException(this, giving);
        this.assetCollection.setMoney(
                this.assetCollection.getMoney() + giving.getMoney()
        );
    }

    /**
     * 
     * @param card The card being checked for
     * @return Will always return false because Free Parking should never own any cards
     */
    @Override
    public boolean checkHasAsset(Card card) {
        return false;
    }

    /**
     * 
     * @param money The amount of money
     * @return True if Free Parking has enough money, false otherwise. 
     */
    @Override
    public boolean checkHasAsset(int money) {
        return this.assetCollection.getMoney() >= money;
    }
}
