/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.assets;

import zytom.proptycoon.model.card.Card;

/**
 *
 * @author Tom
 * @param <T> Any extension of Card.
 */
public class CardAsset<T extends Card> {
    
    private final T card;
    
    public CardAsset(T card) {
        this.card = card;
    }
    
    public T getCard() {
        return this.card;
    }
    
}
