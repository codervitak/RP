package com.example.cabinratter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class RateChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_child);
    }

    private void insertRating(int rating){
        SQLiteDatabase myDB = openOrCreateDatabase("myDB",MODE_PRIVATE,null);
        myDB.execSQL("CREATE TABLE IF NOT EXISTS " +
                "Points(RatingId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " ChildId INTEGER NOT NULL, Rating INTEGER, Date INTEGER)");
        ContentValues val = new ContentValues();
        Intent intent = getIntent();
        int childId = intent.getIntExtra("CHILD_ID",-1);
        Log.i("RateChildAc", String.valueOf(childId));
        val.put("ChildId", childId);
        Log.i("RateChildAc", String.valueOf(rating));
        val.put("Rating", rating);
        val.put("Date", System.currentTimeMillis());
        myDB.insert("Points",null,val);


        Intent goingHome = new Intent(this, RateActivity.class);
        startActivity(goingHome);
    }

    public void fiveOnClick(View view){
        insertRating(5);
    }
    public void fourOnClick(View view){
        insertRating(4);
    }
    public void threeOnClick(View view){
        insertRating(3);
    }
    public void twoOnClick(View view){
        insertRating(2);
    }
    public void oneOnClick(View view){
        insertRating(1);
    }
    public void oOnClick(View view){
        insertRating(0);
    }
}