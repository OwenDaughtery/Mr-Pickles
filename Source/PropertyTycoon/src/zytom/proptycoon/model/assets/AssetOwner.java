/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.assets;

import zytom.proptycoon.model.card.Card;
import zytom.proptycoon.model.card.OpportunityKnocksCard;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.StationPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;

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
            throws AssetNotFoundException;
    
    
    /**
     * Append the contents of the specified asset collection
     * to the asset owner's asset collection.
     * @param giving 
     * @throws CannotAcceptAssetException 
     */
    public void giveAssetCollection(AssetCollection giving)
            throws CannotAcceptAssetException;
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


    public static class CannotAcceptAssetException extends Exception {
        /**
         * Generate the exception message.
         * @param receiver The asset owner that was receiving an asset 
         * collection.
         * @param receiving The asset collection that was being received.
         */
        public CannotAcceptAssetException(
                AssetOwner receiver, 
                AssetCollection receiving
        ) {
            super (
                    "Asset collection cannot be accepted by " +
                            receiver.toString() +
                            ": \n" + receiving.toString()
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
