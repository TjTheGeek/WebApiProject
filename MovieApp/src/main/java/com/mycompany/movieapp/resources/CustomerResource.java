/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movieapp.resources;

import com.mycompany.movieapp.models.Customer;
import com.mycompany.movieapp.services.CustomerService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author TJ
 */

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
   private CustomerService customerService = new CustomerService();
   
    @GET//gets all customers       
    public List<Customer> getCustomers() {
        
        return customerService.getAllCustomers();
    }
    
    @GET//gets all customer with id
    @Path("/{customerId}")
    public Customer getCustomer(@PathParam("customerId") int id) {
        Customer customer =  customerService.getCustomerById(id);
        return customer;
    }
    
    @POST
     public Customer addCustomer(Customer customer) {
        return customerService.addCustomer(customer);
    }
    
    @DELETE
    @Path("/{customerId}")
    public void removeCustomer(@PathParam("customerId") int id) {
        id = id -1;
        customerService.removeCustomer(id);
    }
    @PUT
    @Path("/{customerId}")
    public Customer updateCustomer(@PathParam("customerId") int id, Customer customer) {
        return customerService.updateCustomerDetails(id, customer);
    }
    
    @Path("/{customerId}/accounts/")
    public AccountResource getCustomerAccounts() {
        return new AccountResource();
    }
    
      @Path("/{customerId}/accounts/{accountId}/movies/")
    public MovieResource getCustomerAccountMovies() {
        return new MovieResource();
    }

    
   
    
    
    
}
