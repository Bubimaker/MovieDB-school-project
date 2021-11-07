package com.example.moviedb;

import com.orm.SugarRecord;

public class Database extends SugarRecord{

    String title;
    String description;
    String resigeur;
    String lengthTime;
    String actors;
    String genre;
    String youtubeLink;

    public Database(){

    }

    public Database(String title, String description, String resigeur, String lengthTime, String actors, String genre, String youtubeLink) {
        this.title = title;
        this.description = description;
        this.resigeur = resigeur;
        this.lengthTime = lengthTime;
        this.actors = actors;
        this.genre = genre;
        this.youtubeLink = youtubeLink;
    }
}
