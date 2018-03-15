"use strict";

Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _PotLuckDeck = require("./PotLuckDeck.js");

var _PotLuckDeck2 = _interopRequireDefault(_PotLuckDeck);

var _OpportunityKnocksDeck = require("./OpportunityKnocksDeck.js");

var _OpportunityKnocksDeck2 = _interopRequireDefault(_OpportunityKnocksDeck);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

/** 
 * @author Ayman Zenos
 * 
 * Stores money, the wild card decks and real estate.
*/
var Bank = function () {
    /**
     * @param {*} _players The array of participating players.
     */
    function Bank(_players) {
        _classCallCheck(this, Bank);

        //Creates a mapping between players name and there balance.
        this.balanceOf = new Map();
        for (var i = 0; i < _players.length; i++) {
            this.balanceOf.set(_players[i][1], 1500);
        }
        this.balance = 50000;

        this.potLuckDeck = new _PotLuckDeck2.default();
        this.oppKnocks = new _OpportunityKnocksDeck2.default();

        //this.realEstate = new RealEstate();
    }

    /**
     * updated bank balance.
     * @param {int}_value the change in value to be made in the bank
     */


    _createClass(Bank, [{
        key: "updateBankBalance",
        value: function updateBankBalance(_value) {
            //assert(this.balance + _value >= 0)
            this.balance = this.balance + _value;
        }

        /**
         * 
         * @param {Player} _player 
         * @param {int} _value 
         */

    }, {
        key: "updatePlayerBalance",
        value: function updatePlayerBalance(_player, _value) {
            //assert(_value + this.balanceOf(_player.playerNumber) >= 0)
            this.balanceOf.set(_player.playerNumber, _value + this.balanceOf(_player.playerNumber));
        }
    }]);

    return Bank;
}();

exports.default = Bank;