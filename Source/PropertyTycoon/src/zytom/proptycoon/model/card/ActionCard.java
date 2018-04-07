/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.card;

/**
 *
 * @author Tom Chesters , Max Pattman
 */
public abstract class ActionCard extends Card {
    String description ;
    public ActionCard ActionCard(String description , CardAction action){
        this.description = description;


        return this ;
    }

    public String getDescription(){
        return this.description;
    }
    
}
