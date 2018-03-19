package BackEnd.Classes;

public interface Deck_interface {

    /**
        function Queues card to the back of the deck
     */
    public void enqueueCardToDeck();

    /**
     * function shuffles the cards in the deck
     */
    public void shuffleDeck();

    /**
     * function draws the next card from the deck
     * @param deck the deck that the card should be drawn from
     * @return a card from the top of the Deck.
     */
    public Card drawNextCard(Deck deck);

}
