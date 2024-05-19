package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    TextView idBimbel, email, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        idBimbel = findViewById(R.id.tv_idBimbel);
        email = findViewById(R.id.tv_email);
        name = findViewById(R.id.tv_name);

        Intent intent = getIntent();
        String idBimbelSiswa = intent.getStringExtra("Id_user");
        String mailSiswa = intent.getStringExtra("Email_user");
        String namaSiswa = intent.getStringExtra("Name_user");

        idBimbel.setText(idBimbelSiswa);
        email.setText(mailSiswa);
        name.setText(namaSiswa);
    }
}