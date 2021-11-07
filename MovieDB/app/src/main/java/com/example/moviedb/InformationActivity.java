package com.example.moviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

    private TextView titel;
    private TextView description;
    private TextView information;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        SugarContext.init(this);

        String finalIndex = getIntent().getStringExtra("index");
        String finalGenre = getIntent().getStringExtra("genre");


        titel = findViewById(R.id.titleMovies);
        description = findViewById(R.id.information1);
        information = findViewById(R.id.information2);


        updateInfos(finalIndex, finalGenre);

        ImageButton back = (ImageButton)findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ImageButton homeButton = (ImageButton) findViewById(R.id.iconMovies);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHomepage = new Intent(InformationActivity.this, MainActivity.class);
                startActivity(goToHomepage);
            }
        });
    }

    public void updateInfos(String finalIndex, String finalGenre){
        //Einträge aussuchen

        List<Database> databases = Database.listAll(Database.class);

        List<Database> movieArray = new ArrayList<Database>();

        for (Database database : databases) {
            if(database.genre.equals(finalGenre)) {
                movieArray.add(database);
            }
        }
        int finalInput;
        try{
            finalInput = Integer.parseInt(finalIndex);
            Database movie = movieArray.get(finalInput);

            titel.setText(movie.title);
            description.setText(movie.description);
            information.setText(movie.actors + movie.resigeur + movie.lengthTime);
        }catch (NumberFormatException e) {

            titel.setText("Error");
            description.setText("Es gab ein Fehler mit dem Code bitte gehen Sie zurück und versuchen Sie es nochmals");
            information.setText("Error");

        }









    }
}
