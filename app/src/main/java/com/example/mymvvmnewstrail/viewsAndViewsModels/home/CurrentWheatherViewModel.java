package com.example.mymvvmnewstrail.viewsAndViewsModels.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymvvmnewstrail.api.api.initializing.ApiManager;
import com.example.mymvvmnewstrail.api.api.responseOfCurrentWeather.CurrentweatherByLocation;
import com.example.mymvvmnewstrail.utils.Common;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentWheatherViewModel extends ViewModel {

    //variables for current wheather

    public MutableLiveData<String> cityName  = new MutableLiveData<>("");
    public MutableLiveData<String> description = new MutableLiveData<>("");
    public MutableLiveData<String> wind  = new MutableLiveData<>();
    public MutableLiveData<String> humidity  = new MutableLiveData<>();
    public MutableLiveData<String> pressure = new MutableLiveData<>();
    public MutableLiveData<String> temprature = new MutableLiveData<>();
    public MutableLiveData<String> failMessage = new MutableLiveData<>();


    //=====================================




    public CurrentWheatherViewModel() {
    }

    public void getCurrentWeatherByLocation(double lat , double lon){

        ApiManager.getApis().getCurrentLocation(lat , lon , Common.API_Key)
                .enqueue(
                        new Callback<CurrentweatherByLocation>() {
                            @Override
                            public void onResponse(Call<CurrentweatherByLocation> call
                                    , Response<CurrentweatherByLocation> response) {
                                if(response.body().getName()!=null){

                                   // 200==(response.body().getCod())

                                    cityName.setValue(response.body().getName());
                                    description.setValue(response.body().getWeather()
                                            .get(0).getDescription());
                                    wind.setValue(response.body().getWind().getSpeed()+"%");
                                    humidity.setValue(response.body().getMain().getHumidity()+"%");
                                    pressure.setValue(response.body().getMain().getPressure()+"mm Hg");
                                    temprature.setValue(Common.convertTempreture(response.body()
                                            .getMain().getTemp())+"Clz");


                                }else {
                                    failMessage.setValue("دخل ال ؤيسبونس بس مانجحش");
                                }
                            }

                            @Override
                            public void onFailure(Call<CurrentweatherByLocation> call, Throwable t) {

                                failMessage.setValue(t.getLocalizedMessage());
                            }
                        }
                );





    }












}
