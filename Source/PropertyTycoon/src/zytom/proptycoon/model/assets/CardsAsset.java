/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.assets;

import zytom.proptycoon.model.card.Card;

import java.util.ArrayList;

/**
 *
 * @author Tom Chesters
 */
public class CardsAsset extends Asset {

    ArrayList<Card> cards;
    public CardsAsset(ArrayList<Card> cards){
        this.cards = cards;

    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
