/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.card;

/**
 * Class is extended by PotLuckCard and OpportunityKnocksCard classes
 * @author Tom Chesters , Max Pattman
 */
public abstract class ActionCard extends Card {
    
    private final CardAction action;
    private final String description;
    
    /**
     * Constructor assigns the ActionCard a description and a CardAction
     * @param description The description describing the CardAction
     * @param action The CardAction the player must do
     */
    public ActionCard(String description , CardAction action){
        this.action = action;
        this.description = description;
    }
    
    /**
     * @return The description of the ActionCard
     */
    public String getDescription(){
        return this.description;
    }
    
    /**
     * @return The CardAction with the methods the player must execute. 
     */
    public CardAction getCardAction() {
        return this.action;
    }
    
}
