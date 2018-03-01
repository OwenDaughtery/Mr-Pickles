var allPotLuckCards = [];
var allOpportunityCards = [];

for (i = 0; i < 5; i++) {
	var card = new Card(i, 'blah ' + i.toString(), "null");
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
  this.back = 0;
  this.front = 0;
  this.currentLength = 0;
  
	this.print = function() {
		console.log(this);
		console.log("");
	};

	this.populate = function() {
		if (this.type == 'PotLuck') {
			for (i = 0; i < allPotLuckCards.length; i++) {
				this.contents[this.back]=(allPotLuckCards[i]);
				this.back = this.back +1;
			}
		} else if (this.type == 'OppKnocks') {
			for (i = 0; i < allOpportunityCards.length; i++) {
				this.contents[this.back]=(allOpportunityCards[i]);
				this.back = this.back +1;
			}
		}
		this.currentLength = this.back;
	};

  //obsulete due to array now being queue that can have things removed
	this.shuffle = function() {
		var j, x, i;
		for (i = this.currentLength - 1; i > 0; i--) {
			j = Math.floor(Math.random() * (i + 1));
			x = this.contents[i];
			this.contents[i] = this.contents[j];
			this.contents[j] = x;
		}
	};
	
  this.enqueue = function(card){
    card.ownedBy = null;
    this.contents[this.back]=(card);
	  this.back = this.back +1;
	  this.currentLength+=1;
	  this.back=this.back%this.currentLength;
  }	
  
  this.dequeue = function(player){
    this.card = this.contents[this.front];
    this.card.ownedBy = player;
    this.contents[this.front] = null;
    this.front+=1;
    this.currentLength-=1
    this.front=this.front%this.currentLength;
    return this.card;
  }

	this.populate();
	this.shuffle();
}

function Card(ID, desc, ownedBy) {
	this.ID = ID;
	this.desc = desc;
	this.ownedBy = ownedBy;
	this.print = function() {
		console.log(this.desc);
		console.log("");
	};
}

var potLuckDeck = new Deck('PotLuck');
var opportunityKnocks = new Deck('OppKnocks');
potLuckDeck.print();

var cardTest = potLuckDeck.dequeue(1);
cardTest.print();
potLuckDeck.print();

var cardTest2 = potLuckDeck.dequeue(2);
cardTest2.print();
potLuckDeck.print();

potLuckDeck.enqueue(cardTest);
potLuckDeck.print();


//console.log('');
//opportunityKnocks.print();
