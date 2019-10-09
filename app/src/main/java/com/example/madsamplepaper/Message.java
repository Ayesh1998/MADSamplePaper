package com.example.madsamplepaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Message extends AppCompatActivity {

    TextView sub,mg;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        db = new DatabaseHelper(Message.this);
        sub = findViewById(R.id.couserAppMassegeTitle);
        mg = findViewById(R.id.couserAppMassegeMassege);



        Intent intent = getIntent();
        int position = intent.getIntExtra("position",1) ;
        List a = db.readMaseges();
        List b = db.readMasegesSub();


        String c = a.get(position).toString();
        String d = b.get(position).toString();

        mg.setText(c);
        sub.setText(d);




    }
}
