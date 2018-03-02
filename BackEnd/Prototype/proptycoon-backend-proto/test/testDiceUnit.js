'use strict';
import 'babel-polyfill';
import Dice from "../src/Dice.js";
var assert = require('chai').assert;
var expect = require('chai').expect;



describe('Dice_Tests_Unit ', function () {
    it('Instantiate Dice Object', function (done) {
        var d = new Dice();
        expect(new Dice()).to.be.an.instanceof(Dice);
       

        done();
    });
    
});