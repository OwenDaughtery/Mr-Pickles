/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.assets;

import zytom.proptycoon.model.card.Card;

import java.util.ArrayList;
import java.util.LinkedList;
import zytom.proptycoon.model.card.PropertyCard;

/**
 *
 * @author Tom Chesters
 */
public class CardsAsset<T extends Card> extends Asset {
    
    private final ArrayList<T> cards;
    
    public CardsAsset(ArrayList<T> cards){
        this.cards = cards;
    }

    public ArrayList<T> getCards() {
        return cards;
    }
}
