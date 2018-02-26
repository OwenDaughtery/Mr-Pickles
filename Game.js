/**
 * 2 fair Die which can be roled
 */
class Dice {

    constructor() {
        this.die1 = 0;
        this.die2 = 0;
    }

    //returns numbers on dice
    get numbers() {
        return (this.die1, this.die2);
    }

    /**
     * @return random interger between 1-6
     */
    genNumber() {
        return Math.floor(Math.random() * 6) + 1;
    }

    /**
     * randomly changes numbers on dice and returns them as an array
     * 
     * @return array containing two integers representing new nubers on dice.
     */

    rollDice() {
        this.die1 = this.genNumber();
        this.die2 = this.genNumber();
        this.dice = [this.die1, this.die2];
        return this.dice;
    }
}


class Player {
    constructor(_name, _palyerNumber) {
        assert(_palyerNumber > 0 && _palyerNumber < 7);
        this.isPlayerTurn = false;
        this.isInPrizon = false;
        this.turnsInPrizon = 0;
        this.position = 0;
        this.doublesRolled = 0;
        this.name = _name;
        this.playerNumber = _palyerNumber;
    }

    rollDice() {
        assert(this.isPlayerTurn == true);
        // dice object will be rolled
        var positions = dice.rollDice()
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

/**
 * A space that represents a location on the board.
 */
class Space {

    /**
     * @param {*} _name represents the name of the space.
     */
    constructor(_name) {
        this.name = _name;
    }
}

/** 
 * The board of the game which holds spaces in an array between 0 to 40, where 40 will be Jail.
*/
class Board {
    constructor() {
        var spaces = [];
        for(var i = 0; i <= 40; i++) {
            spaces.push(new Space("Im a space!"))
        }
    }
}

/**
 * Creates a board, dice and all the players. The players are stored in an array.
 */
class Game {
    /**
     * 
     * @param {*} _Players is an array of tuples where the first space represents the name of the player and the second is the character that the player has chosen.
     */
    constructor(_Players){
        this.board = new Board();
        this.dice = new Dice();
        this.players = []
        //Adds players to Players array.
        for(x = 0; x < _Players.length(); x+1){
            this.players.push(new Player(_Players[x][0], _Players[x][1]))
        }
    }
}

