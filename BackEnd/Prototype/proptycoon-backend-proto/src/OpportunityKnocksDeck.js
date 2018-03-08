import Deck from './Deck.js';

export default class OpportunityKnocksDeck extends Deck {
    /** 
     * Passes though the path of the OpportunityKnocks.csv file to the constructor 
     * of Deck
     */
    constructor() {
        super("./csv/decks/OpportunityKnocks.csv");
    }
}