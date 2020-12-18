/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movieapp.services;

import com.mycompany.movieapp.database.Database;
import com.mycompany.movieapp.models.Customer;
import java.util.List;

/**
 *
 * @author TJ
 */
public class CustomerService {
    private static Database db = new Database();    
    
    public List<Customer> getAllCustomers() {
        return db.getCustomers();
    }   
    public Customer getCustomerById(int id) {
        return db.getCustomers().get(id - 1);
    }
    
    public Customer addCustomer(Customer customer) {
        customer.setCustomerID(db.getCustomers().size()+1);
        db.getCustomers().add(customer);

        return customer;
    }
    public void removeCustomer(int id) {
        db.getCustomers().remove(id);
        for(int i = 0; i<db.getCustomers().size(); i++){
            db.getCustomers().get(i).setCustomerID(i+1);
        }
    }

    public Customer updateCustomerDetails(int id, Customer customer) {
        customer.setCustomerID(id);
        db.getCustomers().set(id - 1, customer);
        return customer;
    }
}
