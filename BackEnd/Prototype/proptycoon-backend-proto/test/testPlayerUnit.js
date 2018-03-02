'use strict';
import 'babel-polyfill';
import Player from "../src/Player.js";
var assert = require('chai').assert;
var expect = require('chai').expect;

//unit Test for Player Creation 
describe('Player_Unit_Test', function () {
    it('Instatiate Player Object', function (done) {
        var player = new Player();
        expect(new Player()).to.be.an.instanceof(Player);
       
        done();
    });
});