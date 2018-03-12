
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
     * Initialises board, dice, and players.
     * PlayerInfo object:
     *  - name : string
     *  - index : integer
     * @param {Object} playerInfoList - An array of objects containing player name & player index. (Index will correspond to a character).
     */
    constructor(playerInfoList) {
        this.board = new Board();
        this.dice = new Dice();
        this.players = [];
        this.playerTurn = 0; //Number relative to position of player in array.
        //Adds players to player array.
        for(var playerInfo of playerInfoList) {
            this.players.push(new Player(playerInfo.name, playerInfo.index, this.dice));
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

