package com.example.madsamplepaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterForm extends AppCompatActivity {

    EditText username,pass;
    CheckBox teacher,student;
    Button reg;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);

        username = findViewById(R.id.couserAppRegisterUsername);
        pass = findViewById(R.id.couserAppRegisterPassword);
        student = findViewById(R.id.couserAppRegistercheckBoxStudent);
        teacher = findViewById(R.id.couserAppRegistercheckBoxTeacher);
        reg = findViewById(R.id.couserAppRegisterBtn);

        db = new DatabaseHelper(RegisterForm.this);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                String passs = pass.getText().toString();
                String type = null;

                if (student.isChecked()){
                    type = "Student";
                }
                if (teacher.isChecked()){
                    type = "Student";
                }
                System.out.println(name + passs + type);
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(RegisterForm.this, "Enter name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passs)){
                    Toast.makeText(RegisterForm.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(type)){
                    Toast.makeText(RegisterForm.this, "Check a box", Toast.LENGTH_SHORT).show();
                    return;
                }


                Boolean result = db.insertUser(name,passs,type);

                if (!result){
                    Toast.makeText(RegisterForm.this, "Register Not Completed", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegisterForm.this, "Register Succesfull", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(RegisterForm.this,MainActivity.class);
                    startActivity(in);
                }

            }
        });
    }
}
