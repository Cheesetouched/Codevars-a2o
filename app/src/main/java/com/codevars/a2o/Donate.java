package com.codevars.a2o;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.purchase.InAppPurchase;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Donate extends FragmentActivity implements OnMapReadyCallback {

    //Variables

    private GoogleMap mMap;
    private ArrayAdapter arrayAdapter;
    private ListView lvmenu;

    //Defining all the markers


    public Marker hospital1;
    public Marker hospital2;
    public Marker hospital3;
    public Marker hospital4;
    public Marker hospital5;
    public Marker hospital6;
    public Marker hospital7;
    public Marker hospital8;

    //Defining all the coordinates (Temporary, Later will get them from database)

    private static final LatLng hosp1 = new LatLng(12.914, 80.229);
    private static final LatLng hosp2 = new LatLng(12.796, 80.217);
    private static final LatLng hosp3 = new LatLng(12.9214212, 80.1275567);
    private static final LatLng hosp4 = new LatLng(12.901, 80.228);
    private static final LatLng hosp5 = new LatLng(12.92195, 80.14181);
    private static final LatLng hosp6 = new LatLng(12.9219437,80.141812);
    private static final LatLng hosp7 = new LatLng(12.901294,80.228543);

    //defining all the addresses of the hospitals

    String hospitaladdress1 = "2/319, OMR, Karapakkam, Chennai, Tamil Nadu 600097";
    String hospitaladdress2 = "Rajiv Gandhi Salai,Kelambakkam, Kanchipuram Dist, Chennai, Tamil Nadu 603103";
    String hospitaladdress3 = "No. 9, IAF Road, Near Madras Christian College, Duraiswamy Nagar, East, Tambaram, Chennai, Tamil Nadu 600059";
    String hospitaladdress4 = "Life care hospital, Perumbakkam main road, sholinganallur";
    String hospitaladdress5 = "Kannan Avenue, New Balaji Nagar Main Road, Selaiyur, Near Camp Road Junction, East Tambaram, Chennai, Tamil Nadu 600073";
    String hospitaladdress6 = "2nd E St, Thiruvanmiyur, Chennai, Tamil Nadu 600041";
    String hospitaladdress7 = "SRM Nagar, Potheri Village, Kattankulathur, Kanchipuram, Tamil Nadu 603203";




    //defining all the names of the hospitals
    String hospitalname1 = "Apollo Cradle";
    String hospitalname2 = "Chettinad Hospital urban health care";
    String hospitalname3 = "COSH - Multispeciality Hospital";
    String hospitalname4 = "Life care hospital";
    String hospitalname5 = "Medicity Hospital";
    String hospitalname6 = "Swaram Hospital";
    String hospitalname7 = "SRM General Hospital";




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        final String[] hospitalarray = {"Apollo Cradle","Chettinad hospital urban health care","COSH - Multispeciality Hospital","Life Care Hospital","Medicity Hospital","Swaram Hospital"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simpleitemlist,hospitalarray);
        lvmenu = (ListView) findViewById(R.id.listview);
        lvmenu.setAdapter(adapter);
        lvmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            private static final int ho1 = 0;
            private static final int ho2 = 1;
            private static final int ho3 = 2;
            private static final int ho4 = 3;
            private static final int ho5 = 4;
            private static final int ho6 = 5;
            private static final int ho7 = 6;


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case ho1:
                        Intent intent = new Intent(Donate.this,Booking.class);
                        intent.putExtra("hn",hospitalname1);
                        intent.putExtra("ha",hospitaladdress1);
                        startActivity(intent);

                        break;

                    case ho2:
                        Intent intent2 = new Intent(Donate.this,Booking.class);
                        intent2.putExtra("hn",hospitalname2);
                        intent2.putExtra("ha",hospitaladdress2);
                        startActivity(intent2);
                        break;
                    case ho3:
                        Intent intent3 = new Intent(Donate.this,Booking.class);
                        intent3.putExtra("hn",hospitalname3);
                        intent3.putExtra("ha",hospitaladdress3);
                        startActivity(intent3);
                        break;
                    case ho4:
                        Intent intent4 = new Intent(Donate.this,Booking.class);
                        intent4.putExtra("hn",hospitalname4);
                        intent4.putExtra("ha",hospitaladdress4);
                        startActivity(intent4);
                        break;
                    case ho5:
                        Intent intent5 = new Intent(Donate.this,Booking.class);
                        intent5.putExtra("hn",hospitalname5);
                        intent5.putExtra("ha",hospitaladdress5);
                        startActivity(intent5);
                        break;
                    case ho6:
                        Intent intent6 = new Intent(Donate.this,Booking.class);
                        intent6.putExtra("hn",hospitalname6);
                        intent6.putExtra("ha",hospitaladdress6);
                        startActivity(intent6);
                        break;
                    case ho7:
                        Intent intent7 = new Intent(Donate.this,Booking.class);
                        intent7.putExtra("hn",hospitalname7);
                        intent7.putExtra("ha",hospitaladdress7);
                        startActivity(intent7);
                        break;

                }



            }
        });
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Setting the map type

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //adding markers

        final LatLng ktr = new LatLng(12.8242, 80.0443);
        mMap.addMarker(new MarkerOptions().position(ktr));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ktr));

        hospital1 =  mMap.addMarker(new MarkerOptions()
                .title("Apollo Cradle")
                .position(hosp1));

        hospital2 = mMap.addMarker(new MarkerOptions()
                .title("Chettinad hospital urban health care")
                .position(hosp2));

        hospital3 = mMap.addMarker(new MarkerOptions()
                .title("COSH - Multispeciality Hospital")
                .position(hosp3));

        hospital4 = mMap.addMarker(new MarkerOptions()
                .title("Life Care Hospital")
                .position(hosp4));

        hospital5 = mMap.addMarker(new MarkerOptions()
                .title("Medicity Hospital")
                .position(hosp5));

        hospital6 = mMap.addMarker(new MarkerOptions()
                .title("Medicity Hospital")
                .position(hosp6));

        hospital7 = mMap.addMarker(new MarkerOptions()
                .title("Swaram Hospital")
                .position(hosp7));

        CameraUpdate zoom = CameraUpdateFactory.zoomTo(9);

        mMap.animateCamera(zoom);




    }
}
