package com.bank.resource;

import com.bank.BankingAppApplication;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by XKT676 on 5/1/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BankingAppApplication.class)
@WebIntegrationTest({"server.port=8080"})

public class JsonRestClientResourceTest extends TestCase {

    private RestTemplate testRestTemplate=new TestRestTemplate();

    @Test
    public void testGetThreadEx() throws Exception {
        ResponseEntity<Object> responseEntity = testRestTemplate.getForEntity("http://jsonplaceholder.typicode.com/albums", Object.class);
        System.out.println("http status code for getdata :"+responseEntity.getStatusCode().value());
        System.out.println("http response body for getData:"+responseEntity.getBody());



    }
}