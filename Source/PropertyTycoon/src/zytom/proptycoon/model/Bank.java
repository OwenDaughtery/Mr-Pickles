package zytom.proptycoon.model;

import java.util.ArrayList;
import java.util.HashMap;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.card.*;

/**
 * @author Max Pattman
 */
public final class Bank implements AssetOwner {

    public static final int INITIAL_BALANCE = 50000;
    private final AssetCollection assetCollection;
    
    private HashMap<StreetPropertyCard.Colour, ArrayList<StreetPropertyCard>> streetPropertyByColourGroup;
    
    private ArrayList<StreetPropertyCard> brownGroup;
    private ArrayList<StreetPropertyCard> blueGroup;
    private ArrayList<StreetPropertyCard> purpleGroup;
    private ArrayList<StreetPropertyCard> orangeGroup;
    private ArrayList<StreetPropertyCard> redGroup;
    private ArrayList<StreetPropertyCard> yellowGroup;
    private ArrayList<StreetPropertyCard> greenGroup;
    private ArrayList<StreetPropertyCard> deepBlueGroup;

    /**
     * @author Zenos Pavlakou
     * 
     * The contstructor assigns all Card objects to the bank. 
     * 
     * @param potLuckCards The deck of pot luck cards
     * @param opportunityKnocksCards The deck of opportunity knocks cards
     * @param streetPropertyCards The deck of street property cards
     * @param stationPropertyCards The deck of station property cards
     * @param utilityPropertyCards The deck of utility property cards
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
                utilityPropertyCards,
                INITIAL_BALANCE
        );
        
        
        this.brownGroup = new ArrayList<>();
        this.blueGroup = new ArrayList<>();
        this.purpleGroup = new ArrayList<>();
        this.orangeGroup = new ArrayList<>();
        this.redGroup = new ArrayList<>();
        this.yellowGroup = new ArrayList<>();
        this.greenGroup = new ArrayList<>();
        this.deepBlueGroup = new ArrayList<>();
        
        this.streetPropertyByColourGroup = new HashMap<>();
        
        for(StreetPropertyCard card : streetPropertyCards) {
            switch(card.getColour()) {
                case BROWN:
                    brownGroup.add(card);
                    break;
                case BLUE:
                    blueGroup.add(card);
                    break;
                case PURPLE:
                    purpleGroup.add(card);
                    break;
                case ORANGE:
                    orangeGroup.add(card);
                    break;
                case RED:
                    redGroup.add(card);
                    break;
                case YELLOW:
                    yellowGroup.add(card);
                    break;
                case GREEN:
                    greenGroup.add(card);
                    break;
                case DEEPBLUE:
                    deepBlueGroup.add(card);
                    break;
            }
        }
        
        this.streetPropertyByColourGroup.put(StreetPropertyCard.Colour.BROWN, brownGroup);
        this.streetPropertyByColourGroup.put(StreetPropertyCard.Colour.BLUE, blueGroup);
        this.streetPropertyByColourGroup.put(StreetPropertyCard.Colour.PURPLE, purpleGroup);
        this.streetPropertyByColourGroup.put(StreetPropertyCard.Colour.ORANGE, orangeGroup);
        this.streetPropertyByColourGroup.put(StreetPropertyCard.Colour.RED, redGroup);
        this.streetPropertyByColourGroup.put(StreetPropertyCard.Colour.YELLOW, yellowGroup);
        this.streetPropertyByColourGroup.put(StreetPropertyCard.Colour.GREEN, greenGroup);
        this.streetPropertyByColourGroup.put(StreetPropertyCard.Colour.DEEPBLUE, deepBlueGroup);
    }

    /**
     * 
     * @param groupColour
     * @return 
     */
    public ArrayList<StreetPropertyCard> getGroupOfStreetProperties(StreetPropertyCard.Colour groupColour) {
        return this.streetPropertyByColourGroup.get(groupColour);
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

        return requested;
    }

    /**
     * Append the contents of the specified asset collection to the asset
     * bank's asset collection.
     *
     * @param giving The asset which is being given to the bank
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

    /**
     * Method checks if the bank has a certain asset
     * @param asset The asset being queried 
     * @return True if bank has asset, false otherwise
     */
    @Override
    public boolean checkHasAsset(Card asset) {
        if(this.getAssetCollection().getStreetPropertyCards().contains((StreetPropertyCard)asset)){
        }else if (this.getAssetCollection().getUtilityPropertyCards().contains((UtilityPropertyCard)asset)){
            return true;
        }else if (this.getAssetCollection().getStationPropertyCards().contains((StationPropertyCard)asset)){
            return true;
        }else if (this.getAssetCollection().getOpportunityKnocksCards().contains((OpportunityKnocksCard)asset)){
            return true;
        }else if (this.getAssetCollection().getPotLuckCards().contains((PotLuckCard)asset)){
            return true;
        }
        return false;
    }
    @Override
    public boolean checkHasAsset(int money){
        return this.getAssetCollection().getMoney() > money;
    }

    @Override
    public String toString(){
        String info = "Bank Information : \n "
                + this.getAssetCollection().toString();
        return info;
    }
}
