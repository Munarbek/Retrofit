package com.example.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitexample.API.ApiService;
import com.example.retrofitexample.API.Apifactory;
import com.example.retrofitexample.POJO.ResponceEmployee;
import com.example.retrofitexample.POJO.Response;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private List<Response> Employees;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        Apifactory apifactory=Apifactory.getInstance();
        ApiService apiService=apifactory.getApiservic();
        apiService.getEmployees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponceEmployee>() {
                    @Override
                    public void accept(ResponceEmployee responceEmployee) throws Exception {

                        Employees=responceEmployee.getResponse();
                        int x=Employees.size();

                        for(int i=0;i<x;i++){

                            textView.setText(textView.getText()+"Name :"+Employees.get(i).getFName()+"\n");
                            textView.setText(textView.getText()+
                                    "LastName"+Employees.get(i).getLName()+"\n");


                        }



                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        Toast.makeText(MainActivity.this,"Error"+throwable.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });



    }
}
