
import ViewModel from '../../../../../../../../ViewModel';

class DieModel extends ViewModel {
    set dieValue(value) {
        if (this._componentCheck()) return;
        this._component.value = value;
    }
}

export let primaryDieModel = new DieModel();
export let secondaryDieModel = new DieModel();

