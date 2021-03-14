package com.example.quiz1_eco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecord extends AppCompatActivity {

    private EditText nameInput, idInput;
    private Button startRecordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        nameInput = findViewById(R.id.nameInput);
        idInput = findViewById(R.id.idInput);
        startRecordBtn = findViewById(R.id.startRecordBtn);

        String id = idInput.getText().toString();

        startRecordBtn.setOnClickListener(
                (v) -> {

                    if (nameInput.getText().toString().equals("") || idInput.getText().toString().equals("")) {
                        Toast.makeText(this, "Completa la información para continuar", Toast.LENGTH_LONG).show();
                    } else {

                        String idRecords = getSharedPreferences("records", MODE_PRIVATE).getString("idRecords", "");
                        Log.e("", idRecords);
                        Log.d("", id);
                        addRecord(id);
                        Intent i = new Intent(this, Nexo.class);
                        startActivity(i);


                    }

                    //

                }
        );
    }

    public void addRecord(String s) {

        SharedPreferences preferences = getSharedPreferences("records", MODE_PRIVATE);
        String idRecords = preferences.getString("idRecords", "");

        if (idRecords.contains(s)) {
            Toast.makeText(this, "Ya existe un registro con este Id", Toast.LENGTH_LONG).show();
        } else {

            String idRecord = idRecords + "" + s;
            preferences.edit().putString("idRecords", idRecord + s).apply();

        }

    }
}