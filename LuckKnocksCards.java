
import java.util.ArrayList;

/**
 * @author aymanfree
 *
 * Creates Pot of Luck and Knock cards which have a type, the text writen on the card,
 * An array of actions that will can be excicuted relating to the rues on the card text,
 * and has an owner which is initualy the board.
 */
public interface LuckKnocksCards {

    DeckType luckKnock;
    String text;
    ArrayList<Action> actions;
    String owner = "board";

    LuckKnocksCards(DeckType luckKnock, String text, ArrayList<Action> actions);

    //change the owner of the card
    void changeOwner(String currentOwner, String newOwner);

    //Do what is said on card fro current owner
    void runCard();

}
