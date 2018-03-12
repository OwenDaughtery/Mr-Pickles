/**
 * @author Ayman Zenos
 * 
 * A player which can move around the board and role dice and own real estate and wild cards.
 */
export default class Player {
    constructor(_name, _playerNumber, _dice) {
        //assert(_playerNumber > 0 && _playerNumber < 7);
        this.isInPrison = false;
        this.turnsInPrison = 0;
        this.position = 0;
        this.doublesRolled = 0;
        this.name = _name;
        this.playerNumber = _playerNumber;
        this.dice = _dice;

        this.potLuckDeck = [];
        this.oppKnocks = [];

        this.realEstate = [];
    }

    /** 
     * rolls the dice and moved that amount round the board. If double roll again.
     * TODO if 3 doubles go to prison.
    */
    rollDice() {
        var positions = this.dice.rollDice()
        if(this.position[0] == this.position[1]){
            this.doublesRolled +=1;
        } else {
            this.doublesRolled = 0;
        }
        if(this.doublesRolled == 3){
            this.position = 40;
        } else {
            this.move(positions[0] + positions[1]);
        }
    }

    /**
     * Moves player to position on board.
     * @param {int} _positions number reletive to position on the board
     */
    move(_positions) {
        var newPos = this.position + positions % 40;
        if (newPos < this.position){
            if(_positions > 0){
                //give £200
            }
        }
        this.position = newPos;
    }

    //TODO and methods to change in prison boolion, turns in prison, doubles roled
}