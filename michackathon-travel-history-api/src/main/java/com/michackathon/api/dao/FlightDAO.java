package com.michackathon.api.dao;

import com.michackathon.api.domain.travelHistory.Flight;
import com.michackathon.couchbase.CouchbaseClient;
import com.michackathon.couchbase.CouchbaseEntityDAO;

/**
 * Created by pankajmisra on 10/19/16.
 */
public class FlightDAO extends CouchbaseEntityDAO<Flight> {
    public FlightDAO(CouchbaseClient couchbaseClient, Class<Flight> type) {
        super(couchbaseClient, type);
    }
}
