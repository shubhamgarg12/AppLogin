package com.example.cardview.applogin;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

    ProgressDialog progressDialog;
    CoordinatorLayout coordinatorLayout;
    ConnectivityManager connMgr;
    NetworkInfo networkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);
        progressDialog.show();
        progressDialog.setMessage("Loading");
        coordinatorLayout =(CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
         networkInfo = connMgr.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){
            progressDialog.dismiss();
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else{

            Snackbar snackbar =Snackbar.make(coordinatorLayout,"No Internet Connection",Snackbar.LENGTH_SHORT);



        }
    }

}
