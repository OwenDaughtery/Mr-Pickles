
import Board from './Board.js';
import Dice from './Dice.js';
import Player from './Player.js';


/**
 * @author Ayman Zenos
 * 
 * Creates a board, dice and all the players. The players are stored in an array.
 */
export default class Game {
    /**
     * @param {Player} _Players is an array of tuples where the first space represents the name of the player and the second is the character that the player has chosen.
     */
    constructor(_players){
        this.board = new Board();
        this.dice = new Dice();
        this.players = [];
        this.playerTurn = 0;//Number relative to position of player in array.
        //Adds players to Players array.
        for(var x = 0; x < _players.length; x++){
            this.players.push(new Player(_players[x][0], _players[x][1], this.dice))
        }
    }


    /**
     * Hard sets the players turn. Only done at begining of game acfter deciding who goes first.
     * @param {int} _playerIndex 
     */
    setTurn(_playerIndex) {
        //assert(_playerIndex >= 0 && _playerIndex < this.players.length);
        this.playerTurn = _playerIndex;
    }

    /**
     * Increments player turn.
     */
    newTurn() {
        this.playerTurn = this.playerTurn % this.players.length;
    }
 }

