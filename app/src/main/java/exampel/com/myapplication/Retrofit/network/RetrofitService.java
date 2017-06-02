package exampel.com.myapplication.Retrofit.network;

import java.util.List;

import exampel.com.myapplication.Retrofit.models.rModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ali on 01/06/2017.
 */

public interface RetrofitService {

    //ex : @POST("name php server for send data")
    @POST("set_user")
    Call<rModel> send_service(@Body rModel rModel);

    @GET("get_all_news")
    Call<List<rModel>> get_data();



}
