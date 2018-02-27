import Player from '../Models/Game/Models/Player';

class API {
    /*_postApiCall() {
        game.onApiCall();
    }*/

    startGame(numberOfPlayers) {
        for(var i=0; i<numberOfPlayers; i++) 
            game.players.push(new Player)
        //this._postApiCall();
    }

    error(message) {
        console.log("PropertyTycoon UI error: " + message);
    }
}

export let api = new API(); 