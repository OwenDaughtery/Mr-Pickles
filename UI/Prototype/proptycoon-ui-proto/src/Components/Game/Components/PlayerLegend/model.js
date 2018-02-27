
import { api } from '../../../../API';

class PlayerLegendModel {
    constructor () {
        this._component = null;
    }
    set parentComponent(component) {
        this._component = component;
    }
    set numberOfPlayers(playerCount) {
        if (this._component === null) 
            api.error("PlayerLegend component not assigned.");
        this._component.numberOfPlayers = playerCount;
    }
}

export let playerLegendModel = new PlayerLegendModel();