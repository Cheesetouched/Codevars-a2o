package com.codevars.a2o.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.codevars.a2o.LocalStorage.SessionManagement;
import com.codevars.a2o.Phone;
import com.codevars.a2o.R;
import com.codevars.a2o.Server.RegisterUserClass;
import com.google.android.gms.vision.text.Line;

import java.util.HashMap;


public class Login extends Fragment implements View.OnClickListener {


    private static final String LOGIN_URL = "http://atoo.esy.es/login.php";

    private EditText email;

    private EditText password;

    private Button submit;

    private LinearLayout slider;

    private Animation slideup;

    private SessionManagement session;


    public Login() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        session = new SessionManagement(getContext());

        session.login();

        session.phone();

        session.otp();

        Typeface one = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Lato-Light.ttf");

        View view =  inflater.inflate(R.layout.fragment_login, container, false);

        email = (EditText) view.findViewById(R.id.email);

        password = (EditText) view.findViewById(R.id.password);

        submit = (Button) view.findViewById(R.id.loginbutton);

        slider = (LinearLayout) view.findViewById(R.id.buttonpanel);

        submit.setOnClickListener(this);

        email.setTypeface(one);

        password.setTypeface(one);

        submit.setTypeface(one);

        slide();


        return view;


    }



    private void slide() {

        slideup = new TranslateAnimation(0,0,500,0);

        slideup.setDuration(1000);

        slider.setAnimation(slideup);

    }



    private boolean online() {

        final ConnectivityManager internet = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        return internet.getActiveNetworkInfo() != null && internet.getActiveNetworkInfo().isConnected();

    }



    private void check() {

        if (online()) {

            emptycheck();

        }

        else {

            Toast.makeText(getContext(), "You Are Not Connected To Internet!", Toast.LENGTH_SHORT).show();

        }

    }



    private void emptycheck() {

        if (email.getText().toString().trim().matches("")) {

            Toast.makeText(getContext(), "Please Enter Your Email!", Toast.LENGTH_SHORT).show();

            return;

        }

        if (password.getText().toString().trim().matches("")) {

            Toast.makeText(getContext(), "Please Enter Your Password!", Toast.LENGTH_SHORT).show();

            return;

        }

        else {


            initiate();

        }


    }



    private void initiate() {

        String em = email.getText().toString().trim();

        String pass = password.getText().toString().trim();

        login(em, pass);

    }



    private void login(final String em, final String pass) {

        class LoginUserClass extends AsyncTask<String, Void, String > {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                loading = new ProgressDialog(getContext(), R.style.LoaderTheme);
                loading.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
                loading.setCancelable(false);
                loading.show();

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();

                if (s.equalsIgnoreCase("Successfully Logged In!")) {

                    Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();

                    session.createLoginSession(em);

                    Intent go = new Intent(getContext(), Phone.class);

                    getActivity().finish();

                    startActivity(go);

                    return;

                }

                if (s.equalsIgnoreCase("")) {

                    Toast.makeText(getContext(), "Unstable Connection!", Toast.LENGTH_SHORT).show();

                }

                else {

                    Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();

                    return;

                }

            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> credentials = new HashMap<>();

                credentials.put("email", params[0]);

                credentials.put("password", params[1]);

                RegisterUserClass ruc = new RegisterUserClass();

                String result = ruc.sendPostRequest(LOGIN_URL, credentials);

                return result;

            }

        }

        LoginUserClass attempt = new LoginUserClass();

        attempt.execute(em, pass);

    }



    @Override
    public void onClick(View view) {

        if (view == submit) {

            check();

        }

    }



}
