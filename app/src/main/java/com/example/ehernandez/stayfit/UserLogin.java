package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by ehernandez on 07/10/2015.
 */
public class UserLogin extends Activity{

    private EditText et_username, et_password;
    String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);

    }

    /*public void checkForLogin(View view){

    }*/
}
