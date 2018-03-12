import PotLuckDeck from "./PotLuckDeck.js";
import OpportunityKnocksDeck from "./OpportunityKnocksDeck.js";

/** 
 * @author Ayman Zenos
 * 
 * Stores money, the wild card decks and real estate.
*/
export default class Bank {
    /**
     * @param {*} _players The array of participating players.
     */
    constructor(_players) {
        //Creates a mapping between players name and there balance.
        this.balanceOf = new Map();
        for (var i = 0; i < _players.length; i++) {
            this.balanceOf.set(_players[i][1], 1500);
        }
        this.balance = 50000;

        this.potLuckDeck = new PotLuckDeck();
        this.oppKnocks = new OpportunityKnocksDeck();

        //this.realEstate = new RealEstate();
    }

    /**
     * updated bank balance.
     * @param {int}_value the change in value to be made in the bank
     */
    updateBankBalance(_value) {
        //assert(this.balance + _value >= 0)
        this.balance = this.balance + _value;
    }

    /**
     * 
     * @param {Player} _player 
     * @param {int} _value 
     */
    updatePlayerBalance(_player, _value){
        //assert(_value + this.balanceOf(_player.playerNumber) >= 0)
        this.balanceOf.set(_player.playerNumber, _value + this.balanceOf(_player.playerNumber))
    }

}
