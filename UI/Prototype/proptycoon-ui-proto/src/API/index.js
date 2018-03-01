
import playerLegendModel from '../Components/Game/Components/PlayerLegend/model.js';
import { primaryDieModel, secondaryDieModel } from '../Components/Game/Components/Board/Components/Dice/Components/Die/model.js';

class API {
    /*_postApiCall() {
        game.onApiCall();
    }*/

    startGame(numberOfPlayers, diceValues) {
        playerLegendModel.numberOfPlayers = numberOfPlayers;
        primaryDieModel.dieValue = diceValues.primary;
        secondaryDieModel.dieValue = diceValues.secondary;
    }

    

    error(message) {
        console.log("PropertyTycoon UI error: " + message);
    }
}

let api = new API(); 
export default api;