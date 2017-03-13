package com.poec.recycler_view_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(10);

        RecyclerView rvMain = (RecyclerView) findViewById(R.id.rvMain);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(new NumberAdapter(numbersList));
    }
}
