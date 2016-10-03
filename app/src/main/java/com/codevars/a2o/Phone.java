package com.codevars.a2o;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
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
import com.codevars.a2o.Server.RegisterUserClass;
import java.util.HashMap;


public class Phone extends AppCompatActivity implements View.OnClickListener {


    private final static String REQUEST_OTP = "http://atoo.esy.es/otp.php";

    private TextView warning;

    private EditText p1;

    private EditText p2;

    private EditText p3;

    private EditText p4;

    private EditText p5;

    private EditText p6;

    private EditText p7;

    private EditText p8;

    private EditText p9;

    private EditText p10;

    private String countrycode;

    private String mobile;

    private String phone;

    private String sendemail;

    private String otp;

    private String first;

    private String second;

    private String third;

    private String fourth;

    private String fifth;

    private String sixth;

    private String seventh;

    private String eighth;

    private String ninth;

    private String tenth;

    private Animation slideup;

    private LinearLayout layoutsubmit;

    private Button submit;

    private SessionManagement session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Typeface one = Typeface.createFromAsset(getAssets(), "fonts/Lato-Regular.ttf");

        setContentView(R.layout.activity_phone);

        session = new SessionManagement(getApplicationContext());

        HashMap<String, String> em = session.getEmail();

        sendemail = em.get(SessionManagement.EMAIL);


        p1 = (EditText) findViewById(R.id.p1);

        p2 = (EditText) findViewById(R.id.p2);

        p3 = (EditText) findViewById(R.id.p3);

        p4 = (EditText) findViewById(R.id.p4);

        p5 = (EditText) findViewById(R.id.p5);

        p6 = (EditText) findViewById(R.id.p6);

        p7 = (EditText) findViewById(R.id.p7);

        p8 = (EditText) findViewById(R.id.p8);

        p9 = (EditText) findViewById(R.id.p9);

        p10 = (EditText) findViewById(R.id.p10);

        p2.setEnabled(false);

        p3.setEnabled(false);

        p4.setEnabled(false);

        p5.setEnabled(false);

        p6.setEnabled(false);

        p7.setEnabled(false);

        p8.setEnabled(false);

        p9.setEnabled(false);

        p10.setEnabled(false);

        warning = (TextView) findViewById(R.id.warning);

        layoutsubmit = (LinearLayout) findViewById(R.id.buttonpanel);

        submit = (Button) findViewById(R.id.numberbutton);

        submit.setEnabled(false);

        layoutsubmit.setBackgroundColor(Color.parseColor("#994CAF50"));

        warning.setTypeface(one);

        submit.setTypeface(one);

        submit.setOnClickListener(this);

        textWatcher();

        hideStatusBar();

        slideup();


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

            initiate();

        }

        else {

            Toast.makeText(this, "You Are Not Connected To The Internet!", Toast.LENGTH_SHORT).show();

        }


    }



    private void initiate() {

        countrycode = "91";

        mobile = countrycode+first+second+third+fourth+fifth+sixth+seventh+eighth+ninth+tenth;

        phone = mobile.substring(2);

        otp(mobile, phone, sendemail);

    }



    private void textWatcher() {

        p1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count) {

                if(p1.getText().toString().length()==1) {

                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void afterTextChanged(Editable s) {

                if(p1.getText().toString().length()==2) {

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

            public void onTextChanged(CharSequence s, int start,int before, int count) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void afterTextChanged(Editable s) {

                if(p2.getText().toString().length()==0) {

                    p1.setSelection(p1.getText().length());

                    p1.requestFocus();

                    p2.setEnabled(false);

                }

                if(p2.getText().toString().length()==2) {

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

            public void onTextChanged(CharSequence s, int start,int before, int count) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void afterTextChanged(Editable s) {

                if(p3.getText().toString().length()==0) {

                    p2.setSelection(p2.getText().length());

                    p2.requestFocus();

                    p3.setEnabled(false);

                }

                if(p3.getText().toString().length()==2) {

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

            public void onTextChanged(CharSequence s, int start,int before, int count) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void afterTextChanged(Editable s) {

                if(p4.getText().toString().length()==0) {

                    p3.setSelection(p3.getText().length());

                    p3.requestFocus();

                    p4.setEnabled(false);

                }

                if(p4.getText().toString().length()==2) {

                    String f = p4.getText().toString();

                    p5.setText(f.substring(1));

                    p5.setEnabled(true);

                    p5.setSelection(p5.getText().length());

                    p5.requestFocus();

                    String text = p4.getText().toString();

                    p4.setText(text.substring(0, text.length() - 1));

                    fourth = p4.getText().toString();

                }

            }

        });

        p5.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void afterTextChanged(Editable s) {


                if(p5.getText().toString().length()==0) {

                    p4.setSelection(p4.getText().length());

                    p4.requestFocus();

                    p5.setEnabled(false);

                }

                if(p5.getText().toString().length()==2) {

                    String f = p5.getText().toString();

                    p6.setText(f.substring(1));

                    p6.setEnabled(true);

                    p6.setSelection(p6.getText().length());

                    p6.requestFocus();

                    String text = p5.getText().toString();

                    p5.setText(text.substring(0, text.length() - 1));

                    fifth = p5.getText().toString();

                }

            }

        });

        p6.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void afterTextChanged(Editable s) {

                if(p6.getText().toString().length()==0) {

                    p5.setSelection(p5.getText().length());

                    p5.requestFocus();

                    p6.setEnabled(false);

                }

                if(p6.getText().toString().length()==2) {

                    String si = p6.getText().toString();

                    p7.setText(si.substring(1));

                    p7.setEnabled(true);

                    p7.setSelection(p7.getText().length());

                    p7.requestFocus();

                    String text = p6.getText().toString();

                    p6.setText(text.substring(0, text.length() - 1));

                    sixth = p6.getText().toString();

                }

            }

        });

        p7.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void afterTextChanged(Editable s) {

                if(p7.getText().toString().length()==0) {

                    p6.setSelection(p6.getText().length());

                    p6.requestFocus();

                    p7.setEnabled(false);

                }

                if(p7.getText().toString().length()==2) {

                    String se = p7.getText().toString();

                    p8.setText(se.substring(1));

                    p8.setEnabled(true);

                    p8.setSelection(p8.getText().length());

                    p8.requestFocus();

                    String text = p7.getText().toString();

                    p7.setText(text.substring(0, text.length() - 1));

                    seventh = p7.getText().toString();

                }


            }

        });

        p8.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void afterTextChanged(Editable s) {

                if(p8.getText().toString().length()==0) {

                    p7.setSelection(p7.getText().length());

                    p7.requestFocus();

                    p8.setEnabled(false);

                }

                if(p8.getText().toString().length()==2) {

                    String e = p8.getText().toString();

                    p9.setText(e.substring(1));

                    p9.setEnabled(true);

                    p9.setSelection(p9.getText().length());

                    p9.requestFocus();

                    String text = p8.getText().toString();

                    p8.setText(text.substring(0, text.length() - 1));

                    eighth = p8.getText().toString();

                }

            }

        });

        p9.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void afterTextChanged(Editable s) {

                if(p9.getText().toString().length()==0) {

                    p8.setSelection(p8.getText().length());

                    p8.requestFocus();

                    p9.setEnabled(false);

                }

                if(p9.getText().toString().length()==2) {

                    String n = p9.getText().toString();

                    p10.setText(n.substring(1));

                    p10.setEnabled(true);

                    p10.setSelection(p10.getText().length());

                    p10.requestFocus();

                    String text = p9.getText().toString();

                    p9.setText(text.substring(0, text.length() - 1));

                    ninth = p9.getText().toString();

                }

            }

        });

        p10.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void afterTextChanged(Editable s) {

                if(p10.getText().toString().length()==0) {

                    p9.setSelection(p9.getText().length());

                    p9.requestFocus();

                    p10.setEnabled(false);

                    submit.setEnabled(false);

                    layoutsubmit.setBackgroundColor(Color.parseColor("#994CAF50"));

                }

                if(p10.getText().toString().length()==1) {

                    tenth = p10.getText().toString();

                    layoutsubmit.setBackgroundColor(Color.parseColor("#4CAF50"));

                    submit.setEnabled(true);

                }


            }

        });


    }



    private void otp(String mobile, final String phone, String email) {

        class requestOTP extends AsyncTask<String, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                loading = new ProgressDialog(Phone.this, R.style.LoaderTheme);
                loading.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
                loading.setCancelable(false);
                loading.show();

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();

                if (s.length() == 4) {

                    Toast.makeText(Phone.this, "OTP Sent!", Toast.LENGTH_LONG).show();

                    otp = s;

                    session.createNumberSession(phone, otp);

                    Intent go = new Intent(Phone.this, VerifyOTP.class);

                    finish();

                    startActivity(go);

                }

                else {

                    Toast.makeText(Phone.this, s, Toast.LENGTH_LONG).show();

                }

            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> credentials = new HashMap<>();

                credentials.put("mobile", params[0]);

                credentials.put("phone", params[1]);

                credentials.put("email", params[2]);

                RegisterUserClass ruc = new RegisterUserClass();

                String result = ruc.sendPostRequest(REQUEST_OTP, credentials);

                return result;

            }

        }

        requestOTP attempt = new requestOTP();

        attempt.execute(mobile, phone, email);

    }



    @Override
    public void onClick(View view) {

        if (view == submit) {

            check();

        }

    }



}
