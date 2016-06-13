package com.bank.dao;

import com.bank.model.Album;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by XKT676 on 4/26/2016.
 */
@Component
public class JsonPublicRestClient implements Runnable {

    private RestTemplate restTemplate = new RestTemplate();


    @Value("${END_POINT_ADDRESS_ALBUMS}")
    public String END_POINT_ALBUMS;


    public List<Album> getData() {

        System.out.println("name of the current thread :" + END_POINT_ALBUMS);

        ResponseEntity<List> responseEntity = restTemplate.getForEntity(END_POINT_ALBUMS, List.class);
        System.out.println("http status code for getdata :" + responseEntity.getStatusCode().value());
        System.out.println("http response body for getData:" + responseEntity.getBody());
        return responseEntity.getBody();
    }

    @Override
    public void run() {
        this.getData();
    }


}
