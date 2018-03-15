import Card from './Card.js';
import fs from 'fs';
import fastCsv from 'fast-csv';

//npm install fast-csv

//TODO NEED WAY TO ENSURE THAT POT LUCK CARD CANNOT BE ADDED TO DECK OF OPPORTUNITY KNOCKS AND VICE VERSA!

export default class Deck {
    constructor(path) {
        //The path to the .csv file
        this.path = path;
        this.cards = [];
        this.populate();
        //console.log(this.cards);
    }

    /** 
     * Reads .csv file in the given path and for each row of entries, creates a new
     * Card object and adds them to the array of cards.
     */
    populate() {
        //Returns a promise.
        //Resolves when all cards have been read from CSV.
        return new Promise(
            (resolve) => {
                //Load file stream.
                fs.createReadStream(this.path)
                    .pipe(fastCsv())
                    //Each iterable in the stream.
                    .on('data', (data) => {
                        this.enqueue(new Card(data[0], data[1], data[2]));
                    })
                    //Stream has ended.
                    .on('end', () => {
                        //Shuffle cards.
                        this.shuffle();
                        //And resolve promise (can use .then() to access this event).
                        resolve();
                    });
            }
        )
    }

    /** 
     * Shuffles the deck of cards at the begining of the game. This function is called at 
     * very end of the populate() function
     */
    shuffle() {
        var j, x, i;
        for(i = this.cards.length - 1; i > 0; i--) {
            j = Math.floor(Math.random() * (i + 1));
            x = this.cards[i];
            this.cards[i] = this.contents[j];
            this.cards[j] = x;
        }
    }

    /**
     * Adds a card to the stack of cards. 
     * @param {*} card The card to be added to the stack
     */
    enqueue(card) {
        var newArray = [];
        newArray.push(card);
        this.contents = newArray.concat(this.contents);
    }

    /** 
     * Pops the top card off from the top of the deck.  
     */
    dequeue() {
        return this.contents.pop();
    }
}