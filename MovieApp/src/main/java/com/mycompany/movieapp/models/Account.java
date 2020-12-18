/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movieapp.models;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ting Hao
 */ 
public class Account {
    private int accId;
    private String accType;
    private String accNickname;
    private int accPassword;
    private List<Movie> movies = new ArrayList<>();
    public Account(){ 
    }
    public Account(int accId, String accType, 
            String accNickname, int accPassword,List<Movie> movies) {
        this.accId = accId;
        this.accType = accType;
        this.accNickname = accNickname;
        this.accPassword = accPassword;
        this.movies = movies;
    }
    public List<Movie> getMovies() {
        return movies;
    }
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    public int getAccId() {
        return accId;
    }
    public void setAccId(int accId) {
        this.accId = accId;
    }
    public String getAccType() {
        return accType;
    }
    public void setAccType(String accType) {
        this.accType = accType;
    }
    public String getAccNickname() {
        return accNickname;
    }
    public void setAccNickname(String accNickname) {
        this.accNickname = accNickname;
    }
    public int getAccPassword() {
        return accPassword;
    }
    public void setAccPassword(int accPassword) {
        this.accPassword = accPassword;
    }
}
