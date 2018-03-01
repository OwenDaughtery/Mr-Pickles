import Bank from './Bank.js';
import Players from './Players.js';
//importFreeParking

export default class Actions {
    constructor(_bank,_freeParking, _players) {
        this.bank = _bank;
        this.freeParking = _freeParking;
    }

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

    changeOwner(_p1,_p2,_estate){
        //assert _p1.realEstate.contains(_estate)
        _p2.realEstate.push(_p1.realEstate.remove(indexOf(_estate)));
    }
}