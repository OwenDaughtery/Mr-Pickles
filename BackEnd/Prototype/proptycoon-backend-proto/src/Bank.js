
export default class Bank {
    constructor(_players) {
        this.balanceOf = new Map();
        for (var i = 0; i < _players.length; i++) {
            this.balanceOf.set(_players[i][1], 1500);
        }
        this.balance = 50000;

        this.potLuckDeck = new Deck('PotLuck');
        this.oppKnocks = new Deck('OppKnocks');


        this.realEstate = new RealEstate();
    }

    
    updateBankBalance(_value) {
        //assert(this.balance + _value >= 0)
        this.balance = this.balance + _value;
    }

    updatePlayerBalance(_player, _value){
        //assert(_value + this.balanceOf(_player.playerNumber) >= 0)
        this.balanceOf.set(_player.playerNumber, _value + this.balanceOf(_player.playerNumber))
    }

}