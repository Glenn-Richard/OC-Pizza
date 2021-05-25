package com.example.ocpizza.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ocpizza.R;
import com.example.ocpizza.model.Function;
import com.example.ocpizza.model.User;
import com.example.ocpizza.service.ApiPizzaBank;
import com.example.ocpizza.view_model.RegistrationViewModel;
import com.example.ocpizza.view_model.RegistrationViewModelFactory;

import java.util.List;

public class RegistrationActivity extends AppCompatActivity {

    RegistrationViewModel viewModel;

    List<Function> functions = new ApiPizzaBank().FUNCTIONS;

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

        setViewModel();

        submit.setOnClickListener(v -> {
            isNotEmpty();
            if (check){
                User user = new User();

                user.setName(name.getText().toString());
                user.setEmail(email.getText().toString());
                user.setAddress(address.getText().toString());
                setFunction(user);

                if(user.getFunction().getName().equals("Client")){

                    user.setPassword(password.getText().toString());
                    if (viewModel.isConflict(user))
                    viewModel.insertUser(user);
                    Intent intent = new Intent(this,OrderActivity.class);
                    intent.putExtra("NEW_CUSTOMER",user);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(this,RegistrationProActivity.class);
                    intent.putExtra("NEW_USER",user);
                    startActivity(intent);

                }

            }
        });
        connexion.setOnClickListener(v -> {
            Intent intent = new Intent(this,ConnexionActivity.class);
            startActivity(intent);
        });
    }

    private void setFunction(User user) {
        if(password.getText().equals("pizzaiolo12345")){
            user.setFunction(functions.get(1));
        }
        if(password.getText().equals("manager12345")){
            user.setFunction(functions.get(2));
        }
        if(password.getText().equals("coursier12345")){
            user.setFunction(functions.get(3));
        }
        else{
            user.setFunction(functions.get(0));
        }
    }

    private void setViewModel() {
        RegistrationViewModelFactory registrationViewModelFactory = new RegistrationViewModelFactory(this);
        viewModel = ViewModelProviders.of(this, registrationViewModelFactory)
                .get(RegistrationViewModel.class);
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
        if(!(password.equals(password_confirm))){
            check = false;
        }
        else{
            check = true;
        }
    }
}