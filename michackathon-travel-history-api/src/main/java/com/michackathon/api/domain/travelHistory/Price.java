package com.michackathon.api.domain.travelHistory;

/**
 * Created by pankajmisra on 10/19/16.
 */
public class Price {

    private String priceId;
    private String flightId;
    private double price;

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
