'use strict';

Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _Card = require('./Card.js');

var _Card2 = _interopRequireDefault(_Card);

var _fs = require('fs');

var _fs2 = _interopRequireDefault(_fs);

var _fastCsv = require('fast-csv');

var _fastCsv2 = _interopRequireDefault(_fastCsv);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

//npm install fast-csv

//TODO NEED WAY TO ENSURE THAT POT LUCK CARD CANNOT BE ADDED TO DECK OF OPPORTUNITY KNOCKS DECK AND VICE VERSA!

var Deck = function () {
    function Deck(path) {
        _classCallCheck(this, Deck);

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


    _createClass(Deck, [{
        key: 'populate',
        value: function populate() {
            var _this = this;

            //Returns a promise.
            //Resolves when all cards have been read from CSV.
            return new Promise(function (resolve) {
                //Load file stream.
                _fs2.default.createReadStream(_this.path).pipe((0, _fastCsv2.default)())
                //Each iterable in the stream.
                .on('data', function (data) {
                    _this.enqueue(new _Card2.default(data[0], data[1], data[2]));
                })
                //Stream has ended.
                .on('end', function () {
                    //Shuffle cards.
                    _this.shuffle();
                    //And resolve promise (can use .then() to access this event).
                    resolve();
                });
            });
        }

        /** 
         * Shuffles the deck of cards at the begining of the game. This function is called at 
         * very end of the populate() function
         */

    }, {
        key: 'shuffle',
        value: function shuffle() {
            var j, x, i;
            for (i = this.cards.length - 1; i > 0; i--) {
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

    }, {
        key: 'enqueue',
        value: function enqueue(card) {
            var newArray = [];
            newArray.push(card);
            this.contents = newArray.concat(this.contents);
        }

        /** 
         * Pops the top card off from the top of the deck.  
         */

    }, {
        key: 'dequeue',
        value: function dequeue() {
            return this.contents.pop();
        }
    }]);

    return Deck;
}();

exports.default = Deck;