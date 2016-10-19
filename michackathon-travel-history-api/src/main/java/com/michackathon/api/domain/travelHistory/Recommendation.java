package com.michackathon.api.domain.travelHistory;

/**
 * Created by pankajmisra on 10/19/16.
 */
public class Recommendation {

    private String priceId;
    private String customerId;

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
