package com.example.quiz1_eco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Nexo extends AppCompatActivity {

    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexo);

        nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this, Symptoms.class);
                    startActivity(i);

                }
        );
    }
}