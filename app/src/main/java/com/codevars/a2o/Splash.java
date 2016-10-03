package com.codevars.a2o;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        redirect();

    }



    private void redirect() {

        Intent go = new Intent(Splash.this, Intro.class);

        finish();

        startActivity(go);

    }


}
