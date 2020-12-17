/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movieapp.resources;

import com.mycompany.movieapp.models.Account;
import com.mycompany.movieapp.services.AccountService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ting Hao
 */
@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {
    
    private AccountService accountService = new AccountService();
     
    @GET

    public List<Account> getAccounts(@PathParam("customerId") int id) {//getrs all the accounts under than customer
        id = id - 1;
        return accountService.getAllAccounts(id);

    }
    
    @GET
    @Path("/{accountId}")//gets a specif account under that customer
    public Account getAccount(@PathParam("customerId") int id, @PathParam("accountId") int accountId) {
        int id1,accountId1;
        id1= id-1;
        accountId1 = accountId - 1;
        Account custAcc = accountService.getAccount(id1, accountId1);
        return custAcc;
    }
    
    @GET
    @Path("/{accountId}/accNickname")
    public String getAccountNickname(@PathParam("customerId") int custId, @PathParam("accountId") int accountId) {
        int accountId1,custId1;
        accountId1 = accountId - 1;
        custId1 = custId - 1;
        String nickName=accountService.getAccount(custId1, accountId1).getAccNickname();
        return "The nickname for acc "+accountId1+" is "+nickName;
    }
    
    
     @GET
     @Path("/(accountId)/movies")
     public MovieResource getMovies(){
     return  new MovieResource();
     }
     
     @DELETE
     @Path("/{accountId}")
    public String removeAccount(@PathParam("customerId") int id, @PathParam("accountId") int accountId) {
        int accountId1 = accountId - 1;
        int id1 = id - 1;
        accountService.removeAccount(id1, accountId1);
        return "The user was Deleted";
     }
     
     @PUT
    @Path("/{accountId}")
    public Account updateAccount(@PathParam("customerId") int id, @PathParam("accountId") int accountId, Account account) {
       int id1;
        id1= id - 1;
        return accountService.updateAccountDetails(id, accountId, account);
    }
    
    
    
    
    
    
    

}
