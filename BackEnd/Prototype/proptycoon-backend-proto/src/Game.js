import Board from './Board.js';
import Dice from './Dice.js';
import Player from './Player.js';


/**
 * Creates a board, dice and all the players. The players are stored in an array.
 */
class Game {
    /**
     * @param {*} _Players is an array of tuples where the first space represents the name of the player and the second is the character that the player has chosen.
     */
    constructor(_players){
        this.board = new Board();
        this.dice = new Dice();
        this.players = [];
        this.playerTurn = 0;
        //Adds players to Players array.
        for(x = 0; x < _Players.length(); x++){
            this.players.push(new Player(_players[x][0], _players[x][1], this.dice))
        }
    }

    setTurn(_playerIndex) {
        assert(_playerIndex >= 0 && _playerIndex < this.players.length);
        this.playerTurn = _playerIndex;
    }

    newTurn() {
        this.playerTurn = this.playerTurn % this.players.length;
    }
 }

