package com.codevars.a2o;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codevars.a2o.LocalStorage.SessionManagement;

import java.util.HashMap;

public class VerifyOTP extends AppCompatActivity implements View.OnClickListener {


    private final static String REQUEST_OTP = "http://atoo.esy.es/otp.php";

    private EditText p1;

    private EditText p2;

    private EditText p3;

    private EditText p4;

    private String first;

    private String second;

    private String third;

    private String fourth;

    private String otpcheck;

    private String otpfinal;

    private String phonenumber;

    private Animation slideup;

    private LinearLayout layoutsubmit;

    private Button submit;

    private SessionManagement session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        Typeface one = Typeface.createFromAsset(getAssets(), "fonts/Lato-Regular.ttf");

        setContentView(R.layout.activity_phone);

        session = new SessionManagement(getApplicationContext());

        HashMap<String, String> phone = session.getPhoneNumber();

        HashMap<String, String> otp = session.getOTPDetails();

        phonenumber = phone.get(SessionManagement.MOBILE);

        otpcheck = otp.get(SessionManagement.OTP);

        p1 = (EditText) findViewById(R.id.p1);

        p2 = (EditText) findViewById(R.id.p2);

        p3 = (EditText) findViewById(R.id.p3);

        p4 = (EditText) findViewById(R.id.p4);

        p2.setEnabled(false);

        p3.setEnabled(false);

        p4.setEnabled(false);

        layoutsubmit = (LinearLayout) findViewById(R.id.buttonpanel);

        submit = (Button) findViewById(R.id.otpsubmit);

        submit.setEnabled(false);

        layoutsubmit.setBackgroundColor(Color.parseColor("#994CAF50"));

        submit.setTypeface(one);

        submit.setOnClickListener(this);

        hideStatusBar();

        slideup();

        textWatcher();


    }



    public void hideStatusBar() {

        Window window = getWindow();

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.setStatusBarColor(Color.BLACK);

    }



    private void slideup() {

        slideup = new TranslateAnimation(0,0,500,0);

        slideup.setDuration(1000);

        layoutsubmit.setAnimation(slideup);

    }



    private boolean online() {

        final ConnectivityManager internet = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return internet.getActiveNetworkInfo() != null && internet.getActiveNetworkInfo().isConnected();

    }



    private void check() {


        if (online()) {

            verify();

        }

        else {

            Toast.makeText(this, "You Are Not Connected To The Internet!", Toast.LENGTH_SHORT).show();

        }


    }



    private void verify() {

        otpfinal = first+second+third+fourth;

        if (otpfinal.equals(otpcheck)) {

            Toast.makeText(this, "Verified!", Toast.LENGTH_SHORT).show();

        }

        else {

            Toast.makeText(this, "Incorrect OTP!", Toast.LENGTH_SHORT).show();

        }

    }



    private void textWatcher() {

        p1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (p1.getText().toString().length() == 1) {

                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {

                if (p1.getText().toString().length() == 2) {

                    String o = p1.getText().toString();

                    p2.setText(o.substring(1));

                    p2.setEnabled(true);

                    p2.setSelection(p2.getText().length());

                    p2.requestFocus();

                    String text = p1.getText().toString();

                    p1.setText(text.substring(0, text.length() - 1));

                    first = p1.getText().toString();

                }

            }

        });

        p2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {

                if (p2.getText().toString().length() == 0) {

                    p1.setSelection(p1.getText().length());

                    p1.requestFocus();

                    p2.setEnabled(false);

                }

                if (p2.getText().toString().length() == 2) {

                    String t = p2.getText().toString();

                    p3.setText(t.substring(1));

                    p3.setEnabled(true);

                    p3.setSelection(p3.getText().length());

                    p3.requestFocus();

                    String lol = p2.getText().toString();

                    p2.setText(lol.substring(0, lol.length() - 1));

                    second = p2.getText().toString();

                }

            }

        });

        p3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {

                if (p3.getText().toString().length() == 0) {

                    p2.setSelection(p2.getText().length());

                    p2.requestFocus();

                    p3.setEnabled(false);

                }

                if (p3.getText().toString().length() == 2) {

                    String t = p3.getText().toString();

                    p4.setText(t.substring(1));

                    p4.setEnabled(true);

                    p4.setSelection(p4.getText().length());

                    p4.requestFocus();

                    String text = p3.getText().toString();

                    p3.setText(text.substring(0, text.length() - 1));

                    third = p3.getText().toString();

                }

            }

        });

        p4.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {

                if (p4.getText().toString().length() == 0) {

                    p3.setSelection(p3.getText().length());

                    p3.requestFocus();

                    p4.setEnabled(false);

                }

                if (p4.getText().toString().length() == 1) {

                    fourth = p4.getText().toString();

                    layoutsubmit.setBackgroundColor(Color.parseColor("#4CAF50"));

                    submit.setEnabled(true);

                }

            }

        });

    }



    @Override
    public void onClick(View view) {

        if (view == submit) {

            check();

        }

    }



}
