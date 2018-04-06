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
    private
    
    /**
     * @return The amount of money this asset owner is in possesion of.
     */
    public int getBalance();
    
    /**
     * @return An array list containing (copies) of all the cards that this asset owner is in possesion of.
     */
    public ArrayList<Card> getCards();
    
    /**
     * @return An array list containing (copies) of all the pot luck cards that this asset owner is in possesion of.
     */
    public ArrayList<PotLuckCard> getPotLuckCards();
    
    /**
     * @return An array list containing (copies) of all the property cards that this asset owner is in possesion of.
     */
    public ArrayList<PropertyCard> getProperties();
    
    public take
}
