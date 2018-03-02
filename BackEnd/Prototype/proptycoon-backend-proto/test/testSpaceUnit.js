'use strict';
import 'babel-polyfill';
import Space from "../src/Space.js";
var assert = require('chai').assert;
var expect = require('chai').expect;

describe('Space_Unit_Test', function () {
    it('Instatiate Space Object', function (done) {
        let space = new Space();
        expect(new Space()).to.be.an.instanceof(Space);
        done();
    });
});