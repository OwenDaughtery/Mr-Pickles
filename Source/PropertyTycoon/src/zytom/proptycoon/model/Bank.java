package zytom.proptycoon.model;

import java.util.ArrayList;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.OpportunityKnocksCard;
import zytom.proptycoon.model.card.StationPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;

/**
 * @author Max Pattman
 */
public class Bank implements AssetOwner {
    public static final int INITIAL_BALANCE = 50000;
    
    AssetCollection assetCollection;
    
    /**
     * @author Zenos Pavlakou
     * @param potLuckCards
     * @param opportunityKnocksCards
     * @param streetPropertyCards
     * @param stationPropertyCards
     * @param utilityPropertyCards
     */
    public Bank(
            ArrayList<PotLuckCard> potLuckCards,
            ArrayList<OpportunityKnocksCard> opportunityKnocksCards,
            ArrayList<StreetPropertyCard> streetPropertyCards,
            ArrayList<StationPropertyCard> stationPropertyCards,
            ArrayList<UtilityPropertyCard> utilityPropertyCards
    ){
        this.assetCollection = new AssetCollection (
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
     * Remove the contents of the specified money asset
     * from this asset owner and return them within
     * the asset instance.
     *
     * @param requested The asset collection to look for in this asset owner.
     * @return An asset instance containing the requested contents.
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     */
    @Override
    public AssetCollection takeAssetCollection(AssetCollection requested) throws AssetNotFoundException {
        //Remove requested potluck cards. (Throw exception if not found).
        if (this.assetCollection.getPotLuckCards().containsAll(requested.getPotLuckCards()))
            this.assetCollection.getPotLuckCards().removeAll(requested.getPotLuckCards());
        else
            throw new AssetOwner.AssetNotFoundException(this, requested);
        
        //Remove requested opportunityknocks cards. (Throw exception if not found).
        if (this.assetCollection.getOpportunityKnocksCards().containsAll(requested.getOpportunityKnocksCards()))
            this.assetCollection.getOpportunityKnocksCards().removeAll(requested.getOpportunityKnocksCards());
        else
            throw new AssetOwner.AssetNotFoundException(this, requested);
       
        //Remove requested street property cards. (Throw exception if not found).
        if (this.assetCollection.getStreetPropertyCards().containsAll(requested.getStreetPropertyCards()))
            this.assetCollection.getStreetPropertyCards().removeAll(requested.getStreetPropertyCards());
        else
            throw new AssetOwner.AssetNotFoundException(this, requested);
        
        //Remove requested station property cards. (Throw exception if not found).
        if (this.assetCollection.getStationPropertyCards().containsAll(requested.getStationPropertyCards()))
            this.assetCollection.getStationPropertyCards().removeAll(requested.getStationPropertyCards());
        else
            throw new AssetOwner.AssetNotFoundException(this, requested);
        
        //Remove requested utility property cards. (Throw exception if not found).
        if (this.assetCollection.getUtilityPropertyCards().containsAll(requested.getUtilityPropertyCards()))
            this.assetCollection.getUtilityPropertyCards().removeAll(requested.getUtilityPropertyCards());
        else
            throw new AssetOwner.AssetNotFoundException(this, requested);
        
        //Return the requested AssetCollection.
        return requested;
    }
    
    /**
     * Append the contents of the specified asset collection
     * to the asset owner's asset collection.
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
    }
}
