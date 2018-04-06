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
     * 
     * @return All the cards that this asset owner is in possesion of.
     */
    public ArrayList<Card> getCards();
    
    /**
     * @return All the pot luck cards that this asset owner is in possesion of.
     */
    public ArrayList<PotLuckCard> getPotLuckCards();
    
    /**
     * @return All the property cards that this asset owner is in possesion of.
     */
    public ArrayList<PropertyCard> getProperties();
    
    /**
     * 
     * @param Requested
     * @return 
     */
    public Asset takeAsset(Asset Requested);
}
