"use strict";

Object.defineProperty(exports, "__esModule", {
    value: true
});

var _Space = require("./Space.js");

var _Space2 = _interopRequireDefault(_Space);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

/** 
 * @author Ayman Zenos
 * The board of the game which holds spaces in an array between 0 to 40, where 40 will be Jail.
*/
var Board = function Board() {
    _classCallCheck(this, Board);

    this.spaces = [];
    for (var i = 0; i <= 40; i++) {
        this.spaces.push(new _Space2.default("Im a space!"));
    }
};

exports.default = Board;