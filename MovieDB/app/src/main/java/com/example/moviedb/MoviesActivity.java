package com.example.moviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orm.SugarContext;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {

    int movieClickedOnIndex;
    List<Database> databases = Database.listAll(Database.class);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        SugarContext.init(this);

        //Variablen werden übernommen

        String titel = getIntent().getStringExtra("genre");
        TextView tvTitel =(TextView)findViewById(R.id.titleMovies) ;
        tvTitel.setText(titel);

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
                Intent goToHomepage = new Intent(MoviesActivity.this, MainActivity.class);
                startActivity(goToHomepage);
            }
        });


        databaseFillup();
        buttonCreate(titel);


    }

    private void databaseFillup(){


        //Falls Datenbank leer ist, wird sie gefüllt mit Testdaten

        if(databases.size() == 0) {

            Database database = new Database("Deadpool", "Ajax, a twisted scientist, experiments on Wade Wilson, a mercenary, to cure him of cancer and give him healing powers. However, the experiment leaves Wade disfigured and he decides to exact revenge.", "Tim Miller", "109min", "Ryan Reynolds, Morena Baccarin, T.J Miller", "action");
            database.save();
            database = new Database("Forrest Gump", "Forrest, a man with low IQ, recounts the early years of his life when he found himself in the middle of key historical events. All he wants now is to be reunited with his childhood sweetheart, Jenny.", "Robert Zemeckis", "142min", "Tom Hanks, Robin Wright, Gary Sinise", "romance");
            database.save();
            database = new Database("Suicide Squad", "The government sends the most dangerous supervillains in the world -- Bloodsport, Peacemaker, King Shark, Harley Quinn and others -- to the remote, enemy-infused island of Corto Maltese. Armed with high-tech weapons, they trek through the dangerous jungle on a search-and-destroy mission, with only Col. Rick Flag on the ground to make them behave.", "James Gunn", "133min", "Margot Robbie, John Cena, Pete Davidson", "action");
            database.save();


        }

        //SysAusgabe, stellt nochmals dar anzahl Einträge, wurden Viele über die Zeit

        System.out.println("READ:" + databases.size());
        Log.d("DATABASE", "READ:" + databases.size());





    }

    public void buttonCreate(String genre){
        //Buttonerstellung


        int movieAmount = databases.size();
        Button[] buttons = new Button[movieAmount];

        List<String> movieTitles = new ArrayList<String>();


        //Nötigen FilmTitel abspeichern und Filtern
        for (Database database : databases) {
            if(database.genre.equals(genre) || database.genre.equals(genre)) {
                movieTitles.add(database.title);
                System.out.println(movieTitles.size());
            }
        }
        //Für die Anzahl der Einträge werden entsprechende Menge an Buttons erstellt und mit einem Titel versehen
        for (int i = 0; i < movieTitles.size(); i++) {
            Button button = new Button(this);
            button.setId((i+1));
            button.setText(movieTitles.get(i));

            //onClick hinzufügen
            int ind = i;
            String finalIndex = Integer.toString(ind);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    Intent goToInformation = new Intent(MoviesActivity.this, InformationActivity.class);
                    goToInformation.putExtra("index", finalIndex);
                    goToInformation.putExtra("genre", genre);
                    startActivity(goToInformation);


                }

            });

            buttons[i] = button;
        }

        LinearLayout layout = (LinearLayout)findViewById(R.id.sectionLayoutMovies);
        for (int i = 0; i < movieTitles.size(); i++) {
            layout.addView(buttons[i]);
        }
    }

    public int getMovieClickedOnIndex() {
        return movieClickedOnIndex;
    }

    public void setMovieClickedOnIndex(int movieClickedOnIndex) {
        this.movieClickedOnIndex = movieClickedOnIndex;
    }
}
