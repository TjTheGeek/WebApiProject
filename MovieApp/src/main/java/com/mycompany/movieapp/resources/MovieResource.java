/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movieapp.resources;

import com.mycompany.movieapp.models.Movie;
import com.mycompany.movieapp.services.MovieService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Marcus
 */
@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResource {

     private MovieService MovieService=new MovieService();
    
     @GET
    public List<Movie> getAllMovies(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId) {
  
        return MovieService.getAllMovies(customerId, accountId);
    }
    
    @GET//geta specific movie
    @Path("/{movieId}")
    public Movie getMovie(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId, @PathParam("movieId") int movieId) {
<<<<<<< Updated upstream
 
=======
        accountId = accountId-1;
        customerId = customerId-1;
        movieId=movieId-1;
>>>>>>> Stashed changes
        return MovieService.getMovie(customerId, accountId, movieId);
    }
    
    @POST
    public Movie addMovie(@PathParam("customerId") int customerId,@PathParam("accountId") int accountId,Movie movie){
       accountId = accountId-1;
      return  MovieService.addMovie(movie, accountId, customerId);
    }

<<<<<<< Updated upstream
     @DELETE
    @Path("/{MovieID}")
    public String removeMovie(@PathParam("customerId") int CustomerID, @PathParam("accountId") int AccountID, @PathParam("MovieID") int movieid) {
        Movie movie = MovieService.getMovie(CustomerID, AccountID, movieid);
        Movie deletedMovie = movie;
        MovieService.removeMovie(movie, AccountID, CustomerID);

        return "The"  + deletedMovie.getMovieName()+ "Was Removed from: User with Customer Id"+CustomerID+1;
=======
    @DELETE
    @Path("/{movieId}")
    public String removeMovie(@PathParam("customerId") int customerId,@PathParam("accountId") int accountId, @PathParam("movieId") int mId){
        int mid1,accountId1,customerId1;
        mid1 = mId-1;
        accountId1 =accountId-1;
        customerId1 = customerId - 1; 
        Movie movie=MovieService.getMovie(customerId1, accountId1, mid1);
        Movie movie2=movie;
        MovieService.removeMovie(movie, accountId1, customerId1);
        return "The movie "+movie2.getMovieName()+" was removed";
>>>>>>> Stashed changes
    }
    
    @POST
     @Path("/{movieId}/{transAccId}")
     public String transferMovie(@PathParam("customerId")int customerId ,@PathParam("accountId")int custAccId ,@PathParam("transAccId")int transAccId ,@PathParam("movieId") int movieId){
     int customerId1,custAccId1,transAccId1,movieId1;
     customerId1=customerId-1;
     custAccId1=custAccId-1;
     transAccId1=transAccId-1;
     movieId1=movieId-1;
     
         
     Movie movie= MovieService.getMovie(customerId1, custAccId1, movieId1);//getting the movie with its id
     Movie  movie2Transfer=movie;
     MovieService.removeMovie(movie, custAccId1, customerId1);//removing teh move from teh current holder of that movie
     MovieService.addMovie(movie2Transfer,transAccId1, custAccId1);
     AccountResource acc=new AccountResource();
    
  
<<<<<<< Updated upstream
     return "the movie transferred was: " +movie2Transfer+"\n to: "+transAccId;
=======
     return "The movie " +movie2Transfer.getMovieName()+"was transferred to Account nikename "+acc.getAccountNickname(custAccId1, transAccId1)
             +"with Acc no"+(transAccId+1);
     
  
     } 
 
    
    
    
    
    
    
>>>>>>> Stashed changes
    
}
}
