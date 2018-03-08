'use strict';

require('babel-polyfill');

var _Game = require('../src/Game.js');

var _Game2 = _interopRequireDefault(_Game);

var _Board = require('../src/Board.js');

var _Board2 = _interopRequireDefault(_Board);

var _Dice = require('../src/Dice.js');

var _Dice2 = _interopRequireDefault(_Dice);

var _Player = require('../src/Player.js');

var _Player2 = _interopRequireDefault(_Player);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var assert = require('chai').assert;
var expect = require('chai').expect;

describe('Game_Tests_Unit ', function () {
    it('Instantiate Game Object', function (done) {
        var game = new _Game2.default(); //instantiate a game with 5 players
        assert.typeOf(game, _Game2.default); // assert that game object is of type game

        done();
    });
});