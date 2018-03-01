import java.util.ArrayList;
import java.util.Queue;

/**
 * Store Card Objects, Give them to players, Shuffle deck, Receive them from players.
 *
 * @param LuckDeck
 */
public interface LuckKnocksDeck {
    //LuckCard = Pot Of Luck Card
    private Queue<LuckCard> LuckDeck;
    //KnocksCard =  Opportunity knocks card data
    private Queue<KnocksCard> KnocksDeck;

    //constructer
    LuckKnocksDeck(LuckDeck l, KnocksDeck k);

    /**
     * Shuffles Deck
     */
    void shuffleDeck();

    /**
     * Get top card from deck, call method to do what is on card, if not keeped by player add to queue.
     *
     * @param Player
     * @param DeckType
     */
    void takeCard(Player p, DeckType d);


}
