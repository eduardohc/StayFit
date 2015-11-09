package com.example.ehernandez.stayfit;

import com.parse.ParseAnalytics;
import com.parse.ParseUser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ParseAnalytics.trackAppOpenedInBackground(getIntent());

    }

    public void openProgram(View view){
        Intent intent = new Intent(this, OpenProgram.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.configuracion:
                Toast.makeText(getApplicationContext(),
                        "Click", Toast.LENGTH_LONG).show();
                break;
            case R.id.logout:
                logOut();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    // Logout if click on the menu action bar is clicked,
    public void logOut(){
        ParseUser.logOut();
        Intent intent = new Intent(this, RegisterUser.class);
        startActivity(intent);
        finish();
    }
}