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

    public AssetCollection (StreetPropertyCard streetPropertyCard) {
        this.potLuckCards = new ArrayList<>();
        this.opportunityKnocksCards = new ArrayList<>();
        this.streetPropertyCards = new ArrayList<>();
        this.stationPropertyCards = new ArrayList<>();
        this.utilityPropertyCards = new ArrayList<>();
        this.streetPropertyCards.add(streetPropertyCard);
    }

    public AssetCollection (StationPropertyCard stationPropertyCard) {
        this.potLuckCards = new ArrayList<>();
        this.opportunityKnocksCards = new ArrayList<>();
        this.streetPropertyCards = new ArrayList<>();
        this.stationPropertyCards = new ArrayList<>();
        this.utilityPropertyCards = new ArrayList<>();
        this.stationPropertyCards.add(stationPropertyCard);
    }

    public AssetCollection (UtilityPropertyCard utilityPropertyCard) {
        this.potLuckCards = new ArrayList<>();
        this.opportunityKnocksCards = new ArrayList<>();
        this.streetPropertyCards = new ArrayList<>();
        this.stationPropertyCards = new ArrayList<>();
        this.utilityPropertyCards = new ArrayList<>();
        this.utilityPropertyCards.add(utilityPropertyCard);
    }

    public AssetCollection (OpportunityKnocksCard opportunityKnocksCard) {
        this.potLuckCards = new ArrayList<>();
        this.opportunityKnocksCards = new ArrayList<>();
        this.streetPropertyCards = new ArrayList<>();
        this.stationPropertyCards = new ArrayList<>();
        this.utilityPropertyCards = new ArrayList<>();
        this.opportunityKnocksCards.add(opportunityKnocksCard);
    }

    public AssetCollection (PotLuckCard potLuckCard) {
        this.potLuckCards = new ArrayList<>();
        this.opportunityKnocksCards = new ArrayList<>();
        this.streetPropertyCards = new ArrayList<>();
        this.stationPropertyCards = new ArrayList<>();
        this.utilityPropertyCards = new ArrayList<>();
        this.potLuckCards.add(potLuckCard);
    }
        
    public AssetCollection (int money) {
        this.potLuckCards = new ArrayList<>();
        this.opportunityKnocksCards = new ArrayList<>();
        this.streetPropertyCards = new ArrayList<>();
        this.stationPropertyCards = new ArrayList<>();
        this.utilityPropertyCards = new ArrayList<>();
        this.money = money;
    }
   

    /**
     *
     * @return Array list of Potluck cards
     */
    public ArrayList<PotLuckCard> getPotLuckCards() {
        return potLuckCards;
    }
    
    public ArrayList<OpportunityKnocksCard> getOpportunityKnocksCards() {
        return opportunityKnocksCards;
    }
    
    /**
     * 
     * @return 
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
    
    public boolean checkHasAsset(StreetPropertyCard card) {
        return streetPropertyCards.contains(card);
    }
    
    public boolean checkHasAsset(StationPropertyCard card) {
        return stationPropertyCards.contains(card);
    }
    
    public boolean checkHasAsset(UtilityPropertyCard card) {
        return utilityPropertyCards.contains(card);
    }
    
    public boolean checkHasAsset(PotLuckCard card) {
        return potLuckCards.contains(card);
    }
    
    public boolean checkHasAsset(OpportunityKnocksCard card) {
        return opportunityKnocksCards.contains(card);
    }
    
    public boolean checkHasAsset(int money){
        return (this.money > money);
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
