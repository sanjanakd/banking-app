package com.bank.services;

import com.bank.dao.BankDao;
import com.bank.model.Transaction;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by XKT676 on 4/18/2016.
 */
@Component
public class UserService {

    @Autowired
    private BankDao bankDao;

    public List<Transaction> getTransactions(String userId,String transactionId){
        List<Transaction> transactions=bankDao.getTransactionFromdatabase();
        System.out.println("Returning transactions for userId :" + userId + " And transactionId :" + transactionId);

        if (transactionId!=null) {
            for (Transaction transaction : transactions) {
                if (transaction.getTransactionId().equalsIgnoreCase(transactionId)) {
                    return Lists.newArrayList(transactions);
                }
            }
        }else {
            return transactions;

            }
        return Lists.newArrayList();
        }

    public List<String> getUsers(){
        return Lists.newArrayList("user1","user2","user3");

    }

    public List<Transaction> getTransactionsDetails(String userId,String transactionId){

        List<Transaction> transactions=bankDao.getTransactionFromdatabase();
        System.out.println("returning transaction details for userId :" + userId + "and transactionId :" + transactionId);
        return Lists.newArrayList(transactions);
    }

    public List<String> getReceipts(String userId,String transactionId){
        System.out.println("Returning receipts for userId :" + userId + "and transactionId :" + transactionId);
        return Lists.newArrayList("receipts1","receipts2","receipts3");
    }
    }


