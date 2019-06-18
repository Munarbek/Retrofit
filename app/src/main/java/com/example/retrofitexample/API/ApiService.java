package com.example.retrofitexample.API;

import com.example.retrofitexample.POJO.ResponceEmployee;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("testTask.json")
    Observable<ResponceEmployee> getEmployees();
}
