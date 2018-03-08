import api from '../../API';

export default class GameController {
    constructor(parentComponent) {
        //Array of names of players in game.
        this._playerNames = [];
        //Reference to parent Game component.
        this._component = parentComponent;
    }

    //Update player names.
    //And update relevant views.
    _setPlayerNames(names) {
        this._playerNames = names;
        //TODO Update legend view with new names.
        //Tell component that number of players has changed.
        this._component.numberOfPlayers = this._playerNames.length;
    }

    //Start a new game.
    //Tell back-end to start a new game.
    //Handle response from back-end and funnel data into views.
    async start() {
        //TODO replace with names read from view.
        var newNames = [
            "Tom",
            "Ayman",
            "Max",
            "Owen",
            "Zenos"
        ];
        //Log API call about to be made.
        api.log("Initialising players: " + newNames);
        //Send player names to back-end.
        await api.intialisePlayers(newNames).then(
            //Handle reponse from back-end.
            (playerNames) => {
                //Set front-end model's player names
                //to equate the validated player names
                //given from the response.
                this._setPlayerNames(playerNames);
                //Log success.
                api.log("Players initialised: " + this._playerNames);
            }
        );
    }
}