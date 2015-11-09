package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Eduardo on 26/10/2015.
 */
public class BirthDay extends Activity {

    private final static int RESULT = 10;
    private EditText et_birthDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_of_birth);
        setTitle(R.string.birthdate);

        et_birthDate = (EditText) findViewById(R.id.et_birthdate);
    }

    public void onClick(View view){

        if(et_birthDate.isClickable()){
            Intent intent = new Intent(this, SelectBirthDate.class);
            startActivityForResult(intent, RESULT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_CANCELED){
            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
        } else{
            String day, mounth, year;

            day = String.valueOf(data.getExtras().getInt("day"));
            mounth = String.valueOf(data.getExtras().getInt("mounth"));
            year = String.valueOf(data.getExtras().getInt("year"));

            et_birthDate.setText(day + "/" + mounth + "/" + year);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.previous){
            Intent intent = new Intent(this, LevelActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
