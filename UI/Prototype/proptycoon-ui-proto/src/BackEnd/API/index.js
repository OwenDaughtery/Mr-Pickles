import Game from '../Game.js';

/**
 * Back-end API singleton.
 * Provides easy-to-use methods for instantialising and interacting
 * with the back-end code.
 */
class API {
    /**
     * Creates blank new game instance. 
     */
    constructor() {
        this._game = {};
    }

    /**
     * Initialises the players on the back-end, and in effect, creates a new game.
     * @param {Array<string>} playerNames - Names of players that will be in game.
     * @returns Array of (soon-to-be) verified & validated player names.
     */
    initialisePlayers(playerNames) {
        var playerTuples = [];
        for (var name of playerNames) {
            //_tuple[0] -> player name.
            //_tuple[1] -> player index.
            playerTuples.push([
                name,
                playerNames.indexOf(name)
            ]);
        }
        this._game = new Game(playerTuples);
        //TODO: verify and validate player names before returning.
        return playerNames;
    }

    /** 
     * @returns {Array<Object>} - Array of objects containing players' positions.
     * //TODO add more state values. 
     */
    get playerStates() {
        //Map inline function to game's player array.
        return this._game.players.map(
            //For each instance, extract player's name and return it.
            (player) => {
                return player.name;
            }
        );
    }
}

let api = new API();
export default api;