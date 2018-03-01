var allPotLuckCards = [];
var allOpportunityCards = [];

for (i = 0; i < 5; i++) {
	var card = new Card(i, 'blah ' + i.toString());
	this.allPotLuckCards.push(this.card);
	this.allOpportunityCards.push(this.card);
}

/**
 * Function used to represent the Deck class
 * @param {string} typeOfDeck should be either PotLuck or OpportunityKnocks, used to state whether the deck should be a potLock or OpportunityKnocks deck
 */
function Deck(typeOfDeck) {
	this.type = typeOfDeck;
	this.contents = [];

	this.print = function() {
		console.log(this);
	};

	this.populate = function() {
		if (this.type == 'PotLuck') {
			for (i = 0; i < allPotLuckCards.length; i++) {
				this.contents.push(allPotLuckCards[i]);
			}
		} else if (this.type == 'OppKnocks') {
			for (i = 0; i < allOpportunityCards.length; i++) {
				this.contents.push(allOpportunityCards[i]);
			}
		}
	};

	this.shuffle = function() {
		var j, x, i;
		for (i = this.contents.length - 1; i > 0; i--) {
			j = Math.floor(Math.random() * (i + 1));
			x = this.contents[i];
			this.contents[i] = this.contents[j];
			this.contents[j] = x;
		}
	};

	this.populate();
	this.shuffle();
}

function Card(ID, desc) {
	this.ID = ID;
	this.desc = desc;
	this.print = function() {
		console.log(this.desc);
	};
}

var potLuckDeck = new Deck('PotLuck');
var opportunityKnocks = new Deck('OppKnocks');
potLuckDeck.print();


//console.log('');
//opportunityKnocks.print();
