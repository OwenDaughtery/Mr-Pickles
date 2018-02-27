
export default class ViewModel {
    constructor() {
        this._component = null;
    }

    set parentComponent (component) {
        this._component = component;
    }
}