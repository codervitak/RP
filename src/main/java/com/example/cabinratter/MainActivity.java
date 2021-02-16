package com.example.cabinratter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToRate(View view){
        Intent intent = new Intent(this, RateActivity.class);
        startActivity(intent);
    }
    public void goToTable(View view){
        Intent intent = new Intent(this, tableActivity.class);
        startActivity(intent);
    }
    public void goToReset(View view){
        Intent intent = new Intent(this, ResetActivity.class);
        startActivity(intent);
    }
}