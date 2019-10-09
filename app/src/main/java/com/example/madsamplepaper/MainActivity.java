package com.example.madsamplepaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText user,pass;
    Button log,reg;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(MainActivity.this);
        user = findViewById(R.id.couserAppLoginUsername);
        pass = findViewById(R.id.couserAppLoginPassword);
        log = findViewById(R.id.couserAppLoginBtn);
        reg = findViewById(R.id.couserAppLoginRegBtn);


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,RegisterForm.class);
                startActivity(in);
            }
        });
    }
}
