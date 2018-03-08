'use strict';

require('babel-polyfill');

var _Space = require('../src/Space.js');

var _Space2 = _interopRequireDefault(_Space);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var assert = require('chai').assert;
var expect = require('chai').expect;

describe('Space_Unit_Test', function () {
    it('Instatiate Space Object', function (done) {
        var space = new _Space2.default();
        expect(new _Space2.default()).to.be.an.instanceof(_Space2.default);
        done();
    });
});