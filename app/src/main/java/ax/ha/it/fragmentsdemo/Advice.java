package ax.ha.it.fragmentsdemo;

import androidx.annotation.NonNull;
import androidx.room.*;

@Entity(tableName = "advices")
public class Advice {

    @NonNull
    protected String author;

    @NonNull
    protected String content;

    @NonNull
    protected String category;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "advice_id")
    protected int adviceId = 0;

    Advice(@NonNull String author, @NonNull String content, String category) {
        this.author = author;
        this.category = category;
        this.content = content;
    }

    public void setAuthor(@NonNull String author) {
        this.author = author;
    }

    public void setContent(@NonNull String content) {
        this.content = content;
    }

    public void setCategory(@NonNull String category) {
        this.category = category;
    }

    @NonNull
    public String getAuthor() {
        return this.author;
    }

    @NonNull
    public String getContent() {
        return this.content;
    }

    @NonNull
    public String getCategory() {
        return this.category;
    }

    @NonNull
    public int getAdviceId() {
        return this.adviceId;
    }

}