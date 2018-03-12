'use strict';

Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () {
    function defineProperties(target, props) {
        for (var i = 0; i < props.length; i++) {
            var descriptor = props[i];descriptor.enumerable = descriptor.enumerable || false;descriptor.configurable = true;if ("value" in descriptor) descriptor.writable = true;Object.defineProperty(target, descriptor.key, descriptor);
        }
    }return function (Constructor, protoProps, staticProps) {
        if (protoProps) defineProperties(Constructor.prototype, protoProps);if (staticProps) defineProperties(Constructor, staticProps);return Constructor;
    };
}();

function _classCallCheck(instance, Constructor) {
    if (!(instance instanceof Constructor)) {
        throw new TypeError("Cannot call a class as a function");
    }
}

/** 
 * @author Ayman Zenos
 * 
 * Stores money, the wild card decks and real estate.
*/
var Bank = function () {
    function Bank(_players) {
        _classCallCheck(this, Bank);

        //Creates a mapping between players name and there balance.
        this.balanceOf = new Map();
        for (var i = 0; i < _players.length; i++) {
            this.balanceOf.set(_players[i][1], 1500);
        }
        this.balance = 50000;

        this.potLuckDeck = new Deck('PotLuck');
        this.oppKnocks = new Deck('OppKnocks');

        this.realEstate = new RealEstate();
    }

    /**
     * updated bank balance.
     * @param {int}_value the change in value to be made in the bank
     */

    _createClass(Bank, [{
        key: 'updateBankBalance',
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
        key: 'updatePlayerBalance',
        value: function updatePlayerBalance(_player, _value) {
            //assert(_value + this.balanceOf(_player.playerNumber) >= 0)
            this.balanceOf.set(_player.playerNumber, _value + this.balanceOf(_player.playerNumber));
        }
    }]);

    return Bank;
}();

exports.default = Bank;