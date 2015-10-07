package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by ehernandez on 07/10/2015.
 */
public class RegisterUser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);

    }

    public void UserLogin(View view){
        Intent intent = new Intent(this, UserLogin.class);
        startActivity(intent);
        finish();
    }
}
