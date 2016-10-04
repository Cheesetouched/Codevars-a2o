package com.codevars.a20hospitalside;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class RequestBlood extends AppCompatActivity {

    Spinner hospital;
    Spinner amount;
    Spinner bloodgroup;
    Spinner bloodsign;

    String hospitalstring;
    String amountstring;
    String bloodgroupstring;
    String bloodsignstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_blood);

        hospital = (Spinner) findViewById(R.id.hospitalspinner);
        amount = (Spinner) findViewById(R.id.amountspinner);
        bloodgroup = (Spinner) findViewById(R.id.spinnerbloodgroup);
        bloodsign = (Spinner) findViewById(R.id.spinner3);

       hospitalstring =  hospital.getSelectedItem().toString();
        amountstring = amount.getSelectedItem().toString();
        bloodgroupstring = bloodgroup.getSelectedItem().toString();
        bloodgroupstring = bloodsign.getSelectedItem().toString();


    }
}
