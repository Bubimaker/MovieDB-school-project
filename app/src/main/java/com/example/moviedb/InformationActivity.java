package com.example.moviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

    private TextView titel;
    private TextView description;
    private TextView regisseur;
    private TextView actors;
    private TextView length;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String finalIndex = getIntent().getStringExtra("index");
        String finalGenre = getIntent().getStringExtra("genre");

        ImageButton back = (ImageButton)findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button goToTrailer = (Button) findViewById(R.id.btnToTrailer);
        goToTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Database> movieArray = new ArrayList<Database>();
                List<Database> databases = Database.listAll(Database.class);

                for (Database database : databases) {
                    if(database.genre.equals(finalGenre)) {
                        movieArray.add(database);
                    }
                }
                int finalInput;

                    finalInput = Integer.parseInt(finalIndex);
                    Database movie = movieArray.get(finalInput);

                    String youtubeLink = movie.youtubeLink;


                Intent gotoTrailer = new Intent(InformationActivity.this, TrailerActivity.class);
                gotoTrailer.putExtra("link", youtubeLink);
                startActivity(gotoTrailer);
            }
        });

        SugarContext.init(this);




        titel = findViewById(R.id.titleMovies);
        description = findViewById(R.id.information1);
        regisseur = findViewById(R.id.regisseur);
        actors = findViewById(R.id.actors);
        length = findViewById(R.id.length);


        updateInfos(finalIndex, finalGenre);
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
            regisseur.setText("Regisseur: " + movie.resigeur);
            actors.setText("Actors: " + movie.actors);
            length.setText("Length: " + movie.lengthTime);
        }catch (NumberFormatException e) {

            titel.setText("Error");
            description.setText("There was an error with the code. Please go back and try again.");
            regisseur.setText("Error");
            actors.setText("Error");
            length.setText("Error");

        }


    }
}
