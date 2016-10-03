package com.codevars.a2o;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.codevars.a2o.Extras.SampleSlide;
import com.github.paolorotolo.appintro.AppIntro;


public class Intro extends AppIntro {


    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(SampleSlide.newInstance(R.layout.intro_one));


        hideStatusBar();

        setFlowAnimation();

    }



    private void hideStatusBar() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Window window = getWindow();

            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        }

    }


    @Override
    public void onSkipPressed() {


    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {

        Intent go = new Intent(Intro.this, MapsActivity.class);

        finish();

        startActivity(go);

    }

    @Override
    public void onSlideChanged() {

    }

    public void getStarted(View v) {
        Toast.makeText(getApplicationContext(), getString(R.string.app_name), Toast.LENGTH_SHORT).show();
    }



}

