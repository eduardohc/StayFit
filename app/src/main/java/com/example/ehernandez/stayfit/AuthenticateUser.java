package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;

/**
 * Created by ehernandez on 07/10/2015.
 */
public class AuthenticateUser extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
                /*
                * Introduce code here
                * */
            } else{
                //Send to RegisterUser
                Intent intent = new Intent(this, RegisterUser.class);
                startActivity(intent);
                finish();
            }
        }

    }
}