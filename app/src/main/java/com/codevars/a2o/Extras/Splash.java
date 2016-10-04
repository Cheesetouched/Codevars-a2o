package com.codevars.a2o.Extras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codevars.a2o.LocalStorage.SessionManagement;
import com.codevars.a2o.LoginRegisterTabbed;

public class Splash extends AppCompatActivity {


    private SessionManagement session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        session = new SessionManagement(getApplicationContext());

        redirect();

    }



    private void redirect() {

        if (session.introDone()) {

            Intent go = new Intent(this, LoginRegisterTabbed.class);

            finish();

            startActivity(go);

        }

        else {

            Intent go = new Intent(this, Intro.class);

            finish();

            startActivity(go);

        }

    }


}
