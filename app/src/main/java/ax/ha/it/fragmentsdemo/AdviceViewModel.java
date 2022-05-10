package ax.ha.it.fragmentsdemo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

public class AdviceViewModel extends ViewModel {

    private final MutableLiveData<List<Advice>> advices;

    public AdviceViewModel(SavedStateHandle savedStateHandle) {
        if (savedStateHandle.contains("advices")) {
            // Activity was restarted, fetch list from saved state
            // and wrap inside a MutableLiveData.
            // Note that we cannot store the actual LiveData object in the
            // saved state as this is not supported by Bundles.
            advices = savedStateHandle.getLiveData("advices");
        }
        else {
            // First start, initialize string list
            List<Advice> stringList = new ArrayList<>();
            advices = new MutableLiveData<>();
            advices.setValue(stringList);
            savedStateHandle.set("advices", stringList);
        }
    }
    public LiveData<List<Advice>> getAdvices() {
        return advices;
    }

    public void addString(Advice advice) {

        List<Advice> stringList = advices.getValue();
        if (stringList != null) {
            stringList.add(advice);
        }
        // Note: Only adding the String to the List will not notify observers.
        // We must also call setValue (or postValue if doing this update on a background thread)
        // to notify.
        advices.setValue(stringList);
    }
}
