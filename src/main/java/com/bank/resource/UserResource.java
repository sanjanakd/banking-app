package com.bank.resource;

import com.bank.model.Transaction;
import com.bank.model.User;
import com.bank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by XKT676 on 4/18/2016.
 */

@RestController
@RequestMapping(value = "users")
public class UserResource {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "{userId}/transactions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> getTransactions(@PathVariable String userId, @RequestParam(required = false) String transactionId) {

        return userService.getTransactions(userId, transactionId);

    }

    @RequestMapping(value = "{userId}/transactions/{transactionId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> getTransactionsDetails(@PathVariable String userId, @PathVariable String transactionId) {
        return userService.getTransactionsDetails(userId, transactionId);
    }

    @RequestMapping(value = "{userId}/transactions/{transactionId}/receipts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getReceipts(@PathVariable String userId, @PathVariable String transactionId) {

        return userService.getReceipts("1", "2");

    }


}
