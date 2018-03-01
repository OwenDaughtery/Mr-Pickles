// testing suite for Class Board 
'use strict';
import 'babel-polyfill';
import Dice from "../src/Dice.js";

describe('addition', function () {
    it('should add 1+1 correctly', function (done) {
      var onePlusOne = 1 + 1;
      onePlusOne.should.equal(2);
      // must call done() so that mocha know that we are... done.
      // Useful for async tests.
      done();
    });
  });

  describe('first Test ',function(){
      it('should instantiate a dice correctly',function (done){
          let d = new Dice();

      })
  })

