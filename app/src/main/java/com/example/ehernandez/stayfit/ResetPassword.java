package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

/**
 * Created by Eduardo on 14/10/2015.
 */
public class ResetPassword extends Activity {

    private EditText et_resetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);
        setTitle(R.string.reset_password);

        et_resetPassword = (EditText) findViewById(R.id.et_email_reset);
    }

    public void resetPassword(View view){
        String email;
        email = et_resetPassword.getText().toString();

        if(email.equals("")){
            // Toaste a message if the email form has not email
            Toast.makeText(getApplicationContext(),
                    R.string.message_email, Toast.LENGTH_SHORT).show();

        } else{
            // Send a mail to the user who request resetting password
            ParseUser.requestPasswordResetInBackground(email, new RequestPasswordResetCallback() {
                @Override
                public void done(ParseException e) {
                    if(e == null){
                        // Toaste a message if the email was successfully sent
                        // and openLogin activity
                        Toast.makeText(getApplicationContext(),
                                R.string.message_email_sent,
                                Toast.LENGTH_LONG).show();
                        openLogin();
                    } else{
                        String message;
                        //Get the ParseException and display it in the Toast below
                        message = e.getMessage();
                        Toast.makeText(getApplicationContext(),
                                "" + message, Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    public void openLogin(){
        Intent intent = new Intent(this, UserLogin.class);
        startActivity(intent);
        finish();
    }
}
