package com.codevars.a2o.Extras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codevars.a2o.Fragments.Login;
import com.codevars.a2o.Intro;
import com.codevars.a2o.LocalStorage.SessionManagement;

public class Splash extends AppCompatActivity {


    private SessionManagement session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        session = new SessionManagement(getApplicationContext());

        redirect();

    }



    private void redirect() {

        if (session.firstTime()) {

            Intent go = new Intent(Splash.this, Intro.class);

            finish();

            startActivity(go);

        }

        else {

            Intent go = new Intent(Splash.this, Login.class);

            finish();

            startActivity(go);

        }

    }


}
