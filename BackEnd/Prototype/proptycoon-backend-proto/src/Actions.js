import Bank from './Bank.js';
import Players from './Players.js';
//importFreeParking

/**
 * @author Ayman Zenos
 * 
 * Contains crutal events that will take place in many other classes.
 */
export default class Actions {
    constructor(_bank,_freeParking, _players) {
        this.bank = _bank;
        this.freeParking = _freeParking;
    }

    /**
     * Transers money between players, the bank and free parking.
     * @param {Player/Bank/FreeParking}_p1 the entity who is sending the money
     * @param {Player/Bank/FreeParking}_p2 the entity who is receving the money
     * @param {int}_p3 the amount of money that will be transferd 
     */
    moneyTransfer(_p1, _p2, _value) {
        if(_p1 instanceof Bank) {
            this.bank.updateBankBalance(-_value);
        } else if(p1 instanceof FreeParking) {
            this.freeParking.updateFreeParking(-_value);
        } else {
            this.bank.updatePlayerBalance(_p1, -_value);
        }

        if(_p2 instanceof Bank) {
            this.bank.updateBankBalance(_value);
        } else if(p2 instanceof FreeParking) {
            this.freeParking.updateFreeParking(_value);
        } else {
            this.bank.updatePlayerBalance(_p2, _value);
        }
    }

    /**
     * Transers property between players.
     * @param {Player/Bank/FreeParking}_p1 the entity who is sending the property
     * @param {Player/Bank/FreeParking}_p2 the entity who is receving the property
     * @param {int}_p3 the property that is being transfered.
     */
    changeOwner(_p1,_p2,_estate){
        //assert _p1.realEstate.contains(_estate)
        _p2.realEstate.push(_p1.realEstate.remove(indexOf(_estate)));
    }
}