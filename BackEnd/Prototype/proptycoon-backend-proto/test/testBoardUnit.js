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
    it('After instantiation the number of Spaces on the Board is 40', function (done){
        var board = new Board();
        expect(board.spaces.length).eq(41); // Board has 41 squares , Just visiting is a square 
        done();
    })
});

