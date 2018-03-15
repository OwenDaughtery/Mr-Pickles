'use strict';

Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _Bank = require('./Bank.js');

var _Bank2 = _interopRequireDefault(_Bank);

var _Players = require('./Players.js');

var _Players2 = _interopRequireDefault(_Players);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

//importFreeParking

/**
 * @author Ayman Zenos
 * 
 * Contains crutal events that will take place in many other classes.
 */
var Actions = function () {
    function Actions(_bank, _freeParking, _players) {
        _classCallCheck(this, Actions);

        this.bank = _bank;
        this.freeParking = _freeParking;
    }

    /**
     * Transers money between players, the bank and free parking.
     * @param {Player/Bank/FreeParking}_p1 the entity who is sending the money
     * @param {Player/Bank/FreeParking}_p2 the entity who is receving the money
     * @param {int}_p3 the amount of money that will be transferd 
     */


    _createClass(Actions, [{
        key: 'moneyTransfer',
        value: function moneyTransfer(_p1, _p2, _value) {
            if (_p1 instanceof _Bank2.default) {
                this.bank.updateBankBalance(-_value);
            } else if (p1 instanceof FreeParking) {
                this.freeParking.updateFreeParking(-_value);
            } else {
                this.bank.updatePlayerBalance(_p1, -_value);
            }

            if (_p2 instanceof _Bank2.default) {
                this.bank.updateBankBalance(_value);
            } else if (p2 instanceof FreeParking) {
                this.freeParking.updateFreeParking(_value);
            } else {
                this.bank.updatePlayerBalance(_p2, _value);
            }
        }

        /**
         * Transers property between players.
         * @param {Player/Bank/FreeParking}_p1 the entity who is sending the property
         * @param {Player/Bank/FreeParking}_p2 the entity who is receving the property
         * @param {int}_p3 the property that is being transfered.
         */

    }, {
        key: 'changeOwner',
        value: function changeOwner(_p1, _p2, _estate) {
            //assert _p1.realEstate.contains(_estate)
            _p2.realEstate.push(_p1.realEstate.remove(indexOf(_estate)));
        }
    }]);

    return Actions;
}();

exports.default = Actions;