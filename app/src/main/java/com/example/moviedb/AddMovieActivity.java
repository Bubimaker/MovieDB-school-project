package com.example.moviedb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.orm.SugarContext;

public class AddMovieActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmovie);


        SugarContext.init(this);

        ImageButton back = (ImageButton)findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                Intent gotoGenres = new Intent(AddMovieActivity.this, GenreActivity.class);
                startActivity(gotoGenres);
            }
        });

        Button save = (Button)findViewById(R.id.addMovieSaveButton);
        save.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {



                databaseFillup();

                Intent goToGenresSave = new Intent(AddMovieActivity.this, GenreActivity.class);
                startActivity(goToGenresSave);
            }
        });
        ImageButton homeButton = (ImageButton) findViewById(R.id.iconMovies);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHomepage = new Intent(AddMovieActivity.this, MainActivity.class);
                startActivity(goToHomepage);
            }
        });


    }

    private void databaseFillup(){
        TextInputEditText titel = (TextInputEditText) findViewById(R.id.userTitleMovie);
        TextInputEditText description = (TextInputEditText) findViewById(R.id.userDescription);
        TextInputEditText genre = (TextInputEditText) findViewById(R.id.userGenre);
        TextInputEditText resigeur = (TextInputEditText) findViewById(R.id.userRegisseur);
        TextInputEditText length = (TextInputEditText) findViewById(R.id.userLength);
        TextInputEditText actor = (TextInputEditText) findViewById(R.id.userActor);
        TextInputEditText link = (TextInputEditText) findViewById(R.id.userLink);

        String movieTitel = titel.getText().toString();
        String movieDescription = description.getText().toString();
        String movieResigeur = resigeur.getText().toString();
        String movieLength = length.getText().toString();
        String movieActor = actor.getText().toString();
        String movieGenre = genre.getText().toString();
        String movieLink = link.getText().toString();


        Database database = new Database(movieTitel, movieDescription, movieResigeur, movieLength, movieActor, movieGenre, movieLink);
        database.save();
    }
}
