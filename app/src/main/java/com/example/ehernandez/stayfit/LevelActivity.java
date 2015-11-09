package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.Toast;

/**
 * Created by Eduardo on 25/10/2015.
 */
public class LevelActivity extends Activity implements View.OnClickListener{

    private CheckedTextView chtv_sedentary;
    private CheckedTextView chtv_lowActive;
    private CheckedTextView chtv_active;
    private CheckedTextView chtv_veryActive;
    private Boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_activity);
        setTitle(R.string.title_level_activity);

        chtv_sedentary = (CheckedTextView) findViewById(R.id.chtv_sedentary);
        chtv_lowActive = (CheckedTextView) findViewById(R.id.chtv_low_active);
        chtv_active = (CheckedTextView) findViewById(R.id.chtv_active);
        chtv_veryActive = (CheckedTextView) findViewById(R.id.chtv_very_active);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.chtv_sedentary:
                if(chtv_sedentary.isClickable()){
                    chtv_sedentary.setChecked(true);
                    chtv_lowActive.setChecked(false);
                    chtv_active.setChecked(false);
                    chtv_veryActive.setChecked(false);
                } //else{

                //}
                break;
            case R.id.chtv_low_active:
                if(chtv_lowActive.isClickable()){
                    chtv_lowActive.setChecked(true);
                    chtv_sedentary.setChecked(false);
                    chtv_active.setChecked(false);
                    chtv_veryActive.setChecked(false);
                }
                break;
            case R.id.chtv_active:
                if(chtv_active.isClickable()){
                    chtv_active.setChecked(true);
                    chtv_lowActive.setChecked(false);
                    chtv_sedentary.setChecked(false);
                    chtv_veryActive.setChecked(false);
                }
                break;
            case R.id.chtv_very_active:
                if(chtv_veryActive.isClickable()){
                    chtv_veryActive.setChecked(true);
                    chtv_lowActive.setChecked(false);
                    chtv_active.setChecked(false);
                    chtv_sedentary.setChecked(false);
                }
                break;
        }
        status = true;
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

        if((item.getItemId() == R.id.previous) && status){
            openDietGoals();
            return true;
        } else{
            Toast.makeText(getApplication(), R.string.message_select_level, Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    //Temporary
    public void openDietGoals(){
        Intent intent = new Intent(this, DietGoal.class);
        startActivity(intent);
    }
}
