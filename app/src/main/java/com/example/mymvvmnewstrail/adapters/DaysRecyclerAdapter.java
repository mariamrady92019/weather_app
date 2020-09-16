package com.example.mymvvmnewstrail.adapters;

import android.content.Context;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mymvvmnewstrail.R;
import com.example.mymvvmnewstrail.api.api.foreCastResponse.ListItem;

import java.util.ArrayList;
import java.util.List;

public class DaysRecyclerAdapter extends  RecyclerView.Adapter<DaysRecyclerAdapter.DaysViewHolder> {

   List<RecyclerDaysModel> days = new ArrayList<>();
   Context context ;


     public DaysRecyclerAdapter(List<RecyclerDaysModel>list , Context context)
     {
         this.days=list;
         this.context = context ;
     }

     @NonNull
     @Override
     public DaysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater
                 .from(parent.getContext())
                 .inflate(R.layout.day_ofrecycler,parent,false);
         return new DaysViewHolder(view);
     }

     @Override
     public void onBindViewHolder(@NonNull DaysViewHolder holder, int position) {

         RecyclerDaysModel item = days.get(position);
         holder.day.setText(item.getDayName());
         holder.temprature.setText(47+"");
         holder.image.setImageResource(R.drawable.cloudy);

        /** Glide.with(context)
                 .load(Base64.decode("04n", Base64.DEFAULT))
                 .into(holder.image);
         **/


     }

     @Override
     public int getItemCount()
     {
         return days.size();
     }

     class DaysViewHolder extends RecyclerView.ViewHolder {

        protected TextView day;
        protected TextView temprature;
        protected ImageView image;


        public DaysViewHolder(@NonNull View rootView) {

            super(rootView);

          day =  rootView.findViewById(R.id.dayName);
          temprature =  rootView.findViewById(R.id.teprature);
          image =  rootView.findViewById(R.id.wheatherimage);

        }

    }


    public void changeAdapterList(List<RecyclerDaysModel>list){
         this.days=list;
         notifyDataSetChanged();
    }

}
