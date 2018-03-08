// testing suite for Class Board 
'use strict';

require('babel-polyfill');

var _Dice = require('../src/Dice.js');

var _Dice2 = _interopRequireDefault(_Dice);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

describe('addition', function () {
    it('should add 1+1 correctly', function (done) {
        var onePlusOne = 1 + 1;
        onePlusOne.should.equal(2);
        // must call done() so that mocha know that we are... done.
        // Useful for async tests.
        done();
    });
});

describe('first Test ', function () {
    it('should instantiate a dice correctly', function (done) {
        var d = new _Dice2.default();
    });
});