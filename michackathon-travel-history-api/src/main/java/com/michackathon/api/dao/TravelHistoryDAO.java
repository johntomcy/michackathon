package com.michackathon.api.dao;

import com.michackathon.api.domain.TravelHistory;
import com.michackathon.couchbase.CouchbaseClient;
import com.michackathon.couchbase.CouchbaseEntityDAO;

/**
 * Created by pankajmisra on 10/17/16.
 */
public class TravelHistoryDAO extends CouchbaseEntityDAO<TravelHistory> {


    public TravelHistoryDAO(CouchbaseClient couchbaseClient, Class<TravelHistory> type) {
        super(couchbaseClient, type);
    }


}
