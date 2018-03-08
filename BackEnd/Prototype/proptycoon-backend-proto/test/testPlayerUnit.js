'use strict';
import 'babel-polyfill';
import Player from "../src/Player.js";
var assert = require('chai').assert;
var expect = require('chai').expect;

//unit Test for Player Creation 
describe('Player_Unit_Test', function () {
    it('Instatiate Player Object', function (done) {
        var player = new Player();
        assert.typeOf(player , Player);
    
        done();
    });
    it('Player starts at position 0 on the Board',function(done){
        var player = new Player();
        assert.typeOf(player, Player); //assert player is a type of player 
        // player starts at position zero 
        player.rollDice();
        done();

        
    })
});