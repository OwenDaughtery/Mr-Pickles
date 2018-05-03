package zytom.proptycoon.model;

import java.util.ArrayList;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.card.*;

/**
 * @author Max Pattman
 */
public class Bank implements AssetOwner {

    public static final int INITIAL_BALANCE = 50000;
    private final AssetCollection assetCollection;

    /**
     * @author Zenos Pavlakou
     * @param potLuckCards
     * @param opportunityKnocksCards
     * @param streetPropertyCards
     * @param stationPropertyCards
     * @param utilityPropertyCards
     * 
     */
    public Bank (
            ArrayList<PotLuckCard> potLuckCards,
            ArrayList<OpportunityKnocksCard> opportunityKnocksCards,
            ArrayList<StreetPropertyCard> streetPropertyCards,
            ArrayList<StationPropertyCard> stationPropertyCards,
            ArrayList<UtilityPropertyCard> utilityPropertyCards
        ) {
        this.assetCollection = new AssetCollection(
                potLuckCards,
                opportunityKnocksCards,
                streetPropertyCards,
                stationPropertyCards,
                utilityPropertyCards
        );
        this.assetCollection.setMoney(INITIAL_BALANCE);
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

        //Bank never gains or loses money.
        /*
        //Remove requested money. (Throw exception if not found).
        if (this.assetCollection.getMoney() >= requested.getMoney()) {
            this.assetCollection.setMoney(
                    this.assetCollection.getMoney() - requested.getMoney()
            );
        } else {
            throw new AssetOwner.AssetNotFoundException(this, requested);
        }
        */

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
    public void giveAssetCollection(AssetCollection giving) {
        this.assetCollection.getPotLuckCards().addAll(
                giving.getPotLuckCards()
        );
        this.assetCollection.getOpportunityKnocksCards().addAll(
                giving.getOpportunityKnocksCards()
        );
        this.assetCollection.getStreetPropertyCards().addAll(
                giving.getStreetPropertyCards()
        );
        this.assetCollection.getStationPropertyCards().addAll(
                giving.getStationPropertyCards()
        );
        this.assetCollection.getUtilityPropertyCards().addAll(
                giving.getUtilityPropertyCards()
        );
        //Bank never gains or loses money.
        /*this.assetCollection.setMoney(
                this.assetCollection.getMoney() + giving.getMoney()
        );*/
    }

    @Override
    public boolean checkHasAsset(Card asset) {
        if(this.getAssetCollection().getStreetPropertyCards().contains(asset)){

        }else if (this.getAssetCollection().getUtilityPropertyCards().contains(asset)){
            return true;
        }else if (this.getAssetCollection().getStationPropertyCards().contains(asset)){
            return true;
        }else if (this.getAssetCollection().getOpportunityKnocksCards().contains(asset)){
            return true;
        }else if (this.getAssetCollection().getPotLuckCards().contains(asset)){
            return true;
        }
        return false;
    }
    @Override
    public boolean checkHasAsset(int money){
        if(this.getAssetCollection().getMoney() > money){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString(){
        String info = "Bank Information : \n "
                + this.getAssetCollection().toString();
        return info;
    }
}
