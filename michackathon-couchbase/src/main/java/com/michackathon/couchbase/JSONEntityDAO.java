package com.michackathon.couchbase;

import com.couchbase.client.deps.com.fasterxml.jackson.databind.JsonNode;
import com.couchbase.client.java.document.json.JsonObject;
import com.michackathon.couchbase.CouchbaseClient;
import com.michackathon.couchbase.CouchbaseEntityDAO;

/**
 * Created by pankajmisra on 10/21/16.
 */
public class JSONEntityDAO extends CouchbaseEntityDAO<JsonNode> {
    public JSONEntityDAO(CouchbaseClient couchbaseClient, Class<JsonNode> type) {
        super(couchbaseClient, type);
    }
}
