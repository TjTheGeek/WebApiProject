/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movieapp.services;

import com.mycompany.movieapp.database.Database;
import com.mycompany.movieapp.models.Movie;
import java.util.List;

/**
 *
 * @author Marcus
 */
public class MovieService {
    private static Database db = new Database();
    CustomerService cust = new CustomerService();
   
    public List<Movie> getAllMovies(int customerId, int accountId) {
        return db.getCustomers().get(customerId)
                .getAccounts().get(accountId).getMovies();
    }
    
    public Movie getMovie(int customerId ,int accountId, int id) {
        return db.getCustomers().get(customerId).getAccounts()
                .get(accountId).getMovies().get(id);
    }    
    
    public Movie transferMovie(int customerId,int transferId, Movie movie){
        db.removeMovie(customerId, findAccountId
      (movie, customerId), movie);
        db.addMovie(transferId, customerId, movie);
        
    return movie; 
    }  
    public int findAccountId(Movie movie,int customerId){
       int id=0;
     db.getCustomerAccounts(customerId);
       for(int i=0;i<db.getCustomerAccounts(customerId).size()-1;i++){
           if(db.getCustomerAccounts(customerId).get(i).
                   getMovies().equals(movie)){
             id=db.getCustomerAccounts(customerId).get(i).getAccId();
           }
      }
     return id;
    }
    
    public Movie addMovie( Movie movie, int accountId, int custId){
     
        movie.setMovieId(db.getMovieNextId(custId, accountId));
       db.addMovie(custId, accountId, movie);

     return movie;
    
    }
   
    public void removeMovie( Movie movie, int accountId, int custId){
        db.removeMovie(custId, accountId, movie);
        for(int i=0;i<db.getMovieNextId(custId, accountId)-1;i++){
            getMovie(custId, accountId, i).setMovieId(i+1);//indexes everything 
        }
    }
}


