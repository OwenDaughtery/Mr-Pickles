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

var _Board = require('./Board.js');

var _Board2 = _interopRequireDefault(_Board);

var _Dice = require('./Dice.js');

var _Dice2 = _interopRequireDefault(_Dice);

var _Player = require('./Player.js');

var _Player2 = _interopRequireDefault(_Player);

function _interopRequireDefault(obj) {
    return obj && obj.__esModule ? obj : { default: obj };
}

function _classCallCheck(instance, Constructor) {
    if (!(instance instanceof Constructor)) {
        throw new TypeError("Cannot call a class as a function");
    }
}

/**
 * @author Ayman Zenos
 * 
 * Creates a board, dice and all the players. The players are stored in an array.
 */
var Game = function () {
    /**
     * @param {Player} _Players is an array of tuples where the first space represents the name of the player and the second is the character that the player has chosen.
     */
    function Game(_players) {
        _classCallCheck(this, Game);

        this.board = new _Board2.default();
        this.dice = new _Dice2.default();
        this.players = [];
        this.playerTurn = 0; //Number relative to position of player in array.
        //Adds players to Players array.
        for (var x = 0; x < _players.length; x++) {
            this.players.push(new _Player2.default(_players[x][0], _players[x][1], this.dice));
        }
    }

    /**
     * Hard sets the players turn. Only done at begining of game acfter deciding who goes first.
     * @param {int} _playerIndex 
     */

    _createClass(Game, [{
        key: 'setTurn',
        value: function setTurn(_playerIndex) {
            //assert(_playerIndex >= 0 && _playerIndex < this.players.length);
            this.playerTurn = _playerIndex;
        }

        /**
         * Increments player turn.
         */

    }, {
        key: 'newTurn',
        value: function newTurn() {
            this.playerTurn = this.playerTurn % this.players.length;
        }
    }]);

    return Game;
}();

exports.default = Game;