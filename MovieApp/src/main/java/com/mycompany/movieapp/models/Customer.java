/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movieapp.models;

/**
 *
 * @author TJ
 */
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name,address,email;
    private int customerID;
    private List<Account> accounts=new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String address, String email, int customerID, List<Account> accounts) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.customerID = customerID;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}