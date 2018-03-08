// testing suite for Class Board 

'use strict';

require('babel-polyfill');

var _Board = require('../src/Board.js');

var _Board2 = _interopRequireDefault(_Board);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var assert = require('chai').assert;
var expect = require('chai').expect;

describe('Board_Test_Unit', function () {
    it('Instatiate Board Object', function (done) {
        var board = new _Board2.default();
        expect(new _Board2.default()).to.be.an.instanceof(_Board2.default);
        done();
    });
    it('After instantiation the number of Spaces on the Board is 40', function (done) {
        var board = new _Board2.default();
        expect(board.spaces.length).eq(41); // Board has 41 squares , Just visiting is a square 
        done();
    });
});