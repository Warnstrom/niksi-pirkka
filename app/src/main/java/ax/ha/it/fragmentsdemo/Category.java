package ax.ha.it.fragmentsdemo;

import androidx.annotation.NonNull;
import androidx.room.*;

@Entity(tableName = "categories")
public class Category {

    @NonNull
    protected String category;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_id")
    protected int categoryId = 0;

    Category(@NonNull String category) {
        this.category = category;
    }

    public void setCategory(@NonNull String category) {
        this.category = category;
    }

    @NonNull
    public String getCategory() {
        return this.category;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

}