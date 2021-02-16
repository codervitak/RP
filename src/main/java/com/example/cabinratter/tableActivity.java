package com.example.cabinratter;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

public class tableActivity extends AppCompatActivity {

    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        tableLayout = (TableLayout) findViewById(R.id.tableLayout);

        SQLiteDatabase myDB = openOrCreateDatabase("myDB",MODE_PRIVATE,null);
        try(Cursor rs = myDB.rawQuery("SELECT * FROM Children", null);){
            if(rs.moveToFirst()){
                do{
                    int p = 0;
                    try(Cursor rp = myDB.rawQuery("SELECT * FROM Points WHERE ChildID = "+ String.valueOf(rs.getInt(0)), null);){
                        if(rp.moveToFirst()){
                            do{
                            p+= rp.getInt(2);
                        }while(rp.moveToNext());}
                    }catch (Exception e){
                        Log.e("tableAc", e.toString());
                    }
                    View tableRow = LayoutInflater.from(this).inflate(R.layout.table_item,null,false);
                    TextView table_display_name = (TextView)tableRow.findViewById(R.id.table_display_name);
                    TextView table_display_cabin = (TextView)tableRow.findViewById(R.id.table_display_cabin);
                    TextView table_display_team = (TextView)tableRow.findViewById(R.id.table_display_team);
                    TextView table_display_points = (TextView)tableRow.findViewById(R.id.table_display_points);

                    table_display_name.setText(rs.getString(1));
                    table_display_cabin.setText(rs.getString(2));
                    table_display_team.setText(rs.getString(3));
                    table_display_points.setText(String.valueOf(p));
                    tableLayout.addView(tableRow);
                } while(rs.moveToNext());
            }
        }catch (Exception e){
            Log.e("tableAc", e.toString());
        }
    }
}