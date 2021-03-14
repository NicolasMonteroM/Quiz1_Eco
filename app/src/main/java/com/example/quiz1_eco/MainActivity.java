package com.example.quiz1_eco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView recordsTextView;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recordsTextView = findViewById(R.id.recordsTextView);
        addBtn = findViewById(R.id.addBtn);

        getRecords();

        addBtn.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this, AddRecord.class);
                    startActivity(i);

                }
        );

    }



    public void getRecords() {

        String records = getSharedPreferences("records", MODE_PRIVATE).getString("idRecords", "No hay ningún registro aún");
        recordsTextView.setText(records);

    }


    public void onResume() {

        super.onResume();
        getRecords();

    }



}