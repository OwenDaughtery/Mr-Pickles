package zytom.proptycoon.model.DeckCreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import zytom.proptycoon.model.card.CardAction;
import zytom.proptycoon.model.card.OpportunityKnocksCard;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.StationPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;

/**
 * @author Zenos
 */
public class DeckCreator {
    

    public ArrayList<PotLuckCard> createPotLuckDeck() throws FileNotFoundException {
        ArrayList<String[]> deckData = parseCSV("PotLuck.csv", 3);
        PotLuckDeck deck = new PotLuckDeck(deckData);
        return deck.getCards();
    }
    
    public ArrayList<OpportunityKnocksCard> createOpportunityKnocksDeck() throws FileNotFoundException {
        ArrayList<String[]> deckData = parseCSV("OpportunityKnocks.csv", 3);
        OpportunityKnocksDeck deck = new OpportunityKnocksDeck(deckData);
        return deck.getCards();
    }
    
    public ArrayList<StreetPropertyCard> createStreetPropertyCardDeck() throws FileNotFoundException {
        ArrayList<String[]> deckData = parseCSV("UtilityPropertyCard.csv", 4);
        StreetPropertyCardDeck deck = new StreetPropertyCardDeck(deckData);
        return deck.getCards();
    }
    
    public ArrayList<StationPropertyCard> createStationPropertyCardDeck() throws FileNotFoundException {
        ArrayList<String[]> deckData = parseCSV("UtilityPropertyCard.csv", 4);
        StationPropertyCardDeck deck = new StationPropertyCardDeck(deckData);
        return deck.getCards();
    }

    public ArrayList<UtilityPropertyCard> createUtilityPropertyCardDeck() throws FileNotFoundException {
        ArrayList<String[]> deckData = parseCSV("UtilityPropertyCard.csv", 4);
        UtilityPropertyCardDeck deck = new UtilityPropertyCardDeck(deckData);
        return deck.getCards();
    }
    
    /**
     * Creates an ArrayList of String arrays to collect the data in the csv files
     * for all card types. 
     * 
     * @param nameOfCSV The name of the csv document containing the data of the cards.
     * @param columnsToRead The number of features
     * @return The ArrayList of String arrays if the csv file can be found. 
     * @throws java.io.FileNotFoundException 
     */
    private ArrayList<String[]> parseCSV(String nameOfCSV, int columnsToRead) throws FileNotFoundException {
        ArrayList<String[]> deckData = new ArrayList<>();
        String[] currentParams = new String[columnsToRead];
        int index = 0;
        String path = "./" + nameOfCSV; //path may need fixing
        File file = new File(path);
        Scanner inputStream = new Scanner(file);
        inputStream.useDelimiter(">");
        while(inputStream.hasNext()) {
            currentParams[index] = inputStream.next();
            index++;
            if(index == columnsToRead) {
                deckData.add(currentParams);
                currentParams = new String[columnsToRead];
                index = 0;
            }
        }
        //Only shuffle PotLuck cards and OpportunityKnocks cards.
        if("PotLuck.csv".equals(nameOfCSV) || "OpportunityKnocks.csv".equals(nameOfCSV)) {
            Collections.shuffle(deckData);
        }
        return deckData; 
    }
    
    
    
    /**
     * Intended to be a short-lived object containing a deck of PotLuck cards. 
     */
    private class PotLuckDeck {

        private final ArrayList<PotLuckCard> potLuckDeck;
        
        /**
         * @param deckData The parsed csv data
         */
        private PotLuckDeck(ArrayList<String[]> deckData) {
            this.potLuckDeck = new ArrayList<>();
            for(String[] data : deckData) {
                CardAction currentCardAction = new CardAction(data[1], Integer.parseInt(data[2]));
                PotLuckCard currentPotLuckCard = new PotLuckCard(data[0], currentCardAction);
                this.potLuckDeck.add(currentPotLuckCard);
            }
           
        }
        
        /**
         * @return The ArrayList of potLuck cards
         */
        public ArrayList<PotLuckCard> getCards() {
            return this.potLuckDeck;
        }
    }
    
    
    
    /**
     * Intended to be a short-lived object containing a deck of OpportunityKnocks cards. 
     */
    private class OpportunityKnocksDeck {

        private final ArrayList<OpportunityKnocksCard> opportunityKnocksDeck;
        
        /**
         * @param deckData The parsed csv data
         */
        private OpportunityKnocksDeck(ArrayList<String[]> deckData) {       
            this.opportunityKnocksDeck = new ArrayList<>();
            for(String[] data : deckData) {
                CardAction currentCardAction = new CardAction(data[1], Integer.parseInt(data[2]));
                OpportunityKnocksCard currentPotLuckCard = new OpportunityKnocksCard(data[0], currentCardAction);
                this.opportunityKnocksDeck.add(currentPotLuckCard);
            }
           
        }
        
        /**
         * @return The ArrayList of opportunityKnocks cards
         */
        public ArrayList<OpportunityKnocksCard> getCards() {
            return this.opportunityKnocksDeck;
        }
    }
    
    
    
    private class UtilityPropertyCardDeck {
        
        private final ArrayList<UtilityPropertyCard> utilityPropertyCardDeck;
        
        private UtilityPropertyCardDeck(ArrayList<String[]> deckData) {
            this.utilityPropertyCardDeck = new ArrayList<>();
            for(String[] data : deckData) {
                if("UTILITIES".equals(data[1])) {
                    String title = data[2];
                    int buyPrice = Integer.parseInt(data[4]);
                    int cellRef = Integer.parseInt(data[0]);
                    UtilityPropertyCard utilityPropertyCard = new UtilityPropertyCard(cellRef, title, buyPrice, 4, 10);
                    this.utilityPropertyCardDeck.add(utilityPropertyCard);
                }
            }
        }
        
        public ArrayList<UtilityPropertyCard> getCards() {
            return this.utilityPropertyCardDeck;
        }
    }
    
    private class StationPropertyCardDeck {
        
        private final ArrayList<StationPropertyCard> stationPropertyCardDeck;
        int[] prices = new int[4];
        
        private StationPropertyCardDeck(ArrayList<String[]> deckData) {
            this.stationPropertyCardDeck = new ArrayList<>();
            this.prices[0] = 25;
            this.prices[1] = 50;
            this.prices[2] = 100;
            this.prices[3] = 200;
            for(String[] data : deckData) {
                if("STATION".equals(data[1])){
                    String title = data[2];
                    int buyPrice = Integer.parseInt(data[4]);
                    //StationPropertyCard stationPropertyCard
                }
            }
        }
    }
} 
