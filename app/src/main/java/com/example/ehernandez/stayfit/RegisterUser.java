package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.app.ProgressDialog;
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

    ProgressDialog progressDialog;
    private EditText username, email, password, confirm_password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);
        setTitle(R.string.signup);

        username = (EditText) findViewById(R.id.et_username_signup);
        email = (EditText) findViewById(R.id.et_email);
        password = (EditText) findViewById(R.id.et_password_signup);
        confirm_password = (EditText) findViewById(R.id.et_confirm_password);
    }

    // On click sign up Button
    public void checkForJoin(View view){
        String userna, mail, pass, conf_pass;
        Boolean correct;

        //Get the user, mail and password of the editText
        userna = username.getText().toString();
        mail = email.getText().toString();
        pass = password.getText().toString();
        conf_pass = confirm_password.getText().toString();

        // Force user to fill up the form
        if(userna.equals("") || mail.equals("") || pass.equals("") || conf_pass.equals("")){
            Toast.makeText(getApplicationContext(),
                    R.string.message_fillForms, Toast.LENGTH_LONG).show();

        } else{
            // Check if passwords are correct
            correct = checkPassword(pass, conf_pass);
            if(correct == true) {
                //Save new user data into Parse.com Data Storage
                final ParseUser user = new ParseUser();
                user.setUsername(userna);
                user.setPassword(pass);
                user.setEmail(mail);

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        try {
                            if (e == null) {
                                // Create a progresDialos to display the sign up progress
                                progressDialog = ProgressDialog.show(RegisterUser.this,
                                        "Please wait..", "Singing up user..", true);
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try{
                                            // Time that the progressDialog will be displayed
                                            Thread.sleep(10000);
                                        } catch (Exception exception){
                                            exception.printStackTrace();
                                        }
                                        progressDialog.dismiss();
                                    }
                                }).start();

                                //Show a simple Toast message upon successful registration
                                Toast.makeText(getApplicationContext(),
                                        R.string.message_succesful_signup,
                                        Toast.LENGTH_SHORT).show();
                                openInformationActivities(); // Open if user is authenticated

                            } else {
                                //Show a message with the ParseException to know the error
                                String message;
                                message = e.getMessage();
                                Toast.makeText(getApplicationContext(),
                                        " " + message, Toast.LENGTH_LONG).show();
                            }
                        }catch(Exception exception){
                            e.printStackTrace();
                        }
                    }
                });

            } else{
                // If passwords aren't correct, show a Toast message
                Toast.makeText(getApplicationContext(),
                        "Password is different. Please correct it.", Toast.LENGTH_LONG).show();
            }
        }
    }

    // Verify if the passwords are equals
    public Boolean checkPassword(String passwo, String confPass) {

        if (passwo.equals(confPass)) {
            return true;
        } else{
            return false;
        }
    }

    public void openInformationActivities(){
        Intent intent = new Intent(this, Gender_Units.class);
        startActivity(intent);
        finish();
    }

    public void openLogin(View view){
        Intent intent = new Intent(this, UserLogin.class);
        startActivity(intent);
        finish();
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
