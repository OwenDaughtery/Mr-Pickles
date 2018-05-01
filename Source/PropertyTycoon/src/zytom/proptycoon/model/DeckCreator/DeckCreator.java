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
     * Method creates an ArrayList of length 3 String arryas, each index of the String
     * array cointains the first, second and third feature of each row in the csv file
     * i.e. description, action and value. 
     * 
     * @param nameOfCSV The name of the csv document containing the data of the cards.
     * @return The ArrayList of String arrays if the csv file can be found. 
     * @throws java.io.FileNotFoundException 
     */
    public static ArrayList<String[]> initDeck(String nameOfCSV) throws FileNotFoundException {
        ArrayList<String[]> deck = new ArrayList<>();
        String[] currentParams = new String[3];
        int index = 0;
        String path = "./" + nameOfCSV; //path may need fixing
        File file = new File(path);
        Scanner inputStream = new Scanner(file);
        inputStream.useDelimiter(">>");
        while(inputStream.hasNext()) {
            currentParams[index] = inputStream.next();
            index++;
            if(index == 3) {
                deck.add(currentParams);
                currentParams = new String[3];
                index = 0;
            }
        }
        Collections.shuffle(deck);
        return deck;
        
        
    }
} 

