package com.example.moviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GenreActivity extends AppCompatActivity {
    


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        ImageButton next2 = (ImageButton)findViewById(R.id.genreAction);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoMovies = new Intent(GenreActivity.this, MoviesActivity.class);
                String titel = "action";
                gotoMovies.putExtra("genre",titel);
                startActivity(gotoMovies);


                
            }
        });
        ImageButton nextToFantasy = (ImageButton)findViewById(R.id.genreHorror);
        nextToFantasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoMovies = new Intent(GenreActivity.this, MoviesActivity.class);
                String titel = "horror";
                gotoMovies.putExtra("genre",titel);
                startActivity(gotoMovies);



            }
        });
        ImageButton nextToRomance = (ImageButton)findViewById(R.id.genreRomance);
        nextToRomance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoMovies = new Intent(GenreActivity.this, MoviesActivity.class);
                String titel = "romance";
                gotoMovies.putExtra("genre",titel);
                startActivity(gotoMovies);


            }
        });
        ImageButton nextToHorror = (ImageButton)findViewById(R.id.genreFantasy);
        nextToHorror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoMovies = new Intent(GenreActivity.this, MoviesActivity.class);
                String titel = "fantasy";
                gotoMovies.putExtra("genre", titel);
                startActivity(gotoMovies);


            }
        });

        ImageButton back = (ImageButton)findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAddMovie = new Intent(GenreActivity.this, AddMovieActivity.class);
                startActivity(goToAddMovie);
            }
        });


    }
}