package com.codevars.a2o.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.codevars.a2o.R;
import com.codevars.a2o.Server.RegisterUserClass;

import java.util.HashMap;


public class Register extends Fragment implements  View.OnClickListener {


    private static final String REGISTER_URL = "http://atoo.esy.es/register.php";

    private EditText fullname;

    private EditText email;

    private EditText password;

    private Spinner bloodgroup;

    private Spinner convention;

    private LinearLayout slide;

    private Button registerbutton;

    private Animation slideup;


    public Register() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Typeface one = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Lato-Light.ttf");

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        fullname = (EditText) view.findViewById(R.id.fullname);

        email = (EditText) view.findViewById(R.id.email);

        password = (EditText) view.findViewById(R.id.password);

        bloodgroup = (Spinner) view.findViewById(R.id.bloodgroup);

        convention = (Spinner) view.findViewById(R.id.convention);

        slide = (LinearLayout) view.findViewById(R.id.buttonpanel);

        registerbutton = (Button) view.findViewById(R.id.registerbutton);

        registerbutton.setOnClickListener(this);

        fullname.setTypeface(one);

        email.setTypeface(one);

        password.setTypeface(one);

        registerbutton.setTypeface(one);

        slide();

        return view;

    }



    private void slide() {

        slideup = new TranslateAnimation(0,0,500,0);

        slideup.setDuration(1000);

        slide.setAnimation(slideup);

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

        if (fullname.getText().toString().trim().matches("")) {

            Toast.makeText(getContext(), "Please Enter Your Fullname!", Toast.LENGTH_SHORT).show();

            return;

        }

        if (email.getText().toString().trim().matches("")) {

            Toast.makeText(getContext(), "Please Enter Your Email!", Toast.LENGTH_SHORT).show();

            return;

        }

        if (password.getText().toString().trim().matches("")) {

            Toast.makeText(getContext(), "Please Enter Your Password!", Toast.LENGTH_SHORT).show();

            return;

        }

        if (bloodgroup.getSelectedItem().equals("Select")) {

            Toast.makeText(getContext(), "Please Enter Your Group!", Toast.LENGTH_SHORT).show();

            return;

        }

        if (convention.getSelectedItem().equals("Select")) {

            Toast.makeText(getContext(), "Please Select Your Convention!", Toast.LENGTH_SHORT).show();

            return;

        }

        else {


            initiate();

        }


    }



    private void initiate() {

        String fn = fullname.getText().toString().trim();

        String em = email.getText().toString().trim();

        String ps = password.getText().toString().trim();

        String gp = bloodgroup.getSelectedItem().toString();

        String cv = convention.getSelectedItem().toString();

        String bg = gp + cv;

        register(fn, em, ps, bg);

    }



    private void register(String fn, final String em, String ps, String bg) {

        class RegisterClass extends AsyncTask<String, Void, String > {

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

                if (s.equalsIgnoreCase("Successfully Registered!")) {

                    Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();

                    fullname.getText().clear();

                    email.getText().clear();

                    password.getText().clear();

                    bloodgroup.setSelection(0);

                    convention.setSelection(0);

                    TabLayout host = (TabLayout) getActivity().findViewById(R.id.tablayout);

                    TabLayout.Tab tab = host.getTabAt(0);

                    tab.select();

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

                credentials.put("fullname", params[0]);

                credentials.put("email", params[1]);

                credentials.put("password", params[2]);

                credentials.put("bloodgroup", params[3]);

                RegisterUserClass ruc = new RegisterUserClass();

                String result = ruc.sendPostRequest(REGISTER_URL, credentials);

                return result;

            }

        }

        RegisterClass attempt = new RegisterClass();

        attempt.execute(fn, em, ps, bg);

    }



    @Override
    public void onClick(View view) {

        if (view == registerbutton) {

            check();

        }

    }



}
