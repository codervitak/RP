package com.example.cabinratter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

public class RateActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private final String TAG = "Rate ac";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        Log.e(TAG, "Oncreate happen");

        tableLayout = (TableLayout)findViewById(R.id.rateLayout);
        SQLiteDatabase myDB = openOrCreateDatabase("myDB",MODE_PRIVATE,null);
        try (Cursor rs = myDB.rawQuery("SELECT * FROM Children", null);){

    if(rs.moveToFirst()){
            do{


                View tableRow = LayoutInflater.from(this).inflate(R.layout.rate_table_item,null,false);
                TextView rate_display_id = (TextView)tableRow.findViewById(R.id.rate_display_id);
                TextView rate_display_name = (TextView)tableRow.findViewById(R.id.rate_display_name);
                TextView rate_display_team = (TextView)tableRow.findViewById(R.id.rate_display_team);
                TextView rate_display_cabin = (TextView)tableRow.findViewById(R.id.rate_display_cabin);

                int childId = rs.getInt(0);

                rate_display_id.setText(String.valueOf(childId));
                rate_display_name.setText(rs.getString(1));
                rate_display_team.setText(rs.getString(2));
                rate_display_cabin.setText(String.valueOf(rs.getInt(3)));

                tableRow.setOnClickListener(view -> {
                    Intent intent = new Intent(this, RateChildActivity.class);
                    intent.putExtra("CHILD_ID",childId);
                    startActivity(intent);
                });

                tableLayout.addView(tableRow);
            }while(rs.moveToNext());}
        } catch (Exception e){
    Log.e("Rate ac", e.toString());

        }
    Log.e("Rate ac", "Oncreate happened");
    }

    public void createChild(View view){
        Intent intent = new Intent(this, CreateChildActivity.class);
        startActivity(intent);


    }
}