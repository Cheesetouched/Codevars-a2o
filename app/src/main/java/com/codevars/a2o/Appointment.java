package com.codevars.a2o;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Appointment extends AppCompatActivity implements View.OnClickListener {


    private ActionBar bar;

    private TextView datetext;

    private TextView timetext;

    private Button bookbutton;

    private Animation slideup;

    private Spinner datespinner;

    private Spinner monthspinner;

    private Spinner timespinner;

    private Spinner orientationspinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        bar = getSupportActionBar();

        bar.setHomeButtonEnabled(true);

        bar.setDisplayHomeAsUpEnabled(true);

        Typeface one = Typeface.createFromAsset(getAssets(), "fonts/Lato-Regular.ttf");

        datetext = (TextView) findViewById(R.id.datetext);

        timetext = (TextView) findViewById(R.id.timetext);

        datespinner = (Spinner) findViewById(R.id.datespinner);

        monthspinner = (Spinner) findViewById(R.id.monthspinner);

        timespinner = (Spinner) findViewById(R.id.timespinner);

        orientationspinner = (Spinner) findViewById(R.id.orientationspinner);

        datetext.setTypeface(one);

        timetext.setTypeface(one);

        bookbutton = (Button) findViewById(R.id.bookbutton);

        bookbutton.setOnClickListener(this);

        slide();


    }



    private void slide() {

        slideup = new TranslateAnimation(0,0,500,0);

        slideup.setDuration(1000);

        bookbutton.setAnimation(slideup);

    }



    private boolean online() {

        final ConnectivityManager internet = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return internet.getActiveNetworkInfo() != null && internet.getActiveNetworkInfo().isConnected();

    }



    private void check() {

        if (online()) {

            emptycheck();

        }

        else {

            Toast.makeText(Appointment.this, "You Are Not Connected To Internet!", Toast.LENGTH_SHORT).show();

        }

    }



    private void emptycheck() {


        if (datespinner.getSelectedItem().equals("Date")) {

            Toast.makeText(this, "Please Select A Date!", Toast.LENGTH_SHORT).show();

            return;

        }

        if (monthspinner.getSelectedItem().equals("Month")) {

            Toast.makeText(this, "Please Select A Month!", Toast.LENGTH_SHORT).show();

            return;

        }


        else {


            initiate();

        }


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:

                Intent intent = new Intent(this, Donate.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                finish();

                startActivity(intent);

                return true;

            default:

                return super.onOptionsItemSelected(item);

        }

    }



   @Override
    public void onClick(View view) {

       if (view == bookbutton) {



       }

   }


}
