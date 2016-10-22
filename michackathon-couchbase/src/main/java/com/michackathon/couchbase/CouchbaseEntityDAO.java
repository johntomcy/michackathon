package com.michackathon.couchbase;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankajmisra on 10/16/16.
 */
public abstract class  CouchbaseEntityDAO<T> {

    CouchbaseClient couchbaseClient;
    ObjectMapper mapper  = new ObjectMapper();
    protected Class type;

    public CouchbaseEntityDAO(CouchbaseClient couchbaseClient, Class<T> type) {
        this.couchbaseClient = couchbaseClient;
        this.type = type;
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm"));
    }

    public T get(String key) throws IOException {
        JsonDocument document = couchbaseClient.getConnection().get(type.getName() + "::" + key);
        T entity = (T) mapper.readValue(document.content().toString(), type);
        return entity;
    }

    public void put(String id, T entity) throws JsonProcessingException {
        String json = mapper.writeValueAsString(entity);
        JsonObject document = JsonObject.fromJson(json);
        couchbaseClient.getConnection()
                        .insert(
                            JsonDocument.create(entity
                                                .getClass()
                                                .getName()+ "::"+id,
                                                document
                                                )
                        );
    }

    public List<T> getByQuery(String n1qlQuery) throws IOException {
        List<T> results = getByQuery(n1qlQuery, false);
        return results;
    }

    public List<T> getByQuery(String n1qlQuery, boolean aggregationResult) throws IOException {
        List<T> results = new ArrayList<T>();
        N1qlQueryResult result = couchbaseClient.getConnection().query(N1qlQuery.simple(n1qlQuery));
        List<N1qlQueryRow> rows = result.allRows();
        JsonObject jsonObject = null;
        for(N1qlQueryRow row : rows) {
            if (aggregationResult) {
                jsonObject = (JsonObject) row.value();
            } else {
                jsonObject = (JsonObject) row.value().get(this.couchbaseClient.getConnection().name());
            }
            T entity = (T) mapper.readValue( jsonObject.toString(), type);
            results.add(entity);
        }
        return results;
    }


}
