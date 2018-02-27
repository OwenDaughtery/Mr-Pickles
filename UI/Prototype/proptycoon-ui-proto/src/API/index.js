
import playerLegendModel from '../Components/Game/Components/PlayerLegend/model.js';

class API {
    /*_postApiCall() {
        game.onApiCall();
    }*/

    startGame(numberOfPlayers) {
        playerLegendModel.numberOfPlayers = numberOfPlayers;
    }

    error(message) {
        console.log("PropertyTycoon UI error: " + message);
    }
}

export let api = new API(); 