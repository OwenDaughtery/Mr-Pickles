'use strict';

require('babel-polyfill');

var _Player = require('../src/Player.js');

var _Player2 = _interopRequireDefault(_Player);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var assert = require('chai').assert;
var expect = require('chai').expect;

//unit Test for Player Creation 
describe('Player_Unit_Test', function () {
    it('Instatiate Player Object', function (done) {
        var player = new _Player2.default();
        assert.typeOf(player, _Player2.default);

        done();
    });
    it('Player starts at position 0 on the Board', function (done) {
        var player = new _Player2.default();
        assert.typeOf(player, _Player2.default); //assert player is a type of player 
        // player starts at position zero 
        player.rollDice();
        done();
    });
});