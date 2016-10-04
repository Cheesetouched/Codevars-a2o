package com.codevars.a2o;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Appointment extends AppCompatActivity implements View.OnClickListener {


    private ActionBar bar;

    private TextView datetext;

    private TextView timetext;

    private Button bookbutton;


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

        datetext.setTypeface(one);

        timetext.setTypeface(one);


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

   }


}
