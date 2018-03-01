"use strict";

Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var Player = function () {
    function Player(_name, _playerNumber, _dice) {
        _classCallCheck(this, Player);

        //assert(_playerNumber > 0 && _playerNumber < 7);
        this.isInPrizon = false;
        this.turnsInPrizon = 0;
        this.position = 0;
        this.doublesRolled = 0;
        this.name = _name;
        this.playerNumber = _playerNumber;
        this.dice = _dice;
    }

    _createClass(Player, [{
        key: "rollDice",
        value: function rollDice() {
            var positions = this.dice.rollDice();
            if (this.position[0] == this.position[1]) {
                this.doublesRolled += 1;
            } else {
                this.doublesRolled = 0;
            }
            if (this.doublesRolled == 3) {
                this.position = 40;
            } else {
                this.move(positions[0] + positions[1]);
            }
        }
    }, {
        key: "move",
        value: function move(_positions) {
            var newPos = this.position + positions % 40;
            if (newPos < this.position) {
                if (_positions > 0) {
                    //give £200
                }
            }
            this.position = newPos;
        }
    }]);

    return Player;
}();

exports.default = Player;