package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;

/**
 * Created by ehernandez on 07/10/2015.
 */
public class AuthenticateUser extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_activity);

        // Sleep the activity for 5 seconds
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                } catch(Exception e){
                    e.printStackTrace();
                } finally {
                    UserAuthentication();
                }
            }
        };

        timer.start();
    }

    // Method that autenticate the user and open the activity if it's needed to login or signup
    public void UserAuthentication(){
        // Determinate wheter the current user is an anonymous user
        if(ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())){
            //If user is anonymous, send the user to RegisterUser
            Intent intent = new Intent(this, RegisterUser.class);
            startActivity(intent);
            finish();
        } else{
            //If current user in Not anonymous user, get current user data from Parse.com
            ParseUser currentUser = ParseUser.getCurrentUser();
            if(currentUser != null){
                // Send to the mainActivity
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            } else{
                //Send to RegisterUser
                Intent intent = new Intent(this, RegisterUser.class);
                startActivity(intent);
                finish();
            }
        }
    }
    
}