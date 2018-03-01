/**
 * 2 fair Die which can be roled
 */
export default class Dice {

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