package ax.ha.it.fragmentsdemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Advice.class, Category.class}, version = 1, exportSchema = false)
public abstract class AdviceDatabase extends RoomDatabase {

    private static volatile AdviceDatabase dbInstance;
    private final static String SHARES_DB_NAME = "advice_db";

    public static AdviceDatabase getInstance(Context context) {

        if (dbInstance ==  null) {
            synchronized (AdviceDatabase.class) {
                if (dbInstance == null) {
                    dbInstance = Room.databaseBuilder(context.getApplicationContext(), AdviceDatabase.class, SHARES_DB_NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return dbInstance;
    }

    public abstract AdviceDao adviceDao();
    public abstract CategoryDao categoryDao();

}