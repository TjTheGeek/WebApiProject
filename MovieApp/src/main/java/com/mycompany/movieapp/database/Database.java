/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movieapp.database;

import com.mycompany.movieapp.models.Customer;
import com.mycompany.movieapp.models.Account;
import com.mycompany.movieapp.models.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jegan
 */
public class Database {
    public static List<Account> accountsTB = new ArrayList<Account>();
    public static List<Account> accountsTB2 = new ArrayList<Account>();
    public static List<Movie> movieTB = new ArrayList<Movie>();
    public static List<Movie> movieTB2 = new ArrayList<Movie>();
    public static List<Customer> customerTB = new ArrayList<Customer>();
    public static boolean init = true;
    
    
    public Database(){
        
        if(init){
            //Here are are adding Customers to tthe Database and Accoutns to the customers and teh movie to the account
           //First Movie 
           Movie movie1 = new Movie(movieTB.size()+1,"Red Wedding", "Watch", "Ting's Documentary");
           movieTB.add(movie1);
           
           Movie movie4 = new Movie(movieTB.size()+1,"Yellow Wedding", "Watch", "Marcus's Documentary");
           movieTB.add(movie4);
           //Second Movie
           Movie movie2 = new Movie(movieTB2.size()+1,"Blue Wedding", "Recommended", "TJ's Documentary");
           movieTB2.add(movie2);
           Movie movie3 = new Movie(movieTB2.size()+1,"green Wedding", "Recommended", "Jegans's Documentary");
           movieTB2.add(movie3);
            
          
            //First Customer
            //First Accounts for customer 
           Account account1 = new Account(accountsTB.size()+1, "Adult", "Mum's account", 123456, movieTB);
           accountsTB.add(account1);
            Account account3 = new Account(accountsTB.size()+1, "Child", "Step son", 12361231, movieTB2);
           accountsTB.add(account3);
            Customer customer1 = new Customer("Abraham", "Dublin 2", "Marcus@gmail.com", customerTB.size()+1,accountsTB);
            customerTB.add(customer1);
            
            //Second Customer
           Account account2 = new Account(accountsTB2.size()+1, "Child", "Jegan's account", 111111, movieTB2);
           accountsTB2.add(account2);            
           Account account4 = new Account(accountsTB2.size()+1, "Child", "Dad's account", 112345, movieTB);
           accountsTB2.add(account4);            
            Customer customer2 = new Customer("Abraham", "Dublin 2", "Marcus@gmail.com", customerTB.size()+1,accountsTB2);
            customerTB.add(customer2);         
        }
        init=false;//this stops the initialization of the db
    }
    
     public List<Customer> getCustomers() {
        System.out.println(customerTB.toString());
        return customerTB;
    }
     
    public void addMovie(int custId,int accountId,Movie movie){
        List currentMovieList = getCustomerMovie(custId, accountId);
        currentMovieList.add(movie);

        getCustomerAccounts(custId).get(accountId).setMovies(currentMovieList);
    }
    
    public void removeMovie(int custId,int accountId,Movie movie){
        List currentMovieList = getCustomerMovie(custId, accountId);
        currentMovieList.remove(movie);

        getCustomerAccounts(custId).get(accountId).setMovies(currentMovieList);
    }
    
    public List<Account> getCustomerAccounts(int customerNo) {
        return customerTB.get(customerNo).getAccounts();
    }

    public List<Movie> getCustomerMovie(int customerNo, int accountNo) {
        return customerTB.get(customerNo).getAccounts().get(accountNo).getMovies();
    }     
}
