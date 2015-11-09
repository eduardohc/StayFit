package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Eduardo on 15/10/2015.
 */
public class FillWeightHeight extends Activity {

    //Class variables
    private EditText weight;
    private EditText goal_weight;
    private EditText height;
    private TextView tv_weight;
    private TextView tv_goal_weight;
    private TextView tv_height;
    private Bundle bundle;
    private boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_height);
        setTitle(R.string.title_weight_height); // Set the title activity
        initializateWidgets(); // Call method to initializate variables
        getUnits();
    }

    public void initializateWidgets(){
        weight = (EditText) findViewById(R.id.et_weight);
        goal_weight = (EditText) findViewById(R.id.et_goalWeight);
        height = (EditText) findViewById(R.id.et_height);
        tv_weight = (TextView) findViewById(R.id.tv_weight);
        tv_goal_weight = (TextView) findViewById(R.id.tv_goal_weight);
        tv_height = (TextView) findViewById(R.id.tv_height);

        bundle = getIntent().getExtras(); // Create bundle and get extras
    }

    private void getUnits() {
        //Set the textview with the correct unit
        if (bundle.getInt("unit") == 2) {
            tv_weight.setText(R.string.weight_kg);
            tv_goal_weight.setText(R.string.goal_weight_kg);
            tv_height.setText(R.string.height_cm);
        } else{

        }
    }

    private boolean obtainStatus() {

        String getWeight, getGoal, getHeight;
        Boolean status; // Local variable

        getWeight = weight.getText().toString();
        getGoal = goal_weight.getText().toString();
        getHeight = height.getText().toString();

        // Validate if the user fill all the forms
        if(getWeight.equals("") || getGoal.equals("") || getHeight.equals("")){
            status = false;
        } else{
            status = true;
        }
        return status;
    }

    // Create activity menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        status = obtainStatus();
        if((item.getItemId() == R.id.previous) && (status)){
            Intent intent = new Intent(this, BirthDay.class);
            startActivity(intent);
            return true;
        } else{ // Display a message
            Toast.makeText(getApplicationContext(),
                    R.string.fill_fields_weight_height, Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

}
