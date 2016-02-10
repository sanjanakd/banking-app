package com.bank.dao;

import com.bank.model.Account;
import com.bank.model.Transaction;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xkt676 on 2/5/16.
 */
@Component
@Repository
@Transactional
public class BankDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;


    public List<Account> getAccountFromDatabase() {

        List<Account> list = new ArrayList<>();

        Account account = new Account();
        account.setAccountNumber(1122334455);
        account.setName("Saving");
        account.setBalance(2399.88);

        list.add(account);


        Account account1 = new Account();
        account1.setName("Checking");
        account1.setAccountNumber(1122112211);
        account1.setBalance(5600.88);


        Iterable<Account> iterable = accountRepository.findAll();

        list.add(account1);

        return Lists.newArrayList(iterable);
    }


    public void createAccountFromDatabase(Account account) {

        entityManager.persist(account);
    }

    public void deleteAccountFromDatabase(String accountId){
        accountRepository.delete(accountId);
    }

    public List<Transaction> getTransactionFromdatabase() {

        List<Transaction> list = new ArrayList<>();

        Transaction transaction = new Transaction();
        transaction.setAccountNumber(1122112211);
        transaction.setMerchantName("panda express");
        transaction.setTransactionAmount(34.88);

        list.add(transaction);


        Transaction transaction1 = new Transaction();
        transaction1.setAccountNumber(1122112211);
        transaction1.setMerchantName("prada");
        transaction1.setTransactionAmount(899.87);

        list.add(transaction);
        return list;
    }
}
