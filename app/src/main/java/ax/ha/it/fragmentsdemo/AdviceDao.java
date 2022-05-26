package ax.ha.it.fragmentsdemo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AdviceDao {

    @Insert
    void insert(Advice... advices);

    @Update
    void update(Advice... advices);

    @Query("DELETE FROM advice")
    void deleteAllAdvices();

    @Query("SELECT * FROM advice")
    List<Advice> getAllAdvices();

}
