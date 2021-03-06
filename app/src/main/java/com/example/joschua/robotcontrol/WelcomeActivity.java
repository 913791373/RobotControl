package com.example.joschua.robotcontrol;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    //SPLASH_TIME_OUT defines how long the animation is being showed
    private static int SPLASH_TIME_OUT = 6000;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        context = WelcomeActivity.this;

        //activate bluetooth for upcoming activity
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.enable();
        }

        //Handler to move on the next acitivty after SPLASH_TIME_OUT
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent searchIntent = new Intent(getApplicationContext(), ScanActivity.class);
                startActivity(searchIntent);
            }
        }, SPLASH_TIME_OUT);
    }
}
