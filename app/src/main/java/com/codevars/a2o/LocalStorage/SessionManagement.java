package com.codevars.a2o.LocalStorage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.codevars.a2o.DonateRequest;
import com.codevars.a2o.Phone;
import com.codevars.a2o.VerifyOTP;

import java.util.HashMap;

public class SessionManagement {


    SharedPreferences pref;

    SharedPreferences.Editor editor;

    Context context;

    int PRIVATE_MODE = 0;


    private static final String PREF_NAME = "A2O Pref";

    public static final String INTRO = "No";

    public static final String LOGIN = "Nah";

    public static final String NUMBER = "Nao";

    public static final String ONETIMEPASSWORD = "Unh";

    public static final String DISCLAIMER = "Nupa";

    public static final String APPOINTMENT = "Nahi";

    public static final String EMAIL = "EMAIL";

    public static final String MOBILE = "MOBILE";

    public static final String OTP = "OTP";



    public SessionManagement(Context context) {

        this.context = context;

        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);

        editor = pref.edit();

    }



    public void createSplashSession() {

        editor.putBoolean(INTRO, true);

        editor.commit();

    }



    public void createLoginSession(String email) {

        editor.putString(EMAIL, email);

        editor.putBoolean(LOGIN, true);

        editor.commit();

    }



    public void createNumberSession(String mobile, String otp) {

        editor.putString(MOBILE, mobile);

        editor.putString(OTP, otp);

        editor.putBoolean(LOGIN, false);

        editor.putBoolean(NUMBER, true);

        editor.commit();

    }



    public void createOTPSession() {

        editor.putBoolean(NUMBER, false);

        editor.putBoolean(ONETIMEPASSWORD, true);

        editor.commit();

    }



    public void createDisclaimerSession() {

        editor.putBoolean(DISCLAIMER, true);

        editor.commit();

    }



    public void createAppointmentSession() {

        editor.putBoolean(APPOINTMENT, true);

        editor.commit();

    }



    public void login() {

        if (this.loginDone()) {

            Intent i = new Intent(context, Phone.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(i);

        }

    }



    public void phone() {

        if (this.phoneDone()) {

            Intent i = new Intent(context, VerifyOTP.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(i);

        }

    }



    public void otp() {

        if (this.otpDone()) {

            Intent i = new Intent(context, DonateRequest.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(i);

        }

    }



    public void disclaimer() {

        if (this.disclaimerDone()) {

            Intent i = new Intent(context, DonateRequest.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(i);

        }

    }





    public HashMap<String,String> getEmail() {

        HashMap<String, String> email = new HashMap<>();

        email.put(EMAIL, pref.getString(EMAIL, null));

        return email;

    }



    public HashMap<String, String> getPhoneNumber() {

        HashMap<String, String> phone = new HashMap<>();

        phone.put(MOBILE, pref.getString(MOBILE, null));

        return phone;

    }



    public HashMap<String, String> getOTPDetails() {

        HashMap<String, String> otp = new HashMap<>();

        otp.put(OTP, pref.getString(OTP, null));

        return otp;

    }



    public HashMap<String, String> getAppointmentDetails() {

        HashMap<String, String> appointment = new HashMap<>();

        appointment.put(APPOINTMENT, pref.getString(APPOINTMENT, null));

        return appointment;

    }



    public boolean introDone() { return pref.getBoolean(INTRO, false); }

    public boolean loginDone() { return pref.getBoolean(LOGIN, false); }

    public boolean phoneDone() { return pref.getBoolean(NUMBER, false); }

    public boolean otpDone() { return pref.getBoolean(ONETIMEPASSWORD, false); }

    public boolean disclaimerDone() { return pref.getBoolean(DISCLAIMER, false); }

    public boolean appointmentDone() { return pref.getBoolean(DISCLAIMER, false); }



}

