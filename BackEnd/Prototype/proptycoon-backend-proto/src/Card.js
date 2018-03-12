export default class Card {

    /**
     * Constructs a Card object which the arguments passed through will be initialized based on
     * the input data from the .csv files.
     * 
     * @param {*} _description The description on the card
     * @param {*} _action Type of action to be performed, i.e. GAIN, MOVE, PAY
     * @param {*} _value  An integer associated with the action, i.e. GAIN 50, MOVE 3, PAY 200. Can also be CALCULATE.
     */
    constructor(_description, _action, _value) {
        //this.ID = _ID;
        this.description = _description;
        this.action = _action;
        this.value = _value;
    }
}