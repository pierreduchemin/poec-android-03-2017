package com.poec.exercice11.androidService;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.poec.exercice11.R;
import com.poec.exercice11.model.Data;
import com.poec.exercice11.model.Forecast;
import com.poec.exercice11.service.ForecastAPIService;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TemperatureAndroidService extends Service {

    private static final int NOTIF_ID = 10354;

    private static final int MIN_TEMPERATURE = 16;
    private static final int INTERVAL_SECONDS = 20;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                checkWeatherApi();

                handler.postDelayed(this, INTERVAL_SECONDS * 1000);
            }
        });
    }

    public void checkWeatherApi() {

        ForecastAPIService.getInstance().getForecast("rouen").enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(TemperatureAndroidService.this, "Erreur du serveur", Toast.LENGTH_SHORT).show();
                    return;
                }

                Data weatherData = response.body().getData();
                if (isWeatherCold(Integer.valueOf(weatherData.getTemperature()))) {

                    NotificationCompat.Builder builder =
                            new NotificationCompat.Builder(TemperatureAndroidService.this)
                                    .setSmallIcon(R.drawable.ic_snow)
                                    .setContentTitle("Alerte")
                                    .setContentText(String.format(Locale.FRENCH, "Température basse ! (%.0f°C)", weatherData.getCelciusTemperature()));

                    final NotificationManager notification = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    notification.notify(NOTIF_ID, builder.build());
                }
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Toast.makeText(TemperatureAndroidService.this, "Impossible de contacter le serveur", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isWeatherCold(int temperature) {
        return temperature < MIN_TEMPERATURE;
    }
}
