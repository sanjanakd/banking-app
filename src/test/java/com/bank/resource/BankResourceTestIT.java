package com.bank.resource;

import com.bank.BankingAppApplication;
import com.bank.model.Account;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import javafx.animation.Animation;
import junit.framework.TestCase;
import org.apache.tomcat.jni.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

/**
 * Created by XKT676 on 4/21/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BankingAppApplication.class)
@WebIntegrationTest({"server.port=8080"})


public class BankResourceTestIT extends TestCase {

    private RestTemplate testRestTemplate=new TestRestTemplate();

    @Test
    public void testGetAccount() throws Exception {
        ResponseEntity<ArrayList> responseEntity=testRestTemplate.getForEntity("http://localhost:8080/banking/accounts",ArrayList.class);
        System.out.println("http status code for getAccount :"+responseEntity.getStatusCode().value());
        System.out.println("http response body for getAccount :"+responseEntity.getBody().get(2));

        assertThat("unexpected return value",responseEntity.getBody().size(),greaterThanOrEqualTo(2));

    }

    @Test
    public void testDeleteAccount() throws Exception {
        Map<String, String > map= Maps.newHashMap();
        map.put("account","1");
        testRestTemplate.delete("http://localhost:8080/banking/accounts");
       // System.out.println("http status code for deleteAccount :"+responseEntity.getStatusCode().value());
       // System.out.println("http response body for deleteAccount :"+responseEntity.getBody());

       // assertThat(responseEntity.getBody().size(), greaterThanOrEqualTo(0));

    }

    @Test
    public void testCreateAccount() throws Exception {
       List<Account> list=new ArrayList<>();

        Account account4=new Account();
        account4.setName("checking");
        account4.setBalance(12.33);
        account4.setAccountNumber(129376553);
        list.add(account4);
        ResponseEntity<String> responseEntity=testRestTemplate.postForEntity("http://localhost:8080/banking/accounts", account4,String.class);
        System.out.println("http status code for createAccount :"+responseEntity.getStatusCode().value());
        System.out.println("http response body for createAccount :"+responseEntity.getBody());

       // assertThat(responseEntity.getBody().);


    }

    @Test
    public void testGetTransaction() throws Exception {
        Map<String,String> map= Maps.newHashMap();
        map.put("account","1");

        ResponseEntity<List> responseEntity=testRestTemplate.getForEntity("http://localhost:8080/banking/transactions",List.class,map);
        System.out.println("http status code for getTransactions :"+responseEntity.getStatusCode().value());
        System.out.println("http response body for getTransactions :" + responseEntity.getBody());
        assertThat(responseEntity.getBody().size(),greaterThanOrEqualTo(0));


    }

   // public void testTransferMoney() throws Exception {

    //}
}