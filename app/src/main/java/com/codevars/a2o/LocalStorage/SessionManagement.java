package com.codevars.a2o.LocalStorage;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {

    SharedPreferences pref;

    SharedPreferences.Editor editor;

    Context context;

    private static final String PREF_NAME = "A2O Pref";

    int PRIVATE_MODE = 0;

    public static final String FIRST_TIME = "ft";




    public boolean firstTime() {

        return pref.getBoolean(FIRST_TIME, true);

    }



    public void unsetFirstTime(Boolean value) {

        editor.putBoolean(FIRST_TIME,value);

        editor.commit();

    }



    public SessionManagement(Context context) {

        this.context = context;

        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);

        editor = pref.edit();

    }




}
