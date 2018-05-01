package zytom.proptycoon.model.DeckCreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Zenos
 */
public class DeckCreator {
    
    /**
     * Method creates an ArrayList of String arrays to collect the data in the csv files
     * for all card types. 
     * 
     * @param nameOfCSV The name of the csv document containing the data of the cards.
     * @param columnsToRead The number of features
     * @return The ArrayList of String arrays if the csv file can be found. 
     * @throws java.io.FileNotFoundException 
     */
    public static ArrayList<String[]> initDeck(String nameOfCSV, int columnsToRead) throws FileNotFoundException {
        ArrayList<String[]> deck = new ArrayList<>();
        String[] currentParams = new String[columnsToRead];
        int index = 0;
        String path = "./" + nameOfCSV; //path may need fixing
        File file = new File(path);
        Scanner inputStream = new Scanner(file);
        inputStream.useDelimiter(">>");
        while(inputStream.hasNext()) {
            currentParams[index] = inputStream.next();
            index++;
            if(index == columnsToRead) {
                deck.add(currentParams);
                currentParams = new String[columnsToRead];
                index = 0;
            }
        }
        Collections.shuffle(deck);
        return deck;
        
        
    }
} 

