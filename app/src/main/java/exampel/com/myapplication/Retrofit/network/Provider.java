package exampel.com.myapplication.Retrofit.network;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import exampel.com.myapplication.Retrofit.models.rModel;
import exampel.com.myapplication.Retrofit.utility.ClientConfigs;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Provider {

    private RetrofitService retrofitService;
    private Retrofit retrofit;
    public Provider(){

        OkHttpClient client=new OkHttpClient();
        Gson gson =new GsonBuilder().registerTypeAdapter(Date.class ,new UTCDateTypeAdapter()).create();

        retrofit= new Retrofit.Builder().baseUrl(ClientConfigs.REST_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        retrofitService=retrofit.create(RetrofitService.class);

    }

    public RetrofitService getRService(){
        return retrofitService;
    }
    public Retrofit getRetrofitClient(){
        return retrofit;
    }
}
