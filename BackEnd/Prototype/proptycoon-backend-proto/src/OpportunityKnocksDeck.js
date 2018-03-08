import Card from './Card.js';
import fs from 'fs';
import fastCsv from 'fast-csv';

//npm install fast-csv

export default class OpportunityKnocksDeck {

    constructor(_typeOfDeck) {
        this.populate();

        this.type = _typeOfDeck;
        this.contents = [];
    }

    populate() {
        //Returns a promise.
        //Resolves when all cards have been read from CSV.
        return new Promise(
            (resolve) => {
                //Load file stream.
                var opportunityKnocksPath = "./csv/decks/OpportunityKnocks.csv";
                fs.createReadStream(opportunityKnocksPath)
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

    shuffle() {
        var j, x, i;
        for(i = this.contents.length - 1; i > 0; i--) {
            j = Math.floor(Math.random() * (i + 1));
            x = this.contents[i];
            this.contents[i] = this.contents[j];
            this.contents[j] = x;
        }
    }

    enqueue(card) {
        var newArray = [];
        newArray.push(card);
        this.contents = newArray.concat(this.contents);
    }

    dequeue() {
        return this.contents.pop();
    }

    //Due to be rid of.
    /*enqueue(_card) {
        
        this.contents[this.back] = _card;
        this.back ++;
        this.currentLength ++;
        this.back = this.back % this.currentLength;
    }

    dequeue() {
        var card = this.contents[this.front];
        this.contents[this.front] = null;
        this.front = this.front + 1;
        this.front = this.front % this.currentLength;
        return card; 
    }*/
}