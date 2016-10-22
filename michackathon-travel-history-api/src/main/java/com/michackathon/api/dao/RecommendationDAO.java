package com.michackathon.api.dao;

import com.couchbase.client.deps.com.fasterxml.jackson.databind.JsonNode;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.michackathon.api.domain.Recommendation;
import com.michackathon.api.domain.TravelHistory;
import com.michackathon.api.model.FlightSearch;
import com.michackathon.couchbase.CouchbaseClient;
import com.michackathon.couchbase.CouchbaseEntityDAO;
import com.michackathon.couchbase.JSONEntityDAO;

import java.io.IOException;
import java.util.List;

/**
 * Created by pankajmisra on 10/22/16.
 */
public class RecommendationDAO extends CouchbaseEntityDAO<Recommendation> {

    private static final String QRY_CUST_SPEND = "SELECT sum(price) `total-spend` FROM `${bucket}` " +
                                                    " WHERE " +
                                                        " custId='${custId}' AND " +
                                                            " type='travel-history'";

    private String bucketName;
    private CouchbaseClient couchbaseClient;

    public RecommendationDAO(CouchbaseClient couchbaseClient, Class<Recommendation> type) {
        super(couchbaseClient, type);
        this.couchbaseClient = couchbaseClient;
        this.bucketName = couchbaseClient.getConnection().name();
    }

    public double getNetSpendTillDate(String custId) throws IOException {
        String query = QRY_CUST_SPEND.replace("${bucket}", bucketName)
                                    .replace("${custId}", custId);
        JSONEntityDAO dao = new JSONEntityDAO(this.couchbaseClient, JsonNode.class);
        List<JsonNode> results = dao.getByQuery(query, true);
        double netSpend = 0;
        if (results.size()>0) {
            String total = results.get(0).findValue("total-spend").asText();
            netSpend = Double.parseDouble(total);
        }

        return  netSpend;

    }

    public List<TravelHistory> getCustomerTravelHistory(String custId, FlightSearch search) {
        return null;
    }
}
