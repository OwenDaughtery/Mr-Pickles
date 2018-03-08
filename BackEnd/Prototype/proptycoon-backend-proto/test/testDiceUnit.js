'use strict';
import 'babel-polyfill';
import Dice from "../src/Dice.js";
var assert = require('chai').assert;
var expect = require('chai').expect;



describe('Dice_Tests_Unit ', function () {
    it('Instantiate Dice Object', function (done) {
        var d = new Dice();
        assert(new Dice() instanceof Dice);
       

        done();
    },
    it('Dice_Func_get numbers()_Test', function(done) {
        var d = new Dice(); 
        //first check that when we get numbers after instantiation that they are both 0
        d.getnumbers();
        
        expect(d.die1).to.equal(0);
        expect(d.die2).to.equal(0);
        assert(d.die1 == 0);
        assert(d.die2 == 0);
        done();
    }),
    //function checks gennumber results != 0 
    it('Dice_Func_gennumbers()_Test', function(done){
        var d = new Dice();
        d.getnumbers();
        expect(d.die1 == 0);
        expect(d.die2 == 0);
        assert(d.die1 == 0);
        assert(d.die2 == 0);
        //roll dice
        d.rollDice();

        expect(d.die1 != 0);
        expect(d.die2 != 0);

        assert(d.die1 != 0);
        assert(d.die2 != 0);
        assert(d.die1 < 7);
        assert(d.die2 < 7);
        
        done();
    }),
    
    
)});