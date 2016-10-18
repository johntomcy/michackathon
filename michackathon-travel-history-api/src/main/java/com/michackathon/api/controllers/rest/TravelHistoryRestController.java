package com.michackathon.api.controllers.rest;


import com.michackathon.api.domain.travelHistory.TravelHistory;
import com.michackathon.api.domain.travelHistory.TravelHistoryRequest;
import com.michackathon.api.domain.travelHistory.TravelHistoryResponse;
import com.michackathon.dto.commons.ValueObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("/travel-history")
public class TravelHistoryRestController {

    @RequestMapping(value = "/search",method = RequestMethod.POST,
        consumes = "application/json",produces = "application/json")
    public TravelHistory travelHistorySearch(TravelHistory request) {
        return null;
    }



}
