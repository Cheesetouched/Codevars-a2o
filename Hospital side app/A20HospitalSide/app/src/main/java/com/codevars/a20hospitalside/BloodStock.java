package com.codevars.a20hospitalside;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;


public class BloodStock extends AppCompatActivity  {

    Spinner bloodgroup;
    TextView amount;
    int globalvariable;
    Integer pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_stock);

        String bloodgroupselected;

        bloodgroup = (Spinner) findViewById(R.id.spinner6);
        amount = (TextView) findViewById(R.id.amountid);











    }


}
