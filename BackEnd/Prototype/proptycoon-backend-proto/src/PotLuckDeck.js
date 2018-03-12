import Deck from './Deck.js';

/** 
 * Passes though the path of the PotLuck.csv file to the constructor 
 * of Deck
 */
export default class PotLuckDeck extends Deck {
    constructor() {
        super("./csv/decks/PotLuck.csv");
    }
}