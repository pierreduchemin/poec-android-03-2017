package com.poec.exercice7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onEvent(MyEvent event) {
        Toast.makeText(this, "Message déclenché depuis l'EventBus !", Toast.LENGTH_LONG).show();
    }

    public void onClickAdditionner(View view) {
        EventBus.getDefault().post(new MyEvent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    class MyEvent {
    }
}
