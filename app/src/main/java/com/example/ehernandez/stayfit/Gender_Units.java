package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by Eduardo on 25/10/2015.
 */
public class Gender_Units extends Activity implements View.OnClickListener{

    private CheckedTextView chtv_female;
    private CheckedTextView chtv_male;
    private CheckedTextView chtv_pounds;
    private CheckedTextView chtv_kilograms;
    private Boolean checked = false;
    private int unit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gender_units);
        setTitle(R.string.title_gender_units);

        chtv_female = (CheckedTextView) findViewById(R.id.chtv_female);
        chtv_male = (CheckedTextView) findViewById(R.id.chtv_male);
        chtv_pounds = (CheckedTextView) findViewById(R.id.chtv_pounds_feet);
        chtv_kilograms = (CheckedTextView) findViewById(R.id.chtv_kilograms);
    }

    // Select one option of each section
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.chtv_female:
                //If the view is clickable, the status will display the
                // check and uncheck the other option
                if(chtv_female.isClickable()){
                    chtv_female.setChecked(true);
                    chtv_male.setChecked(false);
                } else {
                    chtv_female.setChecked(false);
                }
                break;
            case R.id.chtv_male:
                if(chtv_male.isClickable()){
                    chtv_male.setChecked(true);
                    chtv_female.setChecked(false);
                } else {
                    chtv_male.setChecked(false);
                }
                break;
            case R.id.chtv_pounds_feet:
                if(chtv_pounds.isClickable()){
                    chtv_pounds.setChecked(true);
                    chtv_kilograms.setChecked(false);
                    unit = 1;
                } else {
                    chtv_pounds.setChecked(false);
                }
                break;
            case R.id.chtv_kilograms:
                if(chtv_kilograms.isClickable()){
                    chtv_kilograms.setChecked(true);
                    chtv_pounds.setChecked(false);
                    unit = 2; //Send extra to gender if kg is selected
                } else {
                    chtv_kilograms.setChecked(false);
                }
                break;
        }

        //Temporary
        if((chtv_female.isChecked() || chtv_male.isChecked()) &&
                (chtv_pounds.isChecked() || chtv_kilograms.isChecked())){
            checked = true;
        }
    }

    // Create the menu for the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if((item.getItemId() == R.id.previous) && (checked)){
            Intent intent = new Intent(this, FillWeightHeight.class);
            intent.putExtra("unit", unit); //Send the units to FillWeightHeight
            startActivity(intent);
            return true;
        } else{ // Send message if the user don't select one of the checktextview
            Toast.makeText(getApplicationContext(),
                    R.string.choose_gender_units, Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
