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
 */
public interface AssetOwner {

    /**
     * @return All the assets that this asset owner is in possesion of.
     */
    public AssetCollection getAssetCollection();

    /**
     * Remove the contents of the specified asset collection
     * from this asset owner and return them within
     * the asset instance.
     * @param requested The asset to look for in this asset owner.
     * @throws AssetNotFoundException If requested asset contents cannot be 
     * found in this asset owner.
     * @return An asset collection containing the requested contents.
     */
    public AssetCollection takeAssetCollection(AssetCollection requested) 
            throws AssetOwner.AssetNotFoundException;
    
    
    /**
     * Append the contents of the specified asset collection
     * to the asset owner's asset collection.
     * @param giving 
     */
    @Override
    public void giveAssetCollection(AssetCollection giving);
   
    /**
     * An exception to be thrown if an asset is trying to be taken
     * but does not exist within the specified asset owner.
     */
    public static class AssetNotFoundException extends Exception {
        /**
         * Generate the exception message.
         * @param giver The asset owner that was attempting to give an asset.
         * @param requested The asset collection that was requested.
         */
        public AssetNotFoundException(
                AssetOwner giver, 
                AssetCollection requested
        ) {
            super (
                    "Requested asset collection could not be found in " +
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
