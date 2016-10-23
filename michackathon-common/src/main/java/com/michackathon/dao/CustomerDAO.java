package com.michackathon.dao;

import com.michackathon.couchbase.CouchbaseClient;
import com.michackathon.couchbase.CouchbaseEntityDAO;
import com.michackathon.entity.Customer;

/**
 * Created by pankajmisra on 10/23/16.
 */
public class CustomerDAO extends CouchbaseEntityDAO<Customer> {
    public CustomerDAO(CouchbaseClient couchbaseClient, Class<Customer> type) {
        super(couchbaseClient, type);
    }
}
