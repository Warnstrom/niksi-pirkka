package ax.ha.it.fragmentsdemo;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CategoryDao {

    @Insert
    void insert(Category... categories);

    @Update
    void update(Category... categories);

    @Query("DELETE FROM categories")
    void deleteAllCategories();

    @Query("SELECT * FROM categories")
    List<Category> getAllCategories();

}
