package com.divya.rememberyourpasswords;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private EditText usernameText;
    private EditText passwordText;
    private Button signUpButton;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameText = (EditText) findViewById(R.id.username);
        passwordText = (EditText) findViewById(R.id.password);
        signUpButton = (Button) findViewById(R.id.signup);
        loginButton = (Button) findViewById(R.id.login);
        userViewModel = ViewModelProviders.of(this, new UserViewModel.Factory(getApplicationContext())).get(UserViewModel.class);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userViewModel.createUser(usernameText.getText().toString(), passwordText.getText().toString());
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isValid = userViewModel.checkValidLogin(usernameText.getText().toString(), passwordText.getText().toString());
                if(isValid)
                {
                    Log.i("Successful_Login", "Login was successful");
                }
                else
                {
                    Log.i("Unsuccessful_Login", "Login was not successful");
                }
            }
        });

    }
}
