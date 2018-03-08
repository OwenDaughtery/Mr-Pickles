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

var OpportunityKnocksDeck = function () {
    function OpportunityKnocksDeck(_typeOfDeck) {
        _classCallCheck(this, OpportunityKnocksDeck);

        this.populate();

        this.type = _typeOfDeck;
        this.contents = [];
    }

    _createClass(OpportunityKnocksDeck, [{
        key: 'populate',
        value: function populate() {
            var _this = this;

            //Returns a promise.
            //Resolves when all cards have been read from CSV.
            return new Promise(function (resolve) {
                //Load file stream.
                var opportunityKnocksPath = "./csv/decks/OpportunityKnocks.csv";
                _fs2.default.createReadStream(opportunityKnocksPath).pipe((0, _fastCsv2.default)())
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
    }, {
        key: 'shuffle',
        value: function shuffle() {
            var j, x, i;
            for (i = this.contents.length - 1; i > 0; i--) {
                j = Math.floor(Math.random() * (i + 1));
                x = this.contents[i];
                this.contents[i] = this.contents[j];
                this.contents[j] = x;
            }
        }
    }, {
        key: 'enqueue',
        value: function enqueue(card) {
            var newArray = [];
            newArray.push(card);
            this.contents = newArray.concat(this.contents);
        }
    }, {
        key: 'dequeue',
        value: function dequeue() {
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

    }]);

    return OpportunityKnocksDeck;
}();

exports.default = OpportunityKnocksDeck;