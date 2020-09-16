package com.example.mymvvmnewstrail.viewsAndViewsModels.home;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymvvmnewstrail.Base.BaseActivity;
import com.example.mymvvmnewstrail.R;
import com.example.mymvvmnewstrail.adapters.DaysRecyclerAdapter;
import com.example.mymvvmnewstrail.adapters.RecyclerDaysModel;
import com.example.mymvvmnewstrail.api.api.foreCastResponse.ListItem;
import com.example.mymvvmnewstrail.full_quran.Ayah;
import com.example.mymvvmnewstrail.full_quran.FullQuran;
import com.example.mymvvmnewstrail.full_quran.Surah;
import com.example.mymvvmnewstrail.model.Quran;
import com.example.mymvvmnewstrail.model.SurahsItem;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

public class HomePage extends BaseActivity {

    protected TextView cityName;
    protected TextView wheatherStatuse;
    protected TextView currentHumidity;
    protected TextView currentPressure;
    protected TextView currentWind;
    protected RecyclerView daysRecycler;
    DaysRecyclerAdapter adapter ;
    RecyclerView.LayoutManager layoutManager ;
     CurrentWheatherViewModel firstViewModel ;
     ForeCastViewModel secondViewModel ;
    String message = "" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home_page);

        firstViewModel =  new ViewModelProvider(this).get(CurrentWheatherViewModel.class);
        secondViewModel =  new ViewModelProvider(this).get(ForeCastViewModel.class);
        initView();
       // initRecyclerView();
     //  getData();
     // observeLiveData_FirstModel();
      //observeLiveData_secondModel();
       Surah list= getFullQuranSurahs().get(16);
       Ayah ayah= list.getAyahs().get(20);
        showMessage(ayah.getPage()+"/"+ayah.getJuz()+"/"+ayah.getHizbQuarter()+"","ok");
    }

    private void getData() {
        //initialize data in viewModel for first time once connect
        firstViewModel.getCurrentWeatherByLocation(30.19 ,31.14);
        secondViewModel.getForeCastingDays(30.19f, 31.14f);

    }

    private void observeLiveData_FirstModel() {
       firstViewModel.cityName.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                cityName.setText("<"+s+">");
            }
        });
        firstViewModel.description.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                wheatherStatuse.setText(s);
            }
        });

        firstViewModel.humidity.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                currentHumidity.setText(s);
            }
        });

        firstViewModel.pressure.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                currentPressure.setText(s);
            }
        });

        firstViewModel.wind.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                currentWind.setText(s);
            }
        });



        firstViewModel.failMessage.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
               // showMessage(s,"ok");
               Toast.makeText(HomePage.this,s,Toast.LENGTH_LONG).show();
            }
        });


    }

    private void observeLiveData_secondModel(){
        secondViewModel.listOf_AllForecast.observe(this, new Observer<List<ListItem>>() {
            @Override
            public void onChanged(List<ListItem> listItems) {

            }
        });

        secondViewModel.allDays.observe(this, new Observer<List<RecyclerDaysModel>>() {
            @Override
            public void onChanged(List<RecyclerDaysModel> list) {
                initRecyclerView(list);
            }
        });

        secondViewModel.failmessage.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
               //showMessage(s,"ok");
                message= s ;
                Toast.makeText(HomePage.this,s,Toast.LENGTH_LONG).show();


            }
        });



    }






    private void initRecyclerView(List<RecyclerDaysModel>list) {
        daysRecycler = (RecyclerView) findViewById(R.id.daysRecycler);
        adapter=new DaysRecyclerAdapter(list , this);
        layoutManager=new LinearLayoutManager(this);
        daysRecycler.setAdapter(adapter);
        daysRecycler.setLayoutManager(layoutManager);
        adapter.notifyDataSetChanged();

    }

 /**   private void changeAdapterList(List<RecyclerDaysModel>list){

        adapter.changeAdapterList(list);
        adapter.notifyDataSetChanged();

    }
    **/

    private void initView() {
        cityName = (TextView) findViewById(R.id.cityName);
        wheatherStatuse = (TextView) findViewById(R.id.wheatherStatuse);
        currentHumidity = (TextView) findViewById(R.id.currentHumidity);
        currentPressure = (TextView) findViewById(R.id.currentPressure);
        currentWind = (TextView) findViewById(R.id.currentWind);
        daysRecycler = (RecyclerView) findViewById(R.id.daysRecycler);
    }


    public  String getQuranClean() {
        try (InputStream fileIn = getAssets().open("quran.json");
             BufferedInputStream bufferedIn = new BufferedInputStream(fileIn);
             Reader reader = new InputStreamReader(bufferedIn, Charset.forName("UTF-8"))) {
            return new Gson().fromJson(reader, Quran.class).getStatus();

        } catch (Exception e) {
            return 3+"";
        }
    }

    public  List<Surah> getFullQuranSurahs() {
        try (InputStream fileIn = getAssets().open("quran.json");
             BufferedInputStream bufferedIn = new BufferedInputStream(fileIn);
             Reader reader = new InputStreamReader(bufferedIn, Charset.forName("UTF-8"))) {
            return new Gson().fromJson(reader, FullQuran.class).getData().getSurahs();

        } catch (Exception e) {
            return null;
        }
    }



}