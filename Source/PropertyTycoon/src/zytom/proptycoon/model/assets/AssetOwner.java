/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.assets;

import java.util.ArrayList;
import zytom.proptycoon.model.card.Card;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.PropertyCard;

/**
 * An entity that can own assets and therefor can
 * take part in transactions.
 * (Players and the bank).
 * @author Tom Chesters
 * @param <A>
 */
public interface AssetOwner<A extends Asset> {
    /**
     * @return The amount of money this asset owner is in possesion of.
     */
    public int getBalance();

    /**
     * Copies cards, does not remove.
     * @return All the cards that this asset owner is in possesion of.
     */
    public ArrayList<Card> getCards();

    /**
     * Copies cards, does not remove.
     * @return All the pot luck cards that this asset owner is in possesion of.
     */
    public ArrayList<PotLuckCard> getPotLuckCards();
    
    
    /**
     * Copies cards, does not remove.
     * @return All the pot luck cards that this asset owner is in possesion of.
     */
    public ArrayList<PotLuckCard> getOpportunityKnocksCards();

    /**
     * Copies cards, does not remove.
     * @return All the property cards that this asset owner is in possesion of.
     */
    public ArrayList<PropertyCard> getPropertyCards();

    /**
     * Remove the contents of the specified money asset 
     * from this asset owner and return them within
     * the asset instance.
     * @param requested The asset to look for in this asset owner.
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     * @return An asset instance containing the requested contents.
     */
    public Asset takeAsset(MoneyAsset requested) throws AssetOwner.AssetNotFoundException;
   
    /**
     * Remove the contents of the specified cards asset 
     * from this asset owner and return them within
     * the asset instance.
     * @param requested The asset to look for in this asset owner.
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     * @return An asset instance containing the requested contents.
     */
    public Asset takeAsset(CardsAsset requested) throws AssetOwner.AssetNotFoundException;

    /**
     * An exception to be thrown if an asset is trying to be taken
     * but does not exist within the specified asset owner.
     */
    public static class AssetNotFoundException extends Exception {
        /**
         * Generate the exception message.
         * @param giver The asset owner that was attempting to give an asset.
         * @param requested The asset that was requested.
         */
        public AssetNotFoundException(AssetOwner giver, Asset requested) {
            super (
                    "Requested asset could not be found in " +
                            giver.toString() +
                            ": \n" + requested.toString()
            );
        }
        /**
         * Gets the message containing details of the requested asset
         * contents.
         * @return The exception message.
         */
        @Override
        public String getMessage()
        {
            return super.getMessage();
        }
    }
    

}
