package com.bank.services;

import com.bank.dao.BankDao;
import com.bank.dao.JsonPublicRestClient;
import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.model.Transfer;
import com.bank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by xkt676 on 2/5/16.
 */
@Component
public class BankService {

    //@Autowired
   // private JsonPublicRestClient jsonPublicRestClient;
    @Autowired
    private BankDao bankDao;

    public List<Account> getAccounts() {

        List<Account> accounts = bankDao.getAccountFromDatabase();

        // new Thread(jsonPublicRestClient).start();
        //jsonPublicRestClient.getData();

        System.out.println("Account details");
        return accounts;
    }


    public void createAccount(Account account) {

        bankDao.createAccountFromDatabase(account);

    }

    public void deleteAccount(String accountId) {
        bankDao.deleteAccountFromDatabase(accountId);
    }


    public List<Transaction> getTranscations() {

        List<Transaction> transactions = bankDao.getTransactionFromdatabase();

        return transactions;
    }


    public List<Transfer> doTransfer() {

        List<Transfer> transfers = bankDao.getTransferFromdatabase();

        return transfers;
    }

    public List<User> getUser(){
        List<User> users=bankDao.getUserFromDataBase();
        return users;
    }

    public void addUser(User user){
        bankDao.addUserToDatabase(user);

    }


    /**
     * @param var
     * @return
     */
    public String getString(int var) {

        if (var == 1) {
            return "One";
        } else if (var == 2) {
            return "two";
        } else if (var == 3) {

            return "three";
        } else {
            return "default";
        }

    }


}