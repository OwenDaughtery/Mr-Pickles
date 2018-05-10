/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.assets;
import java.util.ArrayList;

import zytom.proptycoon.model.card.*;
import zytom.proptycoon.model.cell.StreetPropertyCell;

/**
 *
 * @author Tom Chesters
 *
 * Class AssetCollection :
 * Holds all Relavent Card and Money assets for Player in the Game , along with the bank.
 */
public class AssetCollection {
    
    private final ArrayList<PotLuckCard> potLuckCards;
    private final ArrayList<OpportunityKnocksCard> opportunityKnocksCards;
    private final ArrayList<StreetPropertyCard> streetPropertyCards;
    private final ArrayList<StationPropertyCard> stationPropertyCards;
    private final ArrayList<UtilityPropertyCard> utilityPropertyCards;
    private int money;
    
    
    /**
     * Constructor creates an AssetCollection which is intended to be a long-lived object
     * which is used for the bank so that it can initially own all PotLuckCards, OpportunityKnocksCards,
     * StreetPropertyCards, StationPropertyCards, and UtilityPropertyCards.
     * 
     * @param potLuckCards The ArrayList of PotLuckCards
     * @param opportunityKnocksCards The ArrayList of OpportunityKnocksCard
     * @param streetPropertyCards The ArrayList of StreetPropertyCards
     * @param stationPropertyCards The ArrayList of StationPropertyCards
     * @param utilityPropertyCards The ArrayList of UtilityPropertyCards
     * @param money The amount of money
     */
    public AssetCollection
        (
            ArrayList<PotLuckCard> potLuckCards,
            ArrayList<OpportunityKnocksCard> opportunityKnocksCards,
            ArrayList<StreetPropertyCard> streetPropertyCards,
            ArrayList<StationPropertyCard> stationPropertyCards,
            ArrayList<UtilityPropertyCard> utilityPropertyCards,
            int money
        ) 
    {
        this.potLuckCards = potLuckCards;
        this.opportunityKnocksCards = opportunityKnocksCards;
        this.streetPropertyCards = streetPropertyCards;
        this.stationPropertyCards = stationPropertyCards;
        this.utilityPropertyCards = utilityPropertyCards;
        this.money = money;
    }

    /**
     * Constructor allows for the creation of a new StreetPropertyCard containing only
     * a single StationPropertyCard which is intended to be a short-lived object for a transaction to occur. 
     * @param streetPropertyCard The StreetPropertyCard 
     */
    public AssetCollection (StreetPropertyCard streetPropertyCard) {
        this.potLuckCards = new ArrayList<>();
        this.opportunityKnocksCards = new ArrayList<>();
        this.streetPropertyCards = new ArrayList<>();
        this.stationPropertyCards = new ArrayList<>();
        this.utilityPropertyCards = new ArrayList<>();
        this.streetPropertyCards.add(streetPropertyCard);
    }


    /**
     * Constructor allows for the creation of a new AssetCollection containing only
     * a single StationPropertyCard which is intended to be a short-lived object for a transaction to occur. 
     * @param stationPropertyCard The StationPropertyCard 
     */
    public AssetCollection (StationPropertyCard stationPropertyCard) {
        this.potLuckCards = new ArrayList<>();
        this.opportunityKnocksCards = new ArrayList<>();
        this.streetPropertyCards = new ArrayList<>();
        this.stationPropertyCards = new ArrayList<>();
        this.utilityPropertyCards = new ArrayList<>();
        this.stationPropertyCards.add(stationPropertyCard);
    }

    /**
     * Constructor allows for the creation of a new AssetCollection containing only
     * a single UtilityPropertyCard which is intended to be a short-lived object for a transaction to occur. 
     * @param utilityPropertyCard The UtilityPropertyCard 
     */
    public AssetCollection (UtilityPropertyCard utilityPropertyCard) {
        this.potLuckCards = new ArrayList<>();
        this.opportunityKnocksCards = new ArrayList<>();
        this.streetPropertyCards = new ArrayList<>();
        this.stationPropertyCards = new ArrayList<>();
        this.utilityPropertyCards = new ArrayList<>();
        this.utilityPropertyCards.add(utilityPropertyCard);
    }

    /**
     * Constructor allows for the creation of a new AssetCollection containing only
     * a single OpportunityKnocksCard which is intended to be a short-lived object for a transaction to occur. 
     * @param opportunityKnocksCard The OpportunityKnocksCard 
     */
    public AssetCollection (OpportunityKnocksCard opportunityKnocksCard) {
        this.potLuckCards = new ArrayList<>();
        this.opportunityKnocksCards = new ArrayList<>();
        this.streetPropertyCards = new ArrayList<>();
        this.stationPropertyCards = new ArrayList<>();
        this.utilityPropertyCards = new ArrayList<>();
        this.opportunityKnocksCards.add(opportunityKnocksCard);
    }

    /**
     * Constructor allows for the creation of a new AssetCollection containing only
     * a single PotLuckCard which is intended to be a short-lived object for a transaction to occur. 
     * @param potLuckCard The PotLuckCard 
     */
    public AssetCollection (PotLuckCard potLuckCard) {
        this.potLuckCards = new ArrayList<>();
        this.opportunityKnocksCards = new ArrayList<>();
        this.streetPropertyCards = new ArrayList<>();
        this.stationPropertyCards = new ArrayList<>();
        this.utilityPropertyCards = new ArrayList<>();
        this.potLuckCards.add(potLuckCard);
    }
    
    /**
     * Constructor allows for the creation of a new AssetCollection containing only
     * money which is intended to be a short-lived object for a transaction to occur
     * or a long-lived object for when initializing a player with an initial balance 
     * of £1,500. 
     * @param money The amount of money in the AssetCollection. 
     */
    public AssetCollection (int money) {
        this.potLuckCards = new ArrayList<>();
        this.opportunityKnocksCards = new ArrayList<>();
        this.streetPropertyCards = new ArrayList<>();
        this.stationPropertyCards = new ArrayList<>();
        this.utilityPropertyCards = new ArrayList<>();
        this.money = money;
    }
   

    /**
     * @return Array list of Potluck cards
     */
    public ArrayList<PotLuckCard> getPotLuckCards() {
        return potLuckCards;
    }
    
    /**
     * @return The ArrayList of OpportunityKnocksCards contianed within the 
     * AssetCollection.
     */
    public ArrayList<OpportunityKnocksCard> getOpportunityKnocksCards() {
        return opportunityKnocksCards;
    }
    
    /**
     * @return The ArrayList of StreetPropertyCards contained within the 
     * AssetCollection.
     */
    public ArrayList<StreetPropertyCard> getStreetPropertyCards() {
        return streetPropertyCards;
    }
    
    /**
     * @return All the station properties the asset owner owns
     */
    public ArrayList<StationPropertyCard> getStationPropertyCards() {
        return stationPropertyCards;
    }
    
    /**
     * @return All the utility properties the asset owner owns.
     */
    public ArrayList<UtilityPropertyCard> getUtilityPropertyCards() {
        return utilityPropertyCards;
    }
    
    /**
     * @return The amount of money the asset owner owns
     */
    public int getMoney() {
        return money;
    }
    
    /**
     * Sets the amount of money the asset owner has
     * @param value the amount of money being set
     */
    public void setMoney(int value) {
        this.money = value;
    }

    /**
     * @return The sum of the value of all properties and money the asset owner owns.
     */
    public int calculateValue(){
        int value = money;
        for (StreetPropertyCard s:streetPropertyCards) {
            value +=  s.getPrice();
            StreetPropertyCell cell = (StreetPropertyCell) s.getCellRef();
            value += cell.getNumberOfBuildings()*s.getBuildCost();
        }
        for(UtilityPropertyCard u: utilityPropertyCards){
            value +=  u.getPrice();
        }
        for(StationPropertyCard st: stationPropertyCards){
            value +=  st.getPrice();
        }
        return value;
    }

    @Override
    public String toString(){

        String info  = "ASSET COLLECTION :" + "\n"+
                        "CASH BALANCE : " + this.getMoney() + "\n";

        String stationprops = "STATION PROPERTIES : " + "\n\n" + "--------------------------\n";

        for (PropertyCard p :
                this.getStationPropertyCards()) {
            stationprops += p.toString();
        }
        String utilitiesprops = "UTILITIES PROPERTIES : " + "\n\n"+ "--------------------------\n";

        for (UtilityPropertyCard p :
                this.getUtilityPropertyCards()) {
            utilitiesprops += p.toString();
        }
        String streetprops = "STREET PROPERTIES : " + "\n\n"+ "--------------------------\n";

        for (StreetPropertyCard p :
                this.getStreetPropertyCards()) {
            streetprops += p.toString();
        }
        info += stationprops;
        info += utilitiesprops;
        info += streetprops;

        return info;
    }
}
