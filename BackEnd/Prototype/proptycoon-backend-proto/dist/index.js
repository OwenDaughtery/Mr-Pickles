'use strict';

var _Game = require('./src/Game.js');

var _Game2 = _interopRequireDefault(_Game);

var _OpportunityKnocksDeck = require('./src/OpportunityKnocksDeck.js');

var _OpportunityKnocksDeck2 = _interopRequireDefault(_OpportunityKnocksDeck);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var deck = new _OpportunityKnocksDeck2.default();

deck.populate().then(function () {
    console.log(deck);
});

var players = [["a", 0], ["b", 2], ["C", 3], ["D", 4], ["E", 5]];
var game = new _Game2.default(players);

//console.log(game);