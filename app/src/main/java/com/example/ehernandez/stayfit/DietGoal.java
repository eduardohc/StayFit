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
 * Created by Eduardo on 21/10/2015.
 */
public class DietGoal extends Activity implements View.OnClickListener{

    private CheckedTextView chtv_weight_gain;
    private CheckedTextView chtv_slow_gain;
    private CheckedTextView chtv_maintain;
    private CheckedTextView chtv_slow_loss;
    private CheckedTextView chtv_weight_loss;
    private Boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_goals);
        setTitle(R.string.title_diet_goal);

        chtv_weight_gain = (CheckedTextView) findViewById(R.id.chtv_gain_weight);
        chtv_slow_gain = (CheckedTextView) findViewById(R.id.chtv_slow_weight_gain);
        chtv_maintain = (CheckedTextView) findViewById(R.id.chtv_maintain_weight);
        chtv_slow_loss = (CheckedTextView) findViewById(R.id.chtv_slow_weight_loss);
        chtv_weight_loss = (CheckedTextView) findViewById(R.id.chtv_weight_loss);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chtv_gain_weight:
                if(chtv_weight_gain.isClickable()){
                    chtv_weight_gain.setChecked(true);
                    chtv_slow_gain.setChecked(false);
                    chtv_maintain.setChecked(false);
                    chtv_slow_loss.setChecked(false);
                    chtv_weight_loss.setChecked(false);
                }
                break;
            case R.id.chtv_slow_weight_gain:
                if(chtv_slow_gain.isClickable()){
                    chtv_weight_gain.setChecked(false);
                    chtv_slow_gain.setChecked(true);
                    chtv_maintain.setChecked(false);
                    chtv_slow_loss.setChecked(false);
                    chtv_weight_loss.setChecked(false);
                }
                break;
            case R.id.chtv_maintain_weight:
                if(chtv_maintain.isClickable()){
                    chtv_weight_gain.setChecked(false);
                    chtv_slow_gain.setChecked(false);
                    chtv_maintain.setChecked(true);
                    chtv_slow_loss.setChecked(false);
                    chtv_weight_loss.setChecked(false);
                }
                break;
            case R.id.chtv_slow_weight_loss:
                if(chtv_slow_loss.isClickable()){
                    chtv_weight_gain.setChecked(false);
                    chtv_slow_gain.setChecked(false);
                    chtv_maintain.setChecked(false);
                    chtv_slow_loss.setChecked(true);
                    chtv_weight_loss.setChecked(false);
                }
                break;
            case R.id.chtv_weight_loss:
                if(chtv_weight_loss.isClickable()){
                    chtv_weight_gain.setChecked(false);
                    chtv_slow_gain.setChecked(false);
                    chtv_maintain.setChecked(false);
                    chtv_slow_loss.setChecked(false);
                    chtv_weight_loss.setChecked(true);
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
            openMainActivity();
            return true;
        } else{
            Toast.makeText(getApplication(),
                    R.string.message_select_goal, Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    //Temporary
    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
