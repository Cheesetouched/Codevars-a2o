package iconictech.codevars_a2o;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

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

    //Defining all the markers


    public Marker hospital;
    public Marker hospital2;
    public Marker hospital3;
    public Marker hospital4;
    public Marker hospital5;
    public Marker hospital6;

    //Defining all the coordinates

    private static final LatLng hosp2 = new LatLng(12.914, 80.229);
    private static final LatLng hosp3 = new LatLng(12.796, 80.217);
    private static final LatLng hosp4 = new LatLng(12.921, 80.127);
    private static final LatLng hosp5 = new LatLng(12.901, 80.228);
    private static final LatLng hosp6 = new LatLng(12.980, 80.188);









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }
}
