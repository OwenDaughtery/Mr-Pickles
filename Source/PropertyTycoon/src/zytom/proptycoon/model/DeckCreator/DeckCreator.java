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
    private static String nameOfCSV;

    public DeckCreator(String nameOfCSV) {
        this.nameOfCSV = nameOfCSV;
        initDeck();
    }

    public static ArrayList<String[]> initDeck() {
        ArrayList<String[]> deck = new ArrayList<>();
        String[] currentParams = new String[3];
        int index = 0;
        String path = "zytom/proptycoon/model/src/Resources/" + nameOfCSV; //path may need fixing
        File file = new File(path);
        try{
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collections.shuffle(deck);
        return deck;
    }

}