'use strict';
import 'babel-polyfill';
import Game from "../src/Game.js";
import Board from "../src/Board.js";
import Dice from "../src/Dice.js";
import Player from "../src/Player.js";
var assert = require('chai').assert;
var expect = require('chai').expect;


describe('Game_Tests_Unit ', function () {
    it('Instantiate Game Object', function (done) {
        var game = new Game(); //instantiate a game with 5 players
        assert.typeOf(game, Game); // assert that game object is of type game
        
        done();
    })
});