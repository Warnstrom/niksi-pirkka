package ax.ha.it.fragmentsdemo;

import java.util.List;

class NiksiPirkkaApi {
    private final AdviceDao adviceDao;
    private final CategoryDao categoryDao;
    protected final List<Category> categories;
    protected final List<Advice> advices;
    protected NiksiPirkkaApi(AdviceDao adviceDao, CategoryDao categoryDao) {
        this.adviceDao = adviceDao;
        this.categoryDao = categoryDao;
        this.categories = categoryDao.getAllCategories();
        this.advices = adviceDao.getAllAdvices();
    }

    protected void insertAdvice(Advice advice) {
        adviceDao.insert(advice);
    }
    protected void deleteAllAdvices() {
        adviceDao.deleteAllAdvices();
    }

    protected void insertCategory(Category category) {
        categoryDao.insert(category);
    }
    protected void deleteAllCategories() {
        categoryDao.deleteAllCategories();
    }
}
