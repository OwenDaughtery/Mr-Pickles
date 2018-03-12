"use strict";

Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

/**
 * @author Ayman Zenos
 * 2 fair Die which can be roled
 */
var Dice = function () {
    function Dice() {
        _classCallCheck(this, Dice);

        this.die1 = 0;
        this.die2 = 0;
    }

    /**
     * @return numbers on dice
     */


    _createClass(Dice, [{
        key: "genNumber",


        /**
         * @return random interger between 1-6
         */
        value: function genNumber() {
            return Math.floor(Math.random() * 6) + 1;
        }

        /**
         * randomly changes numbers on dice and returns them as an array
         * 
         * @return array containing two integers representing new nubers on dice.
         */

    }, {
        key: "rollDice",
        value: function rollDice() {
            this.die1 = this.genNumber();
            this.die2 = this.genNumber();
            this.dice = [this.die1, this.die2];
            return this.dice;
        }
    }, {
        key: "numbers",
        get: function get() {
            return this.die1, this.die2;
        }
    }]);

    return Dice;
}();

exports.default = Dice;