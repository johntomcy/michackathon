package com.michackathon.api.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by pankajmisra on 10/17/16.
 */
public class TravelHistory {

    private String id;
    private String custId;
    private String flightId;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private final String type = "travel-history";

    public String getType() {
        return type;
    }

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
