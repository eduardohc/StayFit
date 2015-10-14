package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by ehernandez on 07/10/2015.
 */
public class UserLogin extends Activity{

    ProgressDialog progressDialog;
    private EditText et_username, et_password;
    String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);

    }

    public void checkForLogin(View view){

        String username, password;

        // Get the content of the login editTexts
        username = et_username.getText().toString();
        password = et_password.getText().toString();

        // Force user to fill login forms
        if(username.equals("") || password.equals("")){
            Toast.makeText(getApplicationContext(),
                    "Complete all the login forms", Toast.LENGTH_LONG).show();

        } else{
            ParseUser.logInInBackground(username, password, new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, ParseException e) {
                    if(parseUser != null){
                        // Create a progressDialos object to simulate login progress
                        progressDialog = ProgressDialog.show(UserLogin.this,
                                "Please wait..", "Logging in user...", true);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try{
                                    // Time that the progressDialog will be displayed
                                    Thread.sleep(10000);
                                } catch(Exception exception){
                                    //exception.printStackTrace();
                                }
                                progressDialog.dismiss();
                            }
                        }).start();

                        // Toast message showing siccessful login
                        Toast.makeText(getApplicationContext(),
                                "Successfully logged in", Toast.LENGTH_SHORT).show();
                        // If user exist and authenticated, send user to MainActivity.class
                        openMainActivity();

                    } else{
                        // If user isn't correct or something display a message with the error
                        //String message;
                        //message = e.getMessage();
                        Toast.makeText(getApplicationContext(),
                                "Something was wrong. Correct your user or password ",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void openResetPassword(View view){
        Intent intent = new Intent(this, ResetPassword.class);
        startActivity(intent);
    }

    //Method to return to the last activity
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
            Intent intent = new Intent(this, RegisterUser.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Destroy the progressDialog when the activity exit
        if(progressDialog != null){
            if(progressDialog.isShowing()){
                progressDialog.cancel();
            }
        }
    }
}
