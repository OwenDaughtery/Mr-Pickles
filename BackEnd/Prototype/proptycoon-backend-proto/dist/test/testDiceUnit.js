'use strict';

require('babel-polyfill');

var _Dice = require('../src/Dice.js');

var _Dice2 = _interopRequireDefault(_Dice);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var assert = require('chai').assert;
var expect = require('chai').expect;

describe('Dice_Tests_Unit ', function () {
    it('Instantiate Dice Object', function (done) {
        var d = new _Dice2.default();
        assert(new _Dice2.default() instanceof _Dice2.default);

        done();
    }, it('Dice_Func_get numbers()_Test', function (done) {
        var d = new _Dice2.default();
        //first check that when we get numbers after instantiation that they are both 0
        d.getnumbers();

        expect(d.die1).to.equal(0);
        expect(d.die2).to.equal(0);
        assert(d.die1 == 0);
        assert(d.die2 == 0);
        done();
    }),
    //function checks gennumber results != 0 
    it('Dice_Func_gennumbers()_Test', function (done) {
        var d = new _Dice2.default();
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
    }));
});