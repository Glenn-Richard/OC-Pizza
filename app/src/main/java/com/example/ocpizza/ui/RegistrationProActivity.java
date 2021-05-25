package com.example.ocpizza.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ocpizza.R;
import com.example.ocpizza.model.Function;
import com.example.ocpizza.model.User;
import com.example.ocpizza.service.ApiPizzaBank;

import java.util.List;

public class RegistrationProActivity extends AppCompatActivity {

    String NEW_USER = "NEW_USER";

    List<Function> functions = new ApiPizzaBank().FUNCTIONS;

    User user;

    Boolean check = false;

    EditText password;
    EditText password_confirm;
    TextView submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_pro);

        user = getIntent().getParcelableExtra(NEW_USER);

        password = findViewById(R.id.password_pro);
        password_confirm = findViewById(R.id.password_confirm_pro);
        submit = findViewById(R.id.submit_registration_pro);

        passwordIsCorrect();

        user.setPassword(password.getText().toString());

        submit.setOnClickListener(v -> {
            if (user.getFunction().equals(functions.get(1))){

            }
            if (user.getFunction().equals(functions.get(2))){

            }
            if (user.getFunction().equals(functions.get(3))){

            }
        });
    }

    private void passwordIsCorrect() {
        if (password.getText().equals("")||password_confirm.getText().equals("")){
            check = false;
        }
        if (!password.equals(password_confirm)){
            check = false;
        }
        else{
            check = true;
        }
    }
}