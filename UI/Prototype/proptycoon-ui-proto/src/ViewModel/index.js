
import common from '../Common';

export default class ViewModel {
    constructor() {
        this._component = null;
        this._componentType = "#Unknown#";
    }

    _componentCheck() {
        if (this._component === null) {
            common.error(this._componentType + " component not assigned.");
            return true;
        }
        return false;
    }

    set parentComponent (component) {
        this._component = component;
    }
}