package com.example.mymvvmnewstrail.api.api.initializing;

import com.example.mymvvmnewstrail.api.api.responseOfCurrentWeather.CurrentweatherByLocation;
import com.example.mymvvmnewstrail.api.api.foreCastResponse.ForeCast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

 public interface WebServices {




    @GET("weather")
    public  abstract Call<CurrentweatherByLocation> getCurrentLocation(
           @Query("lat") double lat  ,
           @Query("lon") double lon ,
            @Query("APPID") String apikey);


     @GET("forecast")
     public  abstract Call<ForeCast> getForeCast(
             @Query("lat") float lat  ,
             @Query("lon") float lon ,
             @Query("APPID") String apikey);











}
