
import ViewModel from '../../../../ViewModel';
import api from '../../../../API';

class PlayerLegendModel extends ViewModel {
    set numberOfPlayers(playerCount) {
        if (this._component === null) {
            api.error("PlayerLegend component not assigned.");
            return;
        }
        this._component.numberOfPlayers = playerCount;
    }
}

let playerLegendModel = new PlayerLegendModel();
export default playerLegendModel;