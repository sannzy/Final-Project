package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView linkLogin;
    EditText idBimbelField, emailField, nameField, passwordField, confirmField;
    Button register;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        idBimbelField = findViewById(R.id.et_idBimbel);
        emailField = findViewById(R.id.et_email);
        nameField = findViewById(R.id.et_name);
        passwordField = findViewById(R.id.et_password);
        confirmField = findViewById(R.id.et_confirm);

        linkLogin = findViewById(R.id.tv_linkLogin);
        register = findViewById(R.id.btn_register);

        linkLogin.setOnClickListener(v -> {
            Intent loginIntent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(loginIntent);
        });

        sharedPreferences = getSharedPreferences("user_account", MODE_PRIVATE);

        register.setOnClickListener(v -> {
            if (idBimbelField.getText().toString().length() < 4) {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();Toast.makeText(this, "Id must be more than 4 numbers.", Toast.LENGTH_SHORT).show();
            } else if (!emailField.getText().toString().contains("@") || !emailField.getText().toString().contains(".com")) {
                Toast.makeText(this, "Email must be valid that contain with '@' and end with '.com'", Toast.LENGTH_SHORT).show();
            } else if (nameField.getText().toString().length() < 5) {
                Toast.makeText(this, "Name must be more than 5 characters.", Toast.LENGTH_SHORT).show();
            } else if (passwordField.getText().toString().length() < 5) {
                Toast.makeText(this, "Password must be more than 5 characters.", Toast.LENGTH_SHORT).show();
            } else if (!confirmField.getText().toString().equals(passwordField.getText().toString())) {
                Toast.makeText(this, "Password must be matched.", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Id_user", idBimbelField.getText().toString());
                editor.putString("Email_user", emailField.getText().toString());
                editor.putString("Name_user", nameField.getText().toString());
                editor.putString("Password_user", passwordField.getText().toString());
                editor.apply();

                Toast.makeText(this, "Registration completed. Please login!", Toast.LENGTH_SHORT).show();

                Intent toLogin = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(toLogin);

                finish();
            }
        });
    }
}