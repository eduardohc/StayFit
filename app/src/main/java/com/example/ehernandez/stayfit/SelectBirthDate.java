package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.NumberPicker;
import android.widget.Toast;

/**
 * Created by Eduardo on 29/10/2015.
 */
public class SelectBirthDate extends Activity {

    private NumberPicker picker_day;
    private NumberPicker picker_mounth;
    private NumberPicker picker_year;
    String birthDate;
    int day, mounth, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_birth_date);
        setTitle(R.string.birthdate);

        picker_day = (NumberPicker) findViewById(R.id.np_day);
        picker_mounth = (NumberPicker) findViewById(R.id.np_mounth);
        picker_year = (NumberPicker) findViewById(R.id.np_year);

        initializatePickers();
    }


    private void initializatePickers() {

        picker_day.setMinValue(01);
        picker_day.setMaxValue(31);
        picker_day.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                day = newVal;
            }
        });

        picker_mounth.setMinValue(1);
        picker_mounth.setMaxValue(12);
        picker_mounth.setDisplayedValues(
                new String[]{"January", "Febrary", "March", "April", "May", "June", "July",
                        "August", "September", "October", "November", "Dicember"});
        picker_mounth.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mounth = newVal;
            }
        });

        picker_year.setMinValue(1950);
        picker_year.setMaxValue(2005);
        picker_year.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                year = newVal;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_bar, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        if(item.getItemId() == R.id.previous){
            sendDate();
        }

        return super.onMenuItemSelected(featureId, item);
    }

    private void sendDate() {

        Intent intent = getIntent();
        intent.putExtra("day", day);
        intent.putExtra("mounth", mounth);
        intent.putExtra("year", year);
        setResult(RESULT_OK, intent);
        finish();

    }
}
