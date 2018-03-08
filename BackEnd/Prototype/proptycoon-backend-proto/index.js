import Game from './src/Game.js';
import OpportunityKnocksDeck from './src/OpportunityKnocksDeck.js';

var deck = new OpportunityKnocksDeck();

deck.populate()
.then(()=>{
    console.log(deck);
})

var players = [["a",0],["b",2],["C",3],["D",4],["E",5]];
var game = new Game(players);

//console.log(game);