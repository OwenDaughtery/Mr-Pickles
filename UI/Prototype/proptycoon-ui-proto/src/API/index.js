
import playerLegendModel from '../Components/Game/Components/PlayerLegend/model.js';
import { primaryDieModel, secondaryDieModel } from '../Components/Game/Components/Board/Components/Dice/Components/Die/model.js';

class API {
    /*_postApiCall() {
        game.onApiCall();
    }*/

    startGame(numberOfPlayers, dieValues) {
        playerLegendModel.numberOfPlayers = numberOfPlayers;
        primaryDieModel.dieValue = dieValues.primary;
        secondaryDieModel.dieValue = dieValues.secondary;
    }

    error(message) {
        console.log("PropertyTycoon UI error: " + message);
    }
}

let api = new API(); 
export default api;