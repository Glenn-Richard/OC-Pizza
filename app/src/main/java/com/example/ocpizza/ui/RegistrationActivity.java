package com.example.ocpizza.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ocpizza.R;

public class RegistrationActivity extends AppCompatActivity {

    Boolean check = false;

    EditText name;
    EditText email;
    EditText address;
    EditText password;
    EditText password_confirm;
    TextView submit;
    TextView connexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.pseudo_inscription);
        email = findViewById(R.id.email_inscription);
        address = findViewById(R.id.address);
        password = findViewById(R.id.password);
        password_confirm = findViewById(R.id.password_confirm);
        submit = findViewById(R.id.submit_registration);
        connexion = findViewById(R.id.connexion);

        submit.setOnClickListener(v -> {
            isNotEmpty();
            if (check){

            }
        });
        connexion.setOnClickListener(v -> {
            Intent intent = new Intent(this,ConnexionActivity.class);
            startActivity(intent);
        });
    }

    private void isNotEmpty() {
        if(name.getText().equals(null)){
            check = false;
        }
        if (email.getText().equals(null)){
            check = false;
        }
        if (address.getText().equals(null)) {
            check = false;
        }
        if (password.getText().equals(null)) {
            check = false;
        }
        if (password_confirm.getText().equals(null)) {
            check = false;
        }
        else{
            check = true;
        }
    }
}