
import ViewModel from '../../../../ViewModel';

class PlayerLegendModel extends ViewModel {
    constructor() {
        super();
        this._componentType = "PlayerLegend";
    }

    set numberOfPlayers(playerCount) {
        if (this._componentCheck()) return;
        this._component.numberOfPlayers = playerCount;
    }
}

let playerLegendModel = new PlayerLegendModel();
export default playerLegendModel;