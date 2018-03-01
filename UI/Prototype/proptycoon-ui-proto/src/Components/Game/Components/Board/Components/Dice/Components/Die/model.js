
import ViewModel from '../../../../../../../../ViewModel';
import api from '../../../../../../../../API';

class DieModel extends ViewModel {
    set dieValue(value) {
        if (this._component === null) {
            api.error("Die component not assigned.");
            return;
        }
        this._component.value = value;
    }
}

export let primaryDieModel = new DieModel();
export let secondaryDieModel = new DieModel();

