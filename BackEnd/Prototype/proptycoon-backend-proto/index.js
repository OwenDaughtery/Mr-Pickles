import Game from './src/Game.js';
import OpportunityKnocksDeck from './src/OpportunityKnocksDeck.js';
import PotLuckDeck from './src/PotLuckDeck.js';

var oppKnocksDeck = new OpportunityKnocksDeck();

oppKnocksDeck.populate()
.then(()=>{
    console.log(oppKnocksDeck);
});

var potLuckDeck = new PotLuckDeck();

potLuckDeck.populate()
.then(()=>{
  console.log(potLuckDeck);
})

var players = [["a",0],["b",2],["C",3],["D",4],["E",5]];
var game = new Game(players);

//console.log(game);