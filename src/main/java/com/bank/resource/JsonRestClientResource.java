package com.bank.resource;

import com.bank.model.Album;
import com.bank.services.JsonRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by XKT676 on 5/1/2016.
 */
@RestController
@RequestMapping(value = "albums")

public class JsonRestClientResource {

    @Autowired
    JsonRestClientService jsonRestClientService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Album> getAlbums() {
        return jsonRestClientService.getData();
    }


}
