
export default class Turn {
    constructor(currentPlayerIndex=0, rolledDice=true, lastPlayerIndex=-1) {
        this.currentPlayerIndex = currentPlayerIndex;
        this.rolledDice = rolledDice;
        this.lastPlayerIndex = lastPlayerIndex;
    }
}