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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SugarContext.init(this);

        Button next = (Button)findViewById(R.id.genres);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoGenres = new Intent(MainActivity.this, GenreActivity.class);
                startActivity(gotoGenres);
            }
        });

       // databaseFillup();
    }
    /*
    private void databaseFillup(){


        if(databases.size() == 0) {
            Database database = new Database("Deadpool", "Ajax, a twisted scientist, experiments on Wade Wilson, a mercenary, to cure him of cancer and give him healing powers. However, the experiment leaves Wade disfigured and he decides to exact revenge.", "Tim Miller", "109min", "Ryan Reynolds, Morena Baccarin, T.J Miller", "action");
            database.save();
            database = new Database("Forrest Gump", "Forrest, a man with low IQ, recounts the early years of his life when he found himself in the middle of key historical events. All he wants now is to be reunited with his childhood sweetheart, Jenny.", "Robert Zemeckis", "142min", "Tom Hanks, Robin Wright, Gary Sinise", "Drama");
            database.save();
            database = new Database("Suicide Squad", "The government sends the most dangerous supervillains in the world -- Bloodsport, Peacemaker, King Shark, Harley Quinn and others -- to the remote, enemy-infused island of Corto Maltese. Armed with high-tech weapons, they trek through the dangerous jungle on a search-and-destroy mission, with only Col. Rick Flag on the ground to make them behave.", "James Gunn", "133min", "Margot Robbie, John Cena, Pete Davidson", "Action");
            database.save();


        }

        System.out.println("READ:" + databases.size());
        Log.d("DATABASE", "READ:" + databases.size());

        final TextView tvDescription = (TextView) findViewById(R.id.description);
        tvDescription.setText("READ:" + databases.size());



    }

    public void buttonCreate(){

        int movieAmount = databases.size();
        Button[] buttons = new Button[movieAmount];

        List<String> movieTitles = new ArrayList<String>();

        for (Database database : databases) {
            movieTitles.add(database.title);
        }

        for (int i = 0; i < databases.size(); i++) {
            Button button = new Button(this);
            button.setId((i+1));
            button.setText(movieTitles.get(i));
            buttons[i] = button;
        }

        LinearLayout layout = (LinearLayout)findViewById(R.id.sectionLayoutMovies);
        for (int i = 0; i < movieAmount; i++) {
            layout.addView(buttons[i]);
        }
    }

*/

}