package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ehernandez on 07/10/2015.
 */

public class RegisterUser extends Activity {

    private EditText username, email, password, confirm_password;
    private Button button;
    private String user, mail, pass, conf_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);

        username = (EditText) findViewById(R.id.et_username_signup);
        email = (EditText) findViewById(R.id.et_email);
        password = (EditText) findViewById(R.id.et_password_signup);
        confirm_password = (EditText) findViewById(R.id.et_confirm_password);

    }

    public void checkForJoin(View view){

        user = username.getText().toString();
        mail = email.getText().toString();
        pass = password.getText().toString();
        conf_pass = confirm_password.getText().toString();

        Toast.makeText(this, "Username: " + user + "Email: " + email, Toast.LENGTH_LONG).show();

    }

    // Class to check if user is unic, if user is already join, if password is correct, etc.
    /*private class AuthenticateUser extends AsyncTask<String, Void, Boolean>{

    }*/

    public void UserLogin(View view){
        Intent intent = new Intent(this, UserLogin.class);
        startActivity(intent);
        finish();
    }
}
