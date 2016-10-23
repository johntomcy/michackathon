package com.michackathon.dao;

import com.michackathon.couchbase.CouchbaseClient;
import com.michackathon.couchbase.CouchbaseEntityDAO;
import com.michackathon.entity.TravelHistory;

/**
 * Created by pankajmisra on 10/17/16.
 */
public class TravelHistoryDAO extends CouchbaseEntityDAO<TravelHistory> {


    public TravelHistoryDAO(CouchbaseClient couchbaseClient, Class<TravelHistory> type) {
        super(couchbaseClient, type);
    }


}
