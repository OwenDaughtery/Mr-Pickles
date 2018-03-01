
import api from '../API';

export default class ViewModel {
    constructor() {
        this._component = null;
        this._componentType = "#Unknown#";
    }

    _componentCheck() {
        if (this._component === null) {
            api.error(this._componentType + " component not assigned.");
            return true;
        }
        return false;
    }

    set parentComponent (component) {
        this._component = component;
    }
}