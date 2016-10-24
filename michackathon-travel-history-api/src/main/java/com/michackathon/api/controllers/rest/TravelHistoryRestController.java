package com.michackathon.api.controllers.rest;


import com.michackathon.couchbase.CouchbaseClient;
import com.michackathon.dao.TravelHistoryDAO;
import com.michackathon.entity.TravelHistory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.io.IOException;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/travel-history")
public class TravelHistoryRestController {
    
    @RequestMapping(value = "/search",method = RequestMethod.POST,
        consumes = "application/json",produces = "application/json")
    public List<TravelHistory> travelHistorySearch(String custId) throws IOException {
        TravelHistory history = null;
        CouchbaseClient client = CouchbaseClient.getConnection("db-couch:8091", "default");
        TravelHistoryDAO dao = new TravelHistoryDAO(client, TravelHistory.class);
        return dao.getCustomerTravelHistory(custId);
    }





}
