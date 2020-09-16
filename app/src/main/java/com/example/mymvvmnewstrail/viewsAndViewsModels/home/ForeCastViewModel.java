package com.example.mymvvmnewstrail.viewsAndViewsModels.home;

import android.content.res.AssetManager;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymvvmnewstrail.adapters.RecyclerDaysModel;
import com.example.mymvvmnewstrail.api.api.initializing.ApiManager;
import com.example.mymvvmnewstrail.api.api.foreCastResponse.ForeCast;
import com.example.mymvvmnewstrail.api.api.foreCastResponse.ListItem;
import com.example.mymvvmnewstrail.utils.Common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForeCastViewModel extends ViewModel {


    public MutableLiveData<List<ListItem>> listOf_AllForecast = new MutableLiveData<>();
    public MutableLiveData<List<RecyclerDaysModel>> allDays = new MutableLiveData<>();

    public MutableLiveData<String> failmessage= new MutableLiveData<>();

     ListItem model = new ListItem() ;
     List<ListItem> foreCast = new ArrayList<>();
     List<RecyclerDaysModel> days = new ArrayList<>();


    public void getForeCastingDays(float lat , float lon){

       ApiManager.getApis().getForeCast( lat , lon , Common.API_Key)
                .enqueue(new Callback<ForeCast>() {
                    @Override
                    public void onResponse(Call<ForeCast> call,
                                           Response<ForeCast> response) {

                       // foreCast = (response.body().getList());
                       // model=response.body().getList().get(0);
                        //days =getListOfDays(model);

                        //will replace it with function
                        listOf_AllForecast.setValue(response.body().getList());
                        allDays.setValue(getListOfDays(response.body().getList().get(0)));
                        failmessage.setValue("دخل");
                    }

                    @Override
                    public void onFailure(Call<ForeCast> call, Throwable t) {
                        failmessage.setValue(t.getLocalizedMessage());

                    }
                });

    }



















     private void setValueOfLiveData(){
        listOf_AllForecast.setValue(foreCast);
        allDays.setValue(getListOfDays(model));

     }



// complete Dte AndTime
   private String[] getDateAndTime(String dt_xt){
        String[] parts = dt_xt.split(" ");
       String date = dt_xt.substring(0, dt_xt.indexOf(' ')) ;
        String time = dt_xt.substring(dt_xt.indexOf(' ') + 1);

        return  parts ;
    }




   private List<RecyclerDaysModel> getListOfDays(ListItem modelClass
                                                         ){
      String date = modelClass.getDtTxt();//2020-04-08
      String dayofdate = getDayMonthYear(date)[2];//08
       String dayName = getDayName(date);//monday
       int dayNumber = Integer.parseInt(dayofdate); //int 8
       List<RecyclerDaysModel> list = new ArrayList<>();
       String month_date = getDayMonthYear(date)[1];
       String year_date = getDayMonthYear(date)[0];

       for(int i = dayNumber; i <=dayNumber+4 ; i++) {
           int day = i ;
           String lastdate = String.valueOf(day);
           String dd= year_date+"-"+month_date+"-"+lastdate;
           RecyclerDaysModel model = new RecyclerDaysModel();
           model.setDate(dd);
           model.setDayName(getDayName(dd));
           list.add(model);

       }




         return  list ;
   }

// date and time as aparamter
public  String[] getDayMonthYear(String date){
     String[] seperated = date.split(" ");
     String dt = seperated[0];
     String [] dateParts = dt.split("-");
       //String day = dateParts[0];
      // String month = dateParts[1];
      // String year = dateParts[2];

       return dateParts;

   }
//شغاله date and time
   private static String getDayName( String dt_xt){

        String dayOfWeek ;
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dt_xt);
            // Then get the day of week from the Date based on specific locale.
           dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);

        } catch (ParseException e) {
           dayOfWeek=e.toString();
        }



        return  dayOfWeek ;

    }


   private List<RecyclerDaysModel> getAllTempratures(List<RecyclerDaysModel> list){
        List<RecyclerDaysModel> daysModelList = list;
         int k = -1;
        for (int i = 0; i < listOf_AllForecast.getValue().size(); i=+7) {

            double temp = Common.convertTempreture(
                    listOf_AllForecast.getValue().get(i).getMain().getTemp());

            k++ ;
            daysModelList.get(k).setTemprature(temp+"clz");
            daysModelList.get(k).setId(listOf_AllForecast.getValue().get(k).getDt()+"");

        }
       return  daysModelList ;
    }



    public static void main(String[] args) {



    }




}
