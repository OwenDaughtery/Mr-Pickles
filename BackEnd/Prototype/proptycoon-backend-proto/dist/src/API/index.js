'use strict';

Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _Game = require('../Game.js');

var _Game2 = _interopRequireDefault(_Game);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

/**
 * Back-end API singleton.
 * Provides easy-to-use methods for instantialising and interacting
 * with the back-end code.
 */
var API = function () {
    /**
     * Creates blank new game instance. 
     */
    function API() {
        _classCallCheck(this, API);

        this._game = {};
    }

    /**
     * Initialises the players on the back-end, and in effect, creates a new game.
     * @param {Array<string>} playerNames - Names of players that will be in game.
     * @returns Array of (soon-to-be) verified & validated player names.
     */


    _createClass(API, [{
        key: 'initialisePlayers',
        value: function initialisePlayers(playerNames) {
            var playerInfoList = [];
            var _iteratorNormalCompletion = true;
            var _didIteratorError = false;
            var _iteratorError = undefined;

            try {
                for (var _iterator = playerNames[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
                    var name = _step.value;

                    playerInfoList.push({
                        name: name,
                        index: playerNames.indexOf(name)
                    });
                }
            } catch (err) {
                _didIteratorError = true;
                _iteratorError = err;
            } finally {
                try {
                    if (!_iteratorNormalCompletion && _iterator.return) {
                        _iterator.return();
                    }
                } finally {
                    if (_didIteratorError) {
                        throw _iteratorError;
                    }
                }
            }

            this._game = new _Game2.default(playerInfoList);
            //TODO: verify and validate player names before returning.
            return playerNames;
        }

        /** 
         * @returns {Array<Object>} - Array of objects containing players' positions.
         * //TODO add more state values. 
         */

    }, {
        key: 'playerStates',
        get: function get() {
            //Map inline function to game's player array.
            return this._game.players.map(
            //For each instance, extract player's name and return it.
            function (player) {
                return player.name;
            });
        }
    }]);

    return API;
}();

var api = new API();
exports.default = api;