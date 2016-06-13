package com.bank.services;

import com.bank.dao.BankDao;
import com.bank.model.Transaction;
import com.bank.model.User;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import sun.misc.Compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by XKT676 on 4/18/2016.
 */
@Component
public class UserService {

    @Autowired
    private BankDao bankDao;

    public List<Transaction> getTransactions(String userId, String transactionId) {
        List<Transaction> transactions = bankDao.getTransactionFromdatabase();
        System.out.println("Returning transactions for userId :" + userId + " And transactionId :" + transactionId);

        if (transactionId != null) {
            for (Transaction transaction : transactions) {
                if (transaction.getTransactionId().equalsIgnoreCase(transactionId)) {
                    return Lists.newArrayList(transactions);
                }
            }
        } else {
            return transactions;

        }
        return Lists.newArrayList();
    }

    public List<User> getUsers() {
      List<User> users =  bankDao.getUserFromDataBase();
        System.out.println("list of users :" + Lists.newArrayList());
        return users;
       // return Lists.newArrayList("user1", "user2", "user3");

    }

    public List<Transaction> getTransactionsDetails(String userId, String transactionId) {

        List<Transaction> transactions = bankDao.getTransactionFromdatabase();
        System.out.println("returning transaction details for userId :" + userId + "and transactionId :" + transactionId);
        return Lists.newArrayList(transactions);
    }

    public List<String> getReceipts(String userId, String transactionId) {
        System.out.println("Returning receipts for userId :" + userId + "and transactionId :" + transactionId);
        return Lists.newArrayList("receipts1", "receipts2", "receipts3");
    }

}



