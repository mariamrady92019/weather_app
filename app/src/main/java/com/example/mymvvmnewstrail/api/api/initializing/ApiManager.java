package com.example.mymvvmnewstrail.api.api.initializing;



import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {


     public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/" ;
    public static Retrofit retrofit;

    private static Retrofit getInstance(){

        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }



    public static WebServices getApis(){

        return getInstance().create(WebServices.class);
    }



}
