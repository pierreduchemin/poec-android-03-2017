package com.poec.exercice11;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.poec.exercice11.androidService.TemperatureAndroidService;

public class MainActivity extends AppCompatActivity {

    private Intent serviceIntent;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceIntent = new Intent(this, TemperatureAndroidService.class);
        startService(serviceIntent);

        tvStatus = (TextView) findViewById(R.id.tvStatus);
        tvStatus.setText("Service démarré !");
    }

    @Override
    protected void onDestroy() {
        stopService(serviceIntent);

        tvStatus.setText("Service arrêté");

        super.onDestroy();
    }
}
