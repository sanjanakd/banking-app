package com.bank.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

/**
 * Created by xkt676 on 2/5/16.
 */
@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {
    private int accountNumber;
    private String merchantName;
    private double transactionAmount;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String transactionId;


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionId(){ return transactionId; }

    public void setTransactionId(String transactionId){ this.transactionId=transactionId; }
}

