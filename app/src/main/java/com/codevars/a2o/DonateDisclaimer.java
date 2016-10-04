package com.codevars.a2o;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.codevars.a2o.LocalStorage.SessionManagement;

public class DonateDisclaimer extends AppCompatActivity implements View.OnClickListener {

    private CheckBox agreement;

    private LinearLayout buttonpanel;

    private Button submit;

    private Animation slideup;

    private ActionBar bar;

    private SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_disclaimer);

        Typeface one = Typeface.createFromAsset(getAssets(), "fonts/Lato-Regular.ttf");

        bar = getSupportActionBar();

        bar.setHomeButtonEnabled(true);

        bar.setDisplayHomeAsUpEnabled(true);

        session = new SessionManagement(getApplicationContext());

        agreement = (CheckBox) findViewById(R.id.agreement);

        buttonpanel = (LinearLayout) findViewById(R.id.buttonpanel);

        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(this);

        submit.setEnabled(false);

        submit.setTypeface(one);

        buttonpanel.setBackgroundColor(Color.parseColor("#994CAF50"));

        slide();

        agreementChecker();

    }



    public void slide() {

        slideup = new TranslateAnimation(0,0,500,0);

        slideup.setDuration(1000);

        buttonpanel.setAnimation(slideup);

    }



    private void agreementChecker() {

        agreement.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (((CheckBox) v).isChecked()) {

                    submit.setEnabled(true);

                    buttonpanel.setBackgroundColor(Color.parseColor("#4CAF50"));

                }


                else {

                    submit.setEnabled(false);

                    buttonpanel.setBackgroundColor(Color.parseColor("#994CAF50"));

                }


            }
        });

    }



    @Override
    public void onClick(View view) {

        if (view == submit) {

            Toast.makeText(this, "Terms And Conditions Accepted!", Toast.LENGTH_LONG).show();

            Intent go = new Intent(this, Donate.class);

            session.createDisclaimerSession();

            finish();

            startActivity(go);

        }

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:

                Intent intent = new Intent(this, DonateRequest.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                finish();

                startActivity(intent);

                return true;

            default:

                return super.onOptionsItemSelected(item);

        }

    }



}
