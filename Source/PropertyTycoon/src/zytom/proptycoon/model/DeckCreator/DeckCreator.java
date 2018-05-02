package zytom.proptycoon.model.DeckCreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import zytom.proptycoon.model.card.CardAction;
import zytom.proptycoon.model.card.OpportunityKnocksCard;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;
import zytom.proptycoon.model.cell.UtilityPropertyCell;

/**
 * @author Zenos
 */
public class DeckCreator {

    public static ArrayList<PotLuckCard> createPotLuckDeck() throws FileNotFoundException {
        ArrayList<String[]> deckData = parseCSV("PotLuck.csv", 3);
        PotLuckDeck deck = new PotLuckDeck(deckData);
        return deck.getCards();
    }
    
    public static ArrayList<OpportunityKnocksCard> createOpportunityKnocksDeck() throws FileNotFoundException {
        ArrayList<String[]> deckData = parseCSV("OpportunityKnocks.csv", 3);
        OpportunityKnocksDeck deck = new OpportunityKnocksDeck(deckData);
        return deck.getCards();
    }
   
//    TODO CSV WITH PROPERTY CELLS SHOULD BE FORMATTED DIFFERENTLY. 
//    public static ArrayList<UtilityPropertyCard> createUtilityPropertyCardDeck() throws FileNotFoundException {
//        ArrayList<String[]> deckData = parseCSV("UtilityPropertyCard.csv", 6);
//        UtilityPropertyCardDeck deck = new UtilityPropertyCardDeck(deckData);
//        return deck.getCards();
//    }
    
    /**
     * Creates an ArrayList of String arrays to collect the data in the csv files
     * for all card types. 
     * 
     * @param nameOfCSV The name of the csv document containing the data of the cards.
     * @param columnsToRead The number of features
     * @return The ArrayList of String arrays if the csv file can be found. 
     * @throws java.io.FileNotFoundException 
     */
    private static ArrayList<String[]> parseCSV(String nameOfCSV, int columnsToRead) throws FileNotFoundException {
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
    private static class PotLuckDeck {

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
    private static class OpportunityKnocksDeck {

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
    
    
    
//    private static class UtilityPropertyCardDeck {
//        
//        private final ArrayList<UtilityPropertyCard> utilityPropertyCardDeck;
//        
//        private UtilityPropertyCardDeck(ArrayList<String[]> deckData) {
//            this.utilityPropertyCardDeck = new ArrayList<>();
//            for(String[] data : deckData) {
//                UtilityPropertyCell cellRef = new UtilityPropertyCell(data[0]);
//                UtilityPropertyCard utilityPropertyCard = new UtilityPropertyCard(cellRef, cellRef.getTitle(), Integer.parseInt(data[1]), 
//                        Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]);
//                this.utilityPropertyCardDeck.add(utilityPropertyCard);
//                
//                //give the cell reference to the new card
//                cellRef.setAssociatedCard(utilityPropertyCard);
//            }
//        }
//        
//        public ArrayList<UtilityPropertyCard> getCards() {
//            return this.utilityPropertyCardDeck;
//        }
//    }
} 
