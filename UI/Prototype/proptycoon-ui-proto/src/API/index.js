import backEndApi from '../BackEnd/API';

/**
 * Handles interaction from UI to back-end.
 * Mostly consists of asynchronous calls. 
 */
class API {
    /**
     * Logs a message, but with a prefix to make sure message can
     * be identified as belonging to PropertyTycoon UI.s
     * @param {string} msg - Message to log.
     */
    log(msg) {
        console.log("PropTycoon UI: " + msg);
    }

    /**
     * Logs an error message, but with a prefix to make sure message can
     * be identified as belonging to PropertyTycoon UI.
     * @param {string} msg - Message to log.
     */
    error(msg) {
        console.error("PropTycoon UI: " + msg);
    }

    /**
     * Send array of player names for the upcoming game to back-end.
     * Response will be the same list of names, but validated.
     * @param {Array<string>} playerNames - Provisional names of game players.
     * @returns {Promise}
     */
    intialisePlayers(playerNames) {
        //Will respond with player names.
        return new Promise(
            (resolve) => {
                //Link to back-end's API call.
                resolve(backEndApi.initialisePlayers(playerNames));
            }
        );
    }

    /** 
     * Make request to get array of objects containing players' positions.
     * @returns {Promise}
     * //TODO add more state values. 
     */
    get playerStates() {
        //Will respond with player states.
        return new Promise(
            (resolve) => {
                //Get player states from back-end.
                resolve(backEndApi.playerStates);
            }
        )
    }
}

let api = new API(); 
export default api;