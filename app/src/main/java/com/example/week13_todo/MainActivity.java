package com.example.week13_todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> notes = new ArrayList<>();
    static ArrayAdapter<String> adapt;
    ListView lw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lw= (ListView) findViewById(R.id.mylistview);

        notes.add("TEST0");
        notes.add("TEST1");
        notes.add("TEST2");
        notes.add("TEST3");
      adapt =  new ArrayAdapter<>( this,
                android.R.layout.simple_list_item_1,
                notes);
        lw.setAdapter(adapt);

        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent myint= new Intent(MainActivity.this,Entry.class);
                myint.putExtra( "NoteId",position);

                startActivity(myint);

            }
        });

        }
}