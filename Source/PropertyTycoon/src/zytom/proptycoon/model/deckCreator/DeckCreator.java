package zytom.proptycoon.model.deckCreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.card.CardAction;
import zytom.proptycoon.model.card.OpportunityKnocksCard;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.StationPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;
import zytom.proptycoon.model.cell.StationPropertyCell;
import zytom.proptycoon.model.cell.StreetPropertyCell;
import zytom.proptycoon.model.cell.UtilityPropertyCell;


/**
 * @author Zenos
 */
public class DeckCreator {
    

    private final ArrayList<String[]> propertyDeckData;
    private final ArrayList<String[]> potLuckDeckData;
    private final ArrayList<String[]> opportunityKnocksDeckData;
    
    public DeckCreator() throws FileNotFoundException {
        this.propertyDeckData = parseCSV("PropertyCards.csv", 11);
        this.potLuckDeckData = parseCSV("PotLuck.csv", 3);
        this.opportunityKnocksDeckData = parseCSV("Opportunityknocks.csv", 3);
    }
    
    /**
     * @return An ArrayList representation of the PotLuckCard deck.
     * @throws FileNotFoundException 
     */
    public ArrayList<PotLuckCard> createPotLuckDeck() throws FileNotFoundException {
        PotLuckDeck deck = new PotLuckDeck(this.potLuckDeckData);
        return deck.getCards();
    }
    
    
    /**
     * @return An ArrayList representation of the OpportunityKnocksCard deck.
     * @throws FileNotFoundException 
     */
    public ArrayList<OpportunityKnocksCard> createOpportunityKnocksDeck() throws FileNotFoundException {
        OpportunityKnocksDeck deck = new OpportunityKnocksDeck(this.opportunityKnocksDeckData);
        return deck.getCards();
    }
    
   
    /**
     * @param board
     * @return An ArrayList representation of the UtilityPropertyCard deck.
     * @throws FileNotFoundException 
     * @throws zytom.proptycoon.model.Board.CellNotFoundException 
     */
    public ArrayList<UtilityPropertyCard> createUtilityPropertyCardDeck(Board board) throws FileNotFoundException, Board.CellNotFoundException {
        UtilityPropertyCardDeck deck = new UtilityPropertyCardDeck(propertyDeckData, board);
        return deck.getCards();
    }
    
    
    /**
     * @param board
     * @return An ArrayList representation of the StationPropertyCard deck.
     * @throws FileNotFoundException 
     * @throws zytom.proptycoon.model.Board.CellNotFoundException 
     */
    public ArrayList<StationPropertyCard> createStationPropertyCardDeck(Board board) throws FileNotFoundException, Board.CellNotFoundException {
        StationPropertyCardDeck deck = new StationPropertyCardDeck(propertyDeckData, board);
        return deck.getCards();
    }
    
    
    /**
     * @param board
     * @return An ArrayList representation of the StreetPropertyCard deck. 
     * @throws FileNotFoundException 
     * @throws zytom.proptycoon.model.Board.CellNotFoundException 
     */
    public ArrayList<StreetPropertyCard> createStreetPropertyCardDeck(Board board) throws FileNotFoundException, Board.CellNotFoundException  {
        StreetPropertyCardDeck deck = new StreetPropertyCardDeck(propertyDeckData, board);
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
        ArrayList<String[]> data = new ArrayList<>();
        String[] currentParams = new String[columnsToRead];
        int index = 0;
        
        String path = "./resources/" + nameOfCSV; //path may need fixing
        File file = new File(path);
        Scanner inputStream = new Scanner(file);
        inputStream.useDelimiter(">");
        while(inputStream.hasNext()) {
            currentParams[index] = inputStream.next();
            index++;
            if(index == columnsToRead) {
                data.add(currentParams);
                currentParams = new String[columnsToRead];
                index = 0;
            }
        }
        //Only shuffle PotLuck cards and OpportunityKnocks cards.
        if("PotLuck.csv".equals(nameOfCSV) || "OpportunityKnocks.csv".equals(nameOfCSV)) {
            Collections.shuffle(data);
        }
        
        return data; 
    }
    
    
    public ArrayList<String[]> getPropertyData() {
        return this.propertyDeckData;
    }
    
    
    /**
     * Intended to be a short-lived object containing a deck of PotLuck cards. 
     */
    private class PotLuckDeck {

        private ArrayList<PotLuckCard> potLuckDeck;
        
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
    
    
    
    
    /**
     * Intended to be a short-lived object containing a deck of UtilityProperty cards. 
     */
    private class UtilityPropertyCardDeck {
        
        private final ArrayList<UtilityPropertyCard> utilityPropertyCardDeck;
        
        private UtilityPropertyCardDeck(ArrayList<String[]> deckData, Board board) throws Board.CellNotFoundException {
            this.utilityPropertyCardDeck = new ArrayList<>();
            int index = 0;
            for(String[] data : deckData) {

                if("UTILITIES".equals(data[1])) {
                    
                    String title = data[2];
                    int buyPrice = Integer.parseInt(data[3]);
                    UtilityPropertyCell cellRef = (UtilityPropertyCell) board.getCell(index);
                    
                    UtilityPropertyCard utilityPropertyCard = new UtilityPropertyCard(cellRef, title, buyPrice, 4, 10);
                    cellRef.setAssociatedCard(utilityPropertyCard);
                    this.utilityPropertyCardDeck.add(utilityPropertyCard);
                }
                index++;
            }
        }
        
        /**
         * @return The ArrayList of utilityProperty cards
         */
        public ArrayList<UtilityPropertyCard> getCards() {
            return this.utilityPropertyCardDeck;
        }
    }
    
    
    
    
    /**
     * Intended to be a short-lived object containing a deck of StationProperty cards. 
     */
    private class StationPropertyCardDeck {
        
        private final ArrayList<StationPropertyCard> stationPropertyCardDeck;
        int[] rentPrices = new int[4];
        
        private StationPropertyCardDeck(ArrayList<String[]> deckData, Board board) throws Board.CellNotFoundException {
            
            this.stationPropertyCardDeck = new ArrayList<>();
            
            this.rentPrices[0] = 25;
            this.rentPrices[1] = 50;
            this.rentPrices[2] = 100;
            this.rentPrices[3] = 200;
            int index = 0;
            for(String[] data : deckData) {
                if("STATION".equals(data[1])){
                    String title = data[2];
                    int buyPrice = Integer.parseInt(data[3]);
                    StationPropertyCell cellRef = (StationPropertyCell) board.getCell(index);
                    StationPropertyCard stationPropertyCard = new StationPropertyCard(cellRef, title, buyPrice, rentPrices);
                    cellRef.setAssociatedCard(stationPropertyCard);
                    this.stationPropertyCardDeck.add(stationPropertyCard);
                }
                index++;
            }
            
        }
        
        /**
         * @return The ArrayList of stationProperty cards
         */
        public ArrayList<StationPropertyCard> getCards() {
            return this.stationPropertyCardDeck;
        }
    }
    
    

    
   /**
     * Intended to be a short-lived object containing a deck of StreetProperty cards. 
     */
    private class StreetPropertyCardDeck {
        
        private final ArrayList<StreetPropertyCard> streetPropertyCardDeck;
        int[] rentPrices = new int[6];
        
        private StreetPropertyCardDeck(ArrayList<String[]> deckData, Board board) throws Board.CellNotFoundException {
            streetPropertyCardDeck = new ArrayList<>();
            int index = 0;
            for(String[] data : deckData) {
                String colour = data[1];
                if("BROWN".equals(colour) || "BLUE".equals(colour) ||
                        "PURPLE".equals(colour) || "ORANGE".equals(colour) ||
                        "RED".equals(colour) || "YELLOW".equals(colour) ||
                        "GREEN".equals(colour) || "DEEP BLUE".equals(colour)) {
                    StreetPropertyCell cellRef = (StreetPropertyCell) board.getCell(index);
                    String title = data[2];
                    int buyPrice = Integer.parseInt(data[3]);
                    int buildPrice = Integer.parseInt(data[10]);
                    this.rentPrices[0] = Integer.parseInt(data[4]); //0 houses
                    this.rentPrices[1] = Integer.parseInt(data[5]); //1 house
                    this.rentPrices[2] = Integer.parseInt(data[6]); //2 houses
                    this.rentPrices[3] = Integer.parseInt(data[7]); //3 houses
                    this.rentPrices[4] = Integer.parseInt(data[8]); //4 houses
                    this.rentPrices[5] = Integer.parseInt(data[9]); //hotel
                    StreetPropertyCard streetPropertyCard = new StreetPropertyCard(cellRef, title, buyPrice, rentPrices, buildPrice);
                    cellRef.setAssociatedCard(streetPropertyCard);
                    this.streetPropertyCardDeck.add(streetPropertyCard);
                }
                index++;
            }
        }
        
        /**
         * @return The ArrayList of streetProperty cards
         */
        public ArrayList<StreetPropertyCard> getCards() {
            return this.streetPropertyCardDeck;
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, Board.CellNotFoundException {
        
        DeckCreator d = new DeckCreator();
        Board board = new Board(d.getPropertyData());
        d.createStationPropertyCardDeck(board);
    }
} 
