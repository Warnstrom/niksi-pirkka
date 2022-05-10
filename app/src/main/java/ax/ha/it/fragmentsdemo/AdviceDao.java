package ax.ha.it.fragmentsdemo;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface AdviceDao {

    @Insert
    void insert(Advice... advices);

    @Update
    void update(Advice... advices);

    @Query("DELETE FROM advices")
    void deleteAllAdvices();

    @Query("SELECT * FROM advices")
    List<Advice> getAllAdvices();

}
