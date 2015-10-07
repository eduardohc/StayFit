package com.example.ehernandez.stayfit;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by ehernandez on 05/10/2015.
 */
public class ParseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code
        Parse.initialize(this, "hTMkrx4n097XQiru8UJZBhEph2ZwM1CDVS8hNkly",
                "oephWkXiMN2BiG0VdmilUK2c1K34w4gFGwAwAZ9r");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // Optionally enable public read access.
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
