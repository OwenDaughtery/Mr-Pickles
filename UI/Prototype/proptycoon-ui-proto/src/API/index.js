
/**
 * Handles interaction from UI to back-end.
 * Mostly consists of asynchronous calls. 
 */
class API {
    /**
     * Logs a message, but with a prefix to make sure message can
     * be identified as belonging to PropertyTycoon.
     * @param {string} msg - Message to log.
     */
    log(msg) {
        console.log("PropTycoon: " + msg);
    }

    /**
     * Logs an error message, but with a prefix to make sure message can
     * be identified as belonging to PropertyTycoon.
     * @param {string} msg - Message to log.
     */
    error(msg) {
        console.error("PropTycoon: " + msg);
    }

    /**
     * Send array of player names for the upcoming game to back-end.
     * Response will be the same list of names, but validated.
     * @param {Array<string>} playerNames - Provisional names of game players.
     * @returns {Promise}
     */
    intialisePlayers(playerNames) {
        //Will return player names.
        return new Promise(
            (resolve) => {
                //TODO replace 'playerNames' with some getter
                //from the back-end.
                //TODO remove timeout (it's onlu for emulation.)
                setTimeout(() => 
                    {
                        resolve(playerNames);
                    }, 5000
                );
            }
        );
    }
}

let api = new API(); 
export default api;