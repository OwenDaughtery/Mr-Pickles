import Deck from './Deck.js';

export default class OpportunityKnocksDeck extends Deck {
    constructor() {
        super("./csv/decks/OpportunityKnocks.csv");
    }
}