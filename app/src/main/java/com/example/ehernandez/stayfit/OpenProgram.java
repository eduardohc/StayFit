package com.example.ehernandez.stayfit;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by Eduardo on 04/11/2015.
 */
public class OpenProgram extends TabActivity {

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.program);
        //setTitle(R.string.program);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Create tab1
        TabHost.TabSpec tab1 = this.getTabHost().newTabSpec("diet");

        View tabIndicator = LayoutInflater.from(this).inflate(
                R.layout.tab_diet, getTabWidget(), false);
        ((TextView) tabIndicator.findViewById(R.id.tv_diet_tabhost)).setText(R.string.diet);
        ((ImageView) tabIndicator.findViewById(
                R.id.img_diet_tabhost)).setImageResource(R.drawable.tabhost_status);

        tab1.setIndicator(tabIndicator);
        tab1.setContent(new Intent(this, DietProgram.class));

        // Create tab2
        TabHost.TabSpec tab2 = this.getTabHost().newTabSpec("exercise");

        View tabIndicator2 = LayoutInflater.from(this).inflate(
                R.layout.tab_exercise, getTabWidget(), false);
        ((TextView) tabIndicator2.findViewById(R.id.tv_exercise_th)).setText(R.string.diet);
        ((ImageView) tabIndicator2.findViewById(
                R.id.img_exercise_th)).setImageResource(R.drawable.tbh_exercise_status);

        tab2.setIndicator(tabIndicator2);
        tab2.setContent(new Intent(this, ExerciseProgram.class));

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);

        //addTab(R.drawable.tabhost_status, 1);
        //addTab(R.drawable.tabhost_status, 2);*/

        tabHost = getTabHost();

        tabHost.addTab(tabHost.newTabSpec("diet").setIndicator(
                "Diet").setContent(new Intent(this, DietProgram.class)));
        tabHost.addTab(tabHost.newTabSpec("exercise").setIndicator(
                "Exercise").setContent(new Intent(this, ExerciseProgram.class)));
        tabHost.setCurrentTab(0);

    }

    /*private void addTab(int drawableId, int num){

        Intent intent;

        if(num == 1){
            intent = new Intent(this, DietProgram.class);
        } else {
            intent = new Intent(this, ExerciseProgram.class);
        }

        TabHost.TabSpec spec = this.getTabHost().newTabSpec("diet");

        View tabIndicator = LayoutInflater.from(this).inflate(
                R.layout.tab_diet, getTabWidget(), false);

        ((TextView) tabIndicator.findViewById(R.id.tv_diet_tabhost)).setText(R.string.diet);
        ((ImageView) tabIndicator.findViewById(
                R.id.img_diet_tabhost)).setImageResource(R.drawable.tabhost_status);

        spec.setIndicator(tabIndicator);
        spec.setContent(intent);
        tabHost.addTab(spec);
    }*/

}
