package com.codevars.a20hospitalside;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView androidGridView;

    String[] gridViewString = {
            "Pending Verifications", "All members", "Blood stock",   "Request blood","Support","Emergency request",

    } ;
    int[] gridViewImageId = {
            R.drawable.exclamation, R.drawable.team1, R.drawable.stock,  R.drawable.request, R.drawable.team,R.drawable.heart,


    };

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(MainActivity.this, gridViewString, gridViewImageId);
        androidGridView=(GridView)findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            private static final int option1 = 0;
            private static final int option2 = 1;
            private static final int option3 = 2;
            private static final int option4 = 3;
            private static final int option5 = 4;
            private static final int option6 = 5;

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {



                switch (i) {
                    case option1:
                        Intent intent1 = new Intent(MainActivity.this, PendingVerifications.class);
                        startActivity(intent1);
                        break;
                    case option2:
                        Intent intent2 = new Intent(MainActivity.this, AllMembers.class);
                        startActivity(intent2);
                        break;
                    case option3:
                        Intent intent3 = new Intent(MainActivity.this, BloodStock.class);
                        startActivity(intent3);
                        break;
                    case option4:
                        Intent intent4 = new Intent(MainActivity.this, RequestBlood.class);
                        startActivity(intent4);
                        break;
                    case option5:
                        Intent intent5 = new Intent(MainActivity.this, Team.class);
                        startActivity(intent5);
                        break;
                    case option6:
                        Intent intent6 = new Intent(MainActivity.this, EmergencyRequest.class);
                        startActivity(intent6);
                        break;

                    default:
                        return;


                }

            }
        });


    }
}