package com.michackathon.api.dao;

import com.michackathon.api.domain.travelHistory.Price;
import com.michackathon.couchbase.CouchbaseClient;
import com.michackathon.couchbase.CouchbaseEntityDAO;

/**
 * Created by pankajmisra on 10/19/16.
 */
public class PriceDAO extends CouchbaseEntityDAO<Price> {
    public PriceDAO(CouchbaseClient couchbaseClient, Class<Price> type) {
        super(couchbaseClient, type);
    }
}
