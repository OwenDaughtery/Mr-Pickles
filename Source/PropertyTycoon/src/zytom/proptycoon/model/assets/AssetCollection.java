/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.assets;
import java.util.ArrayList;
import zytom.proptycoon.model.card.OpportunityKnocksCard;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.StationPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;

/**
 *
 * @author Tom Chesters
 */
public class AssetCollection {
    
    private final ArrayList<PotLuckCard> potLuckCards;
    private final ArrayList<OpportunityKnocksCard> opportunityKnocksCards;
    private final ArrayList<StreetPropertyCard> streetPropertyCards;
    private final ArrayList<StationPropertyCard> stationPropertyCards;
    private final ArrayList<UtilityPropertyCard> utilityPropertyCards;
    private int money;
    
    public AssetCollection
        (
            ArrayList<PotLuckCard> potLuckCards,
            ArrayList<OpportunityKnocksCard> opportunityKnocksCards,
            ArrayList<StreetPropertyCard> streetPropertyCards,
            ArrayList<StationPropertyCard> stationPropertyCards,
            ArrayList<UtilityPropertyCard> utilityPropertyCards
        ) 
    {
        this.potLuckCards = potLuckCards;
        this.opportunityKnocksCards = opportunityKnocksCards;
        this.streetPropertyCards = streetPropertyCards;
        this.stationPropertyCards = stationPropertyCards;
        this.utilityPropertyCards = utilityPropertyCards;
        this.money = 0;
    }
        
    public AssetCollection (int money) {
        this.potLuckCards = new ArrayList<>();
        this.opportunityKnocksCards = new ArrayList<>();
        this.streetPropertyCards = new ArrayList<>();
        this.stationPropertyCards = new ArrayList<>();
        this.utilityPropertyCards = new ArrayList<>();
        this.money = 0;
    }
        
    public ArrayList<PotLuckCard> getPotLuckCards() {
        return potLuckCards;
    }
    
    public ArrayList<OpportunityKnocksCard> getOpportunityKnocksCards() {
        return opportunityKnocksCards;
    }
    
    public ArrayList<StreetPropertyCard> getStreetPropertyCards() {
        return streetPropertyCards;
    }
    
    public ArrayList<StationPropertyCard> getStationPropertyCards() {
        return stationPropertyCards;
    }
    
    public ArrayList<UtilityPropertyCard> getUtilityPropertyCards() {
        return utilityPropertyCards;
    }
    
    public int getMoney() {
        return money;
    }
    
    public void setMoney(int value) {
        this.money = value;
    }
}