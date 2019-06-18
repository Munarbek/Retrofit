package com.example.retrofitexample.API;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class Apifactory {

     private static Apifactory Apifactory;

     public static Retrofit retrofit;

     private  static  String BASE_URL="https://gitlab.65apps.com/65gb/static/raw/master/";

     private Apifactory(){


          retrofit=new Retrofit.Builder()
                  .addConverterFactory(GsonConverterFactory.create())
                  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                  .baseUrl(BASE_URL)
                  .build();


     }

     public static Apifactory getInstance() {

          if(Apifactory==null){
     Apifactory=new Apifactory();

}
          return Apifactory;

     }

     public  ApiService getApiservic(){

          return  retrofit.create(ApiService.class);

     }




}


