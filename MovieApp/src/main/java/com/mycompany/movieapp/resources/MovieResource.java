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
        customerId = customerId-1;
        accountId=accountId-1;

        return MovieService.getAllMovies(customerId, accountId);
    }
    
    @GET//geta specific movie
    @Path("/{movieId}")
    public Movie getMovie(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId, @PathParam("movieId") int movieId) {
        customerId = customerId--;
        accountId=accountId-1;
       
        
        return MovieService.getMovie(customerId, accountId, movieId);
    }
    
    @POST
    public Movie addMovie(@PathParam("customerId") int customerId,@PathParam("accountId") int accountId,Movie movie){
        customerId = customerId--;
        accountId=accountId--;
      return  MovieService.addMovie(movie, accountId, customerId);
    }

     @DELETE
    @Path("/{MovieID}")
    public String removeMovie(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId, @PathParam("MovieID") int movieid) {
         customerId = customerId--;
        accountId=accountId--;
       
        Movie movie = MovieService.getMovie(customerId, accountId, movieid);
        Movie deletedMovie = movie;
        
        
        MovieService.removeMovie(movie, accountId, customerId);

        return "The"  + deletedMovie.getMovieName()+ "Was Removed from: User with Customer Id"+customerId+1;
    }
    
    @POST
     @Path("/{movieId}/{transAccId}")
     public String transferMovie(@PathParam("customerId")int customerId ,@PathParam("accountId")int custAccId ,@PathParam("transAccId")int transAccId ,@PathParam("movieId") int movieId){
     customerId = customerId--;
        custAccId=custAccId--;
       
       Movie movie= MovieService.getMovie(customerId, custAccId, movieId);//getting the movie with its id
     Movie  movie2Transfer=movie;
     MovieService.removeMovie(movie, custAccId, customerId);//removing teh move from teh current holder of that movie
     MovieService.addMovie(movie2Transfer,transAccId, custAccId);
    
  
     return "the movie transferred was: " +movie2Transfer+"\n to: "+transAccId;
    
}
}
