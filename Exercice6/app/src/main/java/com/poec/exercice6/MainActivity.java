package com.poec.exercice6;

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

        List<String> commentsList = new ArrayList<>();
        commentsList.add("Recette super rapide et excellente. rien à rajouter. J'ai également mis des champignons frais également.");
        commentsList.add("Impeccable !");
        commentsList.add("Bonne recette.");
        commentsList.add("Impeccable !");
        commentsList.add("Bonne recette.");
        commentsList.add("Impeccable !");
        commentsList.add("Bonne recette.");
        commentsList.add("Impeccable !");
        commentsList.add("Bonne recette.");
        commentsList.add("Impeccable !");
        commentsList.add("Bonne recette.");
        commentsList.add("Impeccable !");
        commentsList.add("Bonne recette.");
        commentsList.add("Impeccable !");
        commentsList.add("Bonne recette.");
        commentsList.add("Très bonne recette facile à faire, j'aime bien y ajouter des olives vertes !!");

        RecyclerView rvMain = (RecyclerView) findViewById(R.id.rvMain);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(new CommentAdapter(commentsList));
    }
}
