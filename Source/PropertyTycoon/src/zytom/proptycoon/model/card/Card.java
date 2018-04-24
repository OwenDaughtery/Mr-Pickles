/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.card;

/**
 *
 * @author Tom Chesters
 */
public abstract class Card {
    private final int cost;
    private final String name;
    
    public Card() {
        cost = readCost();
        name = readName();
    }
    
    private int readCost(ArrayList<String,String> parsedCsvData) {
        
    }
}
