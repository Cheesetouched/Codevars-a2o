package com.codevars.a2o;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class DonateRequest extends AppCompatActivity implements View.OnClickListener {

    private ImageView logo;

    private Button request;

    private Button donate;

    private Animation logoslide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_request);

        logo = (ImageView) findViewById(R.id.logo);

        request = (Button) findViewById(R.id.request);

        donate = (Button) findViewById(R.id.donate);

        slide();

    }



    private void slide() {

        logoslide = new TranslateAnimation(0,0,500,0);

        logoslide.setDuration(1000);

        logo.setAnimation(logoslide);

    }




    @Override
    public void onClick(View view) {

        if (view == request) {



        }

        if (view == donate) {



        }

    }



}
