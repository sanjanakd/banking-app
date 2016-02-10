package com.bank.services;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by xkt676 on 2/7/16.
 */
public class BankServiceTest {


    BankService bankService = new BankService();

    public void testGetAccounts() throws Exception {


        bankService.getAccounts();


    }

    public void testGetTranscations() throws Exception {


    }


    @Test
    public void testGetStringForOne() {

        String returnedValue = bankService.getString(1);

        assertEquals("Unexpected values", "One", returnedValue);
    }


    @Test
    public void testGetStringForTwo() {

        String returnedValue = bankService.getString(2);

        assertEquals("Unexpected values", "two", returnedValue);
    }


    @Test
    public void testGetStringForSeven() {

        String returnedValue = bankService.getString(7);

        assertEquals("Unexpected values", "default", returnedValue);
    }


}