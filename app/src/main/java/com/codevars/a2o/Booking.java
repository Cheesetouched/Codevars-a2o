package com.codevars.a2o;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Booking extends AppCompatActivity {

    private TextView hospital;

    private TextView address;

    private Button contact;

    private Button appointment;

    private ActionBar bar;

    String h1;
    String h2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_booking);

        bar = getSupportActionBar();

        bar.setHomeButtonEnabled(true);

        bar.setDisplayHomeAsUpEnabled(true);

        Typeface one = Typeface.createFromAsset(getAssets(), "fonts/Lato-Light.ttf");

        Intent intent = getIntent();
        h1 = intent.getStringExtra("hn");
        h2 = intent.getStringExtra("ha");


        hospital = (TextView) findViewById(R.id.hospitalname);

        hospital.setText(h1);


        TextView textView1 = (TextView) findViewById(R.id.hospitaladdress);
        textView1.setText(h2);


        appointment = (Button) findViewById(R.id.appointmentbutton);

        appointment.setTypeface(one);


        contact = (Button) findViewById(R.id.contactbutton);

        contact.setTypeface(one);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:09717372697"));
                startActivity(intent);
            }
        });


        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Booking.this, Appointment.class);

                finish();

                startActivity(intent);
            }
        });

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

}
