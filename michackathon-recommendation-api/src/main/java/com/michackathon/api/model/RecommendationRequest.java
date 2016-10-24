package com.michackathon.api.model;

import com.michackathon.entity.Flight;
import com.michackathon.model.FlightSearch;

/**
 * Created by pankajmisra on 10/24/16.
 */
public class RecommendationRequest {

    private String custId;
    private FlightSearch flightSearch;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public FlightSearch getFlightSearch() {
        return flightSearch;
    }

    public void setFlightSearch(FlightSearch flightSearch) {
        this.flightSearch = flightSearch;
    }
}
