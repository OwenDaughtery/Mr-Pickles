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
    }

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

    move(_positions) {
        var newPos = this.position + positions % 40;
        if (newPos < this.position){
            if(_positions > 0){
                //give £200
            }
        }
        this.position = newPos;
    }
}