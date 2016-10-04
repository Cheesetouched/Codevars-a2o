package com.codevars.a2o;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.codevars.a2o.LocalStorage.SessionManagement;

import java.util.HashMap;

public class DonateRequest extends AppCompatActivity implements View.OnClickListener {

    private ImageView logo;

    private Button request;

    private Button donate;

    private Animation logoslide;

    private SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_request);


        session = new SessionManagement(getApplicationContext());

        if (session.appointmentDone()) {

            donate.setEnabled(false);

            donate.setText("PENDING!");

        }

        else {



        }

        logo = (ImageView) findViewById(R.id.logo);

        request = (Button) findViewById(R.id.request);

        donate = (Button) findViewById(R.id.donate);

        request.setOnClickListener(this);

        donate.setOnClickListener(this);

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

            Toast.makeText(DonateRequest.this, "You Have To Verify Your Account First!", Toast.LENGTH_LONG).show();

        }

        if (view == donate) {

            if (session.disclaimerDone()) {

                Intent go = new Intent(this, Donate.class);

                finish();

                startActivity(go);

            }

            else {

                Intent go = new Intent(this, DonateDisclaimer.class);

                finish();

                startActivity(go);

            }


        }

    }



}
