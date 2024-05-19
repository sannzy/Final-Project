package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView linkRegister;
    EditText emailField, passwordField;
    Button login;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailField = findViewById(R.id.et_email);
        passwordField = findViewById(R.id.et_password);

        linkRegister = findViewById(R.id.tv_linkRegister);
        login = findViewById(R.id.btn_login);

        linkRegister.setOnClickListener(v-> {
            Intent loginIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(loginIntent);
        });

        sharedPreferences = getSharedPreferences("user_account", MODE_PRIVATE);

        login.setOnClickListener(v -> {
            if (!emailField.getText().toString().equals(sharedPreferences.getString("Email_user", ""))) {
                Toast.makeText(this, "Email doesn't exist. Please register first!", Toast.LENGTH_SHORT).show();
            } else if (!passwordField.getText().toString().equals(sharedPreferences.getString("Password_user", ""))) {
                Toast.makeText(this, "Password incorrect!", Toast.LENGTH_SHORT).show();
            } else {
                Intent goData = new Intent(MainActivity.this, DataActivity.class);

                goData.putExtra("Id_user", sharedPreferences.getString("Id_user", ""));
                goData.putExtra("Email_user", sharedPreferences.getString("Email_user", ""));
                goData.putExtra("Name_user", sharedPreferences.getString("Name_user", ""));

                Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}