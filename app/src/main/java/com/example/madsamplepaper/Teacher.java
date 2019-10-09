package com.example.madsamplepaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Teacher extends AppCompatActivity {

    EditText mg,sub;
    Button save;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        db = new DatabaseHelper(Teacher.this);

        mg = findViewById(R.id.couserAppTeacherMassege);
        sub = findViewById(R.id.couserAppTeacherSubject);
        save = findViewById(R.id.couserAppTeacherSaveBtn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mges = mg.getText().toString();
                String subj = sub.getText().toString();

                if (TextUtils.isEmpty(subj)){
                    Toast.makeText(Teacher.this, "Enter subject", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mges)){
                    Toast.makeText(Teacher.this, "Enter massege", Toast.LENGTH_SHORT).show();
                    return;
                }

                Boolean result = db.insertMassge("2",subj,mges);

                if (!result){
                    Toast.makeText(Teacher.this, "Massege entered Not Completed", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Teacher.this, "Massege entered Succesfull", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(Teacher.this,MainActivity.class);
                    startActivity(in);
                }
            }
        });
    }
}
