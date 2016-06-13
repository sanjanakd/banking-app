package com.bank.resource;

import com.bank.BankingAppApplication;
import com.bank.model.User;
import com.google.common.collect.Maps;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.ResponseCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

/**
 * Created by XKT676 on 4/18/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BankingAppApplication.class)
@WebIntegrationTest({"server.port=8080"})
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
})
public class UserResourceTestIT extends TestCase {

    private RestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    public void testGetUsers() throws Exception {

        ResponseEntity<ArrayList> responseEntity = testRestTemplate.getForEntity("http://localhost:8080/users", ArrayList.class);
        System.out.println("http status code for getUsers :" + responseEntity.getStatusCode().value());
        System.out.println("http response body for getUsers :" + responseEntity.getBody().get(2));

        assertEquals("unexpected return value", 4, responseEntity.getBody().size());

    }

    @Test
    public void testGetTransactions() throws Exception {

        Map<String, String> map = Maps.newHashMap();
        map.put("userId", "1");

        ResponseEntity<List> responseEntity = testRestTemplate.getForEntity("http://localhost:8080/users/{userId}/transactions", List.class, map);
        System.out.println("http status code for getTransactions :" + responseEntity.getStatusCode().value());
        System.out.println("http response body for getTransactions :" + responseEntity.getBody());
        assertThat(responseEntity.getBody().size(), greaterThanOrEqualTo(0));

    }

    @Test
    public void testGetTransactionsDetails() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("userId", "1");
        map.put("transactionId", "1");

        ResponseEntity<List> responseEntity = testRestTemplate.getForEntity("http://localhost:8080/users/{userId}/transactions/{transactionId}", List.class, map);
        System.out.println("http status code for getTransactionsDetails :" + responseEntity.getStatusCode().value());
        System.out.println("http response body for getTransactionsDetails :" + responseEntity.getBody().get(2));

        assertThat(responseEntity.getBody().size(), greaterThanOrEqualTo(0));


    }

    @Test
    public void testGetReceipts() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("userId", "1");
        map.put("transactionId", "1");

        ResponseEntity<List> responseEntity = testRestTemplate.getForEntity("http://localhost:8080/users/{userId}/transactions/{transactionId/receipts", List.class, map);

        System.out.println("http status code for getReceipts :" + responseEntity.getStatusCode().value());
        System.out.println("http response body for getReceipts :" + responseEntity.getBody().get(2));
        assertThat(responseEntity.getBody().size(), greaterThanOrEqualTo(0));


    }

    //@Test
    //public void testGetUsers() throws Exception {

    // ResponseEntity<User> responseEntity=testRestTemplate.exchange("http://localhost:8080/users", HttpMethod.GET,null,User.class);

    //  System.out.println("http status code for getuser :" + responseEntity.getStatusCode().value());
    //  System.out.println("http response body for getUser :" + responseEntity.getBody().getName());
    //}

}