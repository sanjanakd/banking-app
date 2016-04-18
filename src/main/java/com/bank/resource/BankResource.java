package com.bank.resource;

import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.model.Transfer;
import com.bank.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xkt676 on 2/5/16.
 */

@RestController
@RequestMapping(value = "banking")
public class BankResource {

    @Autowired
    private BankService bankService;

    @RequestMapping(value = "accounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> getAccount() {
        return bankService.getAccounts();
    }


    @RequestMapping(value = "accounts", method = RequestMethod.DELETE)
    public void deleteAccount(@RequestParam String account) {
        bankService.deleteAccount(account);
    }

    @RequestMapping(value = "accounts", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAccount(@RequestBody Account account) {
        bankService.createAccount(account);
    }


    @RequestMapping(value = "transactions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> getTransaction() {

        return bankService.getTranscations();
    }


    @RequestMapping(value = "transfer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void transferMoney(@RequestBody Transfer transfer) { bankService.doTransfer();
       System.out.println("transfer done :"+transfer);
    }


}
