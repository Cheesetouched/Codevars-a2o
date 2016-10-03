package com.codevars.a2o;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Booking extends AppCompatActivity {

    //Defining strings

    String h1;
    String h2;

    //Defining Textviews (Currently useless)
    TextView textView;
    TextView textview2;

    //Defining Buttons and other shit

    Button contacthospital;
    Button bookappointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Intent intent = getIntent();
        h1 = intent.getStringExtra("hn");
        h2 = intent.getStringExtra("ha");




        TextView textView = (TextView) findViewById(R.id.hospitalname);
        textView.setText(h1);

        TextView textView1 = (TextView) findViewById(R.id.hospitaladdress);
        textView1.setText(h2);

        Button contact = (Button) findViewById(R.id.contactbutton);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9717372697"));
                startActivity(intent);
            }
        });

    }
}
