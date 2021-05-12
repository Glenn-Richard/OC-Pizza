package com.example.ocpizza.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ocpizza.R;
import com.example.ocpizza.database.DatabaseManager;
import com.example.ocpizza.model.Function;
import com.example.ocpizza.model.User;

public class ConnexionActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    TextView inscription;
    TextView alert_email;
    TextView alert_password;

    Boolean checkSubmit = false;
    Boolean checkUser = false;

    DatabaseManager database = DatabaseManager.getDatabase(this);

    User actualUser = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        inscription = findViewById(R.id.inscription);
        alert_email = findViewById(R.id.alert_email);
        alert_password = findViewById(R.id.alert_password);

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
            }
        });
        checking();
        if (checkSubmit){
            actualUser = database
                    .userDao()
                    .findUser(
                            email.getText().toString(),
                            password.getText().toString()
                    );

            userChecking(actualUser);

            if (checkUser){
                switch (actualUser.getFunction().getId()){
                    case 0:
                        Intent intent1 = new Intent(ConnexionActivity.this,OrderActivity.class);
                        startActivity(intent1);
                        break;
                    case 1:

                    case 2:

                        break;

                    case 3:

                }
            }
        }
    }

    private void checking() {
        if (email.getText().equals(null)){
            alert_email.setText(R.string.require);
            checkSubmit =  false;
        }else if (password.getText().equals(null)){
            alert_password.setText(R.string.require);
            checkSubmit =  false;
        }else{
            checkSubmit =  true;
        }
    }
    private void userChecking(User user){
        if(user!=null)
            checkUser = true;
        else
            checkUser = false;
    }
}