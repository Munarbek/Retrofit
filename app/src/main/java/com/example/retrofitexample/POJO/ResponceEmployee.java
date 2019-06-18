package com.example.retrofitexample.POJO;

import android.widget.Adapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponceEmployee {



    @SerializedName("response")
    @Expose

    private List<Response> response = null;


    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

}
