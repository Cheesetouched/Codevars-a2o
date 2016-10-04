package com.codevars.a20hospitalside;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PendingVerifications extends AppCompatActivity {

    Button accept;
    Button deny;

    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_verifications);

        accept = (Button) findViewById(R.id.accept);
        deny = (Button) findViewById(R.id.decline);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == accept)
                {
                    load();

                }
              else  if(view == deny)
                {
                    Toast.makeText(PendingVerifications.this,"The user has been declined",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void load() {

        loading = new ProgressDialog(PendingVerifications.this, R.style.LoaderTheme);
        dismiss();
        loading.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        loading.setCancelable(false);
        loading.show();

    }

    private void dismiss() {

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {

            @Override

            public void run() {

                loading.dismiss();

                Toast.makeText(PendingVerifications.this,"The user has been verified",Toast.LENGTH_SHORT).show();

            }

        }, 3000);

    }

}
