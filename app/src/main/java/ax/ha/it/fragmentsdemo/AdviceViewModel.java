package ax.ha.it.fragmentsdemo;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class AdviceViewModel extends AndroidViewModel {

    private final MutableLiveData<List<Advice>> advices;
    private final MutableLiveData<List<Category>> categories;
    private final NiksiPirkkaApi api;
    public AdviceViewModel(Application application) {
        super(application);
        this.api = new NiksiPirkkaApi(
                AdviceDatabase.getInstance(application.getApplicationContext()).adviceDao(),
                AdviceDatabase.getInstance(application.getApplicationContext()).categoryDao());
        categories = new MutableLiveData<>();
        advices = new MutableLiveData<>();
        advices.setValue(api.advices);
        categories.setValue(api.categories);
    }
    protected LiveData<List<Advice>> getAdvices() {
        return advices;
    }
    protected LiveData<List<Category>> getCategories() {
        return categories;
    }

    protected void addCategory(Category category) {
        List<Category> categoriesList = categories.getValue();
        if (categoriesList != null) {
            categoriesList.add(category);
        }
        api.insertCategory(category);
    }

    protected void addString(Advice advice) {
        List<Advice> advicesList = advices.getValue();
        if (advicesList != null) {
            advicesList.add(advice);
        }
        api.insertAdvice(advice);
    }
}
