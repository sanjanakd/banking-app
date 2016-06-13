package com.bank.services;

import com.bank.dao.JsonPublicRestClient;
import com.bank.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by XKT676 on 5/1/2016.
 */
@Component
public class JsonRestClientService implements Runnable {

    @Autowired
    private JsonPublicRestClient jsonPublicRestClient;

    public String getThreadEx() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();

        }

        //String threadName=Thread.currentThread().getName();
        System.out.println("Current thread is :" + Thread.currentThread().getName());
        return "thread is running";
    }

    public List<Album> getData() {

        return jsonPublicRestClient.getData();
    }


    @Override
    public void run() {

        this.getThreadEx();
    }


}
