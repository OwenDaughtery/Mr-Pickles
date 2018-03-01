import Space from './Space.js';

/** 
 * The board of the game which holds spaces in an array between 0 to 40, where 40 will be Jail.
*/
class Board {
    constructor() {
        this.spaces = [];
        for(var i = 0; i <= 40; i++) {
            spaces.push(new Space("Im a space!"))
        }
    }
}