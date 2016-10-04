package com.codevars.a2o.Extras;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.codevars.a2o.LocalStorage.SessionManagement;
import com.codevars.a2o.LoginRegisterTabbed;
import com.codevars.a2o.R;
import com.github.paolorotolo.appintro.AppIntro;


public class Intro extends AppIntro {


    private SessionManagement session;


    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(SampleSlide.newInstance(R.layout.intro_one));
        addSlide(SampleSlide.newInstance(R.layout.intro_two));
        addSlide(SampleSlide.newInstance(R.layout.intro_three));
        addSlide(SampleSlide.newInstance(R.layout.intro_four));

        session = new SessionManagement(getApplicationContext());

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

        session.createSplashSession();

        Intent go = new Intent(Intro.this, LoginRegisterTabbed.class);

        finish();

        startActivity(go);

    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {

        session.createSplashSession();

        Intent go = new Intent(Intro.this, LoginRegisterTabbed.class);

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

