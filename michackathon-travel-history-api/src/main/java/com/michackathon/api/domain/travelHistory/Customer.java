package com.michackathon.api.domain.travelHistory;

/**
 * Created by pankajmisra on 10/19/16.
 */
public class Customer {

    private String custId;
    private String firstName;
    private String lastName;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
