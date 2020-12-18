/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movieapp.services;

import com.mycompany.movieapp.models.Account;
import com.mycompany.movieapp.database.Database;
import java.util.List;

/**
 *
 * @author Ting Hao
 */
public class AccountService {
    
        Database db = new Database();
    // get all the accounts    
    public List<Account> getAllAccounts(int customerId) {
        return db.getCustomerAccounts(customerId);
    }   
    // get individual accounts
    public Account getAccount(int customerId, int accountId) {
       return db.getCustomerAccounts(customerId).get(accountId);
    }    
    
    //Adding new accounts
    public Account addAccount(int customerId, Account account) {
        int accountId = db.getCustomerAccounts(customerId).size() + 1;
        account.setAccId(accountId);
        db.getCustomerAccounts(customerId - 1).add(account);

        return db.getCustomerAccounts(customerId - 1).get(accountId - 1 );
    }    
    
    //Removing accounts
    public void removeAccount(int customerId, int id) {
        db.getCustomerAccounts(customerId).remove(id);
        for(int i = 0; i<db.getCustomerAccounts(customerId).size(); i++){
            db.getCustomerAccounts(customerId).get(i).setAccId(i+1);
        }
    }   
    
    //Update details
    public Account updateAccountDetails(int customerId, int id, Account account) {
        account.setAccId(id);
        db.getCustomerAccounts(customerId).set(id - 1, account);
        return account;
    }    
}
