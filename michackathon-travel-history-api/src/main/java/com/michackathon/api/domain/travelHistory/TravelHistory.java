package com.michackathon.api.domain.travelHistory;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by pankajmisra on 10/17/16.
 */
public class TravelHistory {

    private String id;
    private String custId;
    private String flightId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
}
