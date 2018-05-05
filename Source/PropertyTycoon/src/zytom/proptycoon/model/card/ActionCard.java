/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.card;

/**
 *
 * @author Tom Chesters , Max Pattman
 */
public abstract class ActionCard extends Card {
    
    private final CardAction action;
    private final String description;
    
    public ActionCard(String description , CardAction action){
        this.action = action;
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
    
    public CardAction getCardAction() {
        return this.action;
    }
    
    
}
