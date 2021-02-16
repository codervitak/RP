package com.example.cabinratter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class CreateChildActivity extends AppCompatActivity {

    private EditText nameEdit, teamEdit, cabinEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_child);

        nameEdit = (EditText)findViewById(R.id.createName);
        teamEdit = (EditText)findViewById(R.id.createTeam);
        cabinEdit = (EditText)findViewById(R.id.createCabin);



       // SQLiteDatabase myDB = openOrCreateDatabase("myDB",MODE_PRIVATE,null);
       // myDB.execSQL("CREATE TABLE IF NOT EXISTS Children(Name VARCHAR,Team VARCHAR, Cabin INT);");
       // myDB.execSQL("INSERT INTO Children VALUES('admin','admin');");
    }

    public void insertChild(View view){

        SQLiteDatabase myDB = openOrCreateDatabase("myDB",MODE_PRIVATE,null);
        myDB.execSQL("CREATE TABLE IF NOT EXISTS " +
                "Children(Childid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " Name VARCHAR,Team VARCHAR, Cabin INT);");



        ContentValues val = new ContentValues();
        String name = nameEdit.getText().toString();
        val.put("Name", name);
        String team = teamEdit.getText().toString();
        val.put("Team", team);
        int cabin = Integer.parseInt(cabinEdit.getText().toString());
        val.put("Cabin", cabin);
        myDB.insert("Children", null, val);

       nameEdit.setText("");

    }
}