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
     * @return All the property cards that this asset owner is in possesion of.
     */
    public ArrayList<PropertyCard> getPropertyCards();

    /**
     * Remove the contents of the specified asset 
     * from this asset owner and return them within
     * the asset instance.
     * @param requested The asset to look for in this asset owner.
     * @throws AssetNotFoundException If requested asset contents cannot be found in this asset owner.
     * @return An asset instance containing the requested contents.
     */
    public Asset takeAsset(Asset requested) throws AssetNotFoundException;


    public void giveAsset(Asset giving) ;

    /**
     * An exception to be thrown if an asset is trying to be taken
     * but does not exist within the specified asset owner.
     */
    public static class AssetNotFoundException extends Exception {
        /**
         * Generate the exception message.
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
