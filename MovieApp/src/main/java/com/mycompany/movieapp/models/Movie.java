/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movieapp.models;

/**
 *
 * @author Marcus
 */
public class Movie {
    private int movieId;
    public String movieName;
    private String isWatch;
    private String summary;

    public Movie() {
    }

    public Movie(int movieId,String movieName, String isWatch, String summary) {
        this.movieId = movieId;    
        this.movieName = movieName;
        this.isWatch = isWatch;
        this.summary = summary;
    }  
    
    
    
    



    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getIsWatch() {
        return isWatch;
    }

    public void setIsWatch(String isWatch) {
        this.isWatch = isWatch;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    
}
