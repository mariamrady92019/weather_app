package com.example.mymvvmnewstrail.adapters;

public class RecyclerDaysModel {
     String id ;
     String dayName ;
     String temprature ;
     int image ;
     String date ;

    public RecyclerDaysModel(String dayName, String temprature) {
        this.dayName = dayName;
        this.temprature = temprature;
    }


    public RecyclerDaysModel() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getTemprature() {
        return temprature;
    }

    public void setTemprature(String temprature) {
        this.temprature = temprature;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "RecyclerDaysModel{" +
                "id='" + id + '\'' +
                ", dayName='" + dayName + '\'' +
                ", temprature='" + temprature + '\'' +
                ", image=" + image +
                ", date='" + date + '\'' +
                '}';
    }
}
