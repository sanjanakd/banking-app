package com.bank.dao;

import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.model.Transfer;
import com.bank.model.User;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;


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

        list.add(account1);

        Account account2 = new Account();
        account2.setAccountNumber(299083678);
        account2.setName("saving");
        account2.setBalance(209.00);

        list.add(account2);

        Iterable<Account> iterable = accountRepository.findAll();
        return Lists.newArrayList(iterable);
    }


    public void createAccountFromDatabase(Account account) {

        entityManager.persist(account);
    }

    public void deleteAccountFromDatabase(String accountId) {

        accountRepository.delete(accountId);
    }

    public List<Transaction> getTransactionFromdatabase() {

        List<Transaction> list = new ArrayList<>();

        Transaction transaction = new Transaction();
        transaction.setAccountNumber(1122112211);
        transaction.setMerchantName("Panda express");
        transaction.setTransactionAmount(34.88);

        transaction.setTransactionDate(getDateFromString("01/29/16"));

        list.add(transaction);


        Transaction transaction1 = new Transaction();
        transaction1.setAccountNumber(1122112211);
        transaction1.setMerchantName("Prada");
        transaction1.setTransactionAmount(899.87);
        transaction1.setTransactionDate(getDateFromString("09/09/15"));
        list.add(transaction1);


        Transaction transaction2 = new Transaction();
        transaction2.setAccountNumber(1122119999);
        transaction2.setMerchantName("Macys");
        transaction2.setTransactionAmount(799.87);
        transaction2.setTransactionDate(getDateFromString("06/6/02"));

        list.add(transaction2);


        Transaction transaction3 = new Transaction();
        transaction3.setAccountNumber(992211211);
        transaction3.setMerchantName("Cold Stone");
        transaction3.setTransactionAmount(89.87);
        transaction3.setTransactionDate(getDateFromString("07/06/08"));

        list.add(transaction3);


        // Collections.sort(list, new Comparator<Transaction>() {
        //   @Override
        // public int compare(Transaction o1, Transaction o2) {
        //   if (o1.getTransactionDate() == null || o2.getTransactionDate() == null)
        //     return 0;
        //return o1.getTransactionDate().compareTo(o2.getTransactionDate());
        //}

        //});

        Collections.sort(list, new Comparator<Transaction>() {
            public int compare(Transaction t1, Transaction t2) {
                if (t1.getMerchantName() == null || t2.getMerchantName() == null)
                    return 0;
                return t1.getMerchantName().compareTo(t2.getMerchantName());
            }
        });
        //Iterable<Transaction> iterable=transactionRepository.findAll();
        //return Lists.newArrayList(iterable);

        return list;
    }

    public List<Transfer> getTransferFromdatabase() {

        Transfer transfer = new Transfer();

        List<Transfer> list = new ArrayList<>();
        list.add(transfer);

        return list;

    }

    /**
     * "MM/dd/yy"
     *
     * @return
     */
    private Date getDateFromString(String textDate) {

        try {

            DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
            Date date = formatter.parse(textDate);

            return date;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new Date();
    }

    public List<User> getUserFromDataBase() {
        List<User> list = new ArrayList<>();

        User user = new User();
        user.setAge(24);
        user.setId(1);
        user.setName("sanjana");
        list.add(user);

        User user1 = new User();
        user1.setName("yogesh");
        user1.setId(2);
        user1.setAge(30);
        list.add(user1);

        User user2 = new User();
        user2.setName("Manjiri");
        user2.setId(3);
        user2.setAge(22);
        list.add(user2);

        User user3=new User();
        user3.setAge(40);
        user3.setName("Ami");
        user3.setId(4);
        list.add(user3);

        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                if (u1.getName()==null || u2.getName()==null)
                return 0;
                return u1.getName().compareTo(u2.getName());
            }
        });


        //Iterable<User> iterable = userRepository.findAll();
        //return Lists.newArrayList(iterable);


        return list;

    }

    public void addUserToDatabase(User user) {


        userRepository.save(user);
        // entityManager.persist(user);
    }


}




