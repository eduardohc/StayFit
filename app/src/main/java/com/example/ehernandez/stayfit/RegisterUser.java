package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by ehernandez on 07/10/2015.
 */

public class RegisterUser extends Activity {

    private EditText username, email, password, confirm_password;
    private Button button;
    private String userna, mail, pass, conf_pass;

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

        Boolean correct;

        userna = username.getText().toString();
        mail = email.getText().toString();
        pass = password.getText().toString();
        conf_pass = confirm_password.getText().toString();

        //Toast.makeText(this, "Username: " + user + " Email: " + mail, Toast.LENGTH_LONG).show();

        correct = checkPassword(pass, conf_pass);

        if(userna != null && mail != null && pass != null && conf_pass != null && correct == true){
            ParseUser user = new ParseUser();
            user.setUsername(userna);
            user.setPassword(pass);
            user.setEmail(mail);

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {

                    try {
                        Thread.sleep(2000);

                        if (e == null) {
                            //Show a simple Toast message upon successful registration
                            Toast.makeText(getApplicationContext(),
                                    "Successfully Signed up", Toast.LENGTH_LONG).show();
                            openMainActivity();
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    " " + e, Toast.LENGTH_LONG).show();
                        }
                    }catch(Exception exception){
                        e.printStackTrace();
                    }
                }
            });

        } else if(correct != true){
            Toast.makeText(getApplicationContext(),
                    "Password is different", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(getApplicationContext(),
                    "Fill all the fields", Toast.LENGTH_LONG).show();
        }
    }

    public Boolean checkPassword(String passwo, String confPass) {

        if (passwo.equals(confPass)) {
            return true;
        } else{
            return false;
        }

    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void UserLogin(View view){
        Intent intent = new Intent(this, UserLogin.class);
        startActivity(intent);
        finish();
    }
}
