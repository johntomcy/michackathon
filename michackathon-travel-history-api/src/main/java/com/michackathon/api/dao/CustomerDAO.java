package com.michackathon.api.dao;

import com.michackathon.api.domain.travelHistory.Customer;
import com.michackathon.couchbase.CouchbaseClient;
import com.michackathon.couchbase.CouchbaseEntityDAO;

/**
 * Created by pankajmisra on 10/19/16.
 */
public class CustomerDAO extends CouchbaseEntityDAO<Customer> {
    public CustomerDAO(CouchbaseClient couchbaseClient, Class<Customer> type) {
        super(couchbaseClient, type);
    }
}
