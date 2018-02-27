
import Player from './Models/Player';
import Turn from './Models/Turn';
import Dice from './Models/Dice';


export default class Game {
    constructor(players, turn, dice)
    {
        //Array of players (2-6 members).
        this.players = players;
        this.turn = turn;
        this.dice = dice;
    }
}