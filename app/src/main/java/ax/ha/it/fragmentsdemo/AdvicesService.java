package ax.ha.it.fragmentsdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AdvicesService {
    @GET("/getadvice")
    Call<List<Advice>> getAllAdvices();
}
