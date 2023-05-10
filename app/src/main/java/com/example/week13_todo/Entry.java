package com.example.week13_todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class Entry extends AppCompatActivity {
  EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        et= (EditText) findViewById(R.id.editTextTextMultiLine);

        int pos=getIntent().getIntExtra("NoteId",-1);

    if(pos!=-1)
        et.setText(MainActivity.notes.get(pos));

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.notes.set(pos, s.toString());
                MainActivity.adapt.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }


}