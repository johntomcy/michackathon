package com.michackathon.api.controllers.rest;


import com.michackathon.api.domain.travelHistory.TravelHistory;
import com.michackathon.dto.commons.ValueObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


import java.security.Principal;


@RestController
@RequestMapping("/travel-history")
public class TravelHistoryRestController {

    @HystrixCommand(fallbackMethod = "defaultTravelHistory")
    @RequestMapping(value = "/search",method = RequestMethod.POST,
        consumes = "application/json",produces = "application/json")
    public TravelHistory travelHistorySearch(TravelHistory request) {
        return null;
    }

    public TravelHistory defaultTravelHistory(TravelHistory travel) {
        return new TravelHistory();
    }


}
