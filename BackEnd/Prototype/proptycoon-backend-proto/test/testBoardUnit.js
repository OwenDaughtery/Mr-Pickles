// testing suite for Class Board 

'use strict';
import 'babel-polyfill';
import Board from "../src/Board.js";
var assert = require('chai').assert;
var expect = require('chai').expect;

describe('Board_Test_Unit', function () {
    it('Instatiate Board Object', function (done) {
        var board = new Board();
        expect(new Board()).to.be.an.instanceof(Board);
        done();
    });
});

