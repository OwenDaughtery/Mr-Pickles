
import ViewModel from '../../../../../../ViewModel';

class CellModel extends ViewModel {
    constructor() {
        super();
        this._componentType = "Cell";
    }

    set name(name) {
        if (this._componentCheck()) return;
        this._component.name = name;
    }

    //Player []:
    // - index
    set players(players) {
        if (this._componentCheck()) return;
        this._component.players = players;
    }
}

let cellModels = [];
for (var i=0; i<40; i++) {
    cellModels[i] = new CellModel();
}
export default cellModels;