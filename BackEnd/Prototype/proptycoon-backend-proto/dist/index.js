'use strict';

var _Game = require('./src/Game.js');

var _Game2 = _interopRequireDefault(_Game);

var _OpportunityKnocksDeck = require('./src/OpportunityKnocksDeck.js');

var _OpportunityKnocksDeck2 = _interopRequireDefault(_OpportunityKnocksDeck);

var _PotLuckDeck = require('./src/PotLuckDeck.js');

var _PotLuckDeck2 = _interopRequireDefault(_PotLuckDeck);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var oppKnocksDeck = new _OpportunityKnocksDeck2.default();

oppKnocksDeck.populate().then(function () {
  console.log(oppKnocksDeck);
});

var potLuckDeck = new _PotLuckDeck2.default();

potLuckDeck.populate().then(function () {
  console.log(potLuckDeck);
});

var players = [["a", 0], ["b", 2], ["C", 3], ["D", 4], ["E", 5]];
var game = new _Game2.default(players);

//console.log(game);