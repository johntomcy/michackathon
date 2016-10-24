package com.michackathon.dao;

import com.michackathon.couchbase.CouchbaseClient;
import com.michackathon.couchbase.CouchbaseEntityDAO;
import com.michackathon.entity.TravelHistory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankajmisra on 10/17/16.
 */
public class TravelHistoryDAO extends CouchbaseEntityDAO<TravelHistory> {

    private static final String QRY_CUST_TRAVEL_HISTORY = "SELECT * FROM `${bucketName}` " +
        " WHERE custId = '${custId}' AND " +
        " type='travel-history'";

    private String bucketName;

    public TravelHistoryDAO(CouchbaseClient couchbaseClient, Class<TravelHistory> type) {
        super(couchbaseClient, type);
        this.bucketName = couchbaseClient.getConnection().name();
    }

    public List<TravelHistory> getCustomerTravelHistory(String custId) throws IOException {
        List<TravelHistory> history = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String query = QRY_CUST_TRAVEL_HISTORY;
        query = query.replace("${bucketName}", bucketName)
            .replace("${custId}", custId);
        history = this.getByQuery(query);
        return history;
    }


}
