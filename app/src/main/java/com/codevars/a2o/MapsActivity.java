package com.codevars.a2o;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Setting the map type

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //adding markers

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



    }
}
