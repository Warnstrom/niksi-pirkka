package ax.ha.it.fragmentsdemo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Advice {
    @PrimaryKey(autoGenerate = true)
            int adviceId;
    String author;
    String content;
    String category;
    Advice(String author, String content, String category) {
        this.author = author;
        this.category = category;
        this.content = content;
    }
}
