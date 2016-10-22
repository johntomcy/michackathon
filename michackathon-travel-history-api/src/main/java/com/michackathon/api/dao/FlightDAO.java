package com.michackathon.api.dao;

import com.michackathon.api.domain.Flight;
import com.michackathon.couchbase.CouchbaseClient;
import com.michackathon.couchbase.CouchbaseEntityDAO;

import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by pankajmisra on 10/19/16.
 */
public class FlightDAO extends CouchbaseEntityDAO<Flight> {

    private static final String QRY_SEARCH_FLIGHTS_WITH_DEST = "SELECT * FROM `${bucketName}` " +
                                                        " WHERE origin = '${origin}' AND " +
                                                                " destination = '${dest}' AND " +
                                                                " depDate >= '${depDate}' AND " +
                                                                " type='flight'";

    private static final String QRY_SEARCH_FLIGHTS_WITHOUT_DEST = "SELECT * FROM `${bucketName}` " +
        " WHERE origin = '${origin}' AND " +
        " depDate >= '${depDate}' AND " +
        " type='flight'";

    private String bucketName;

    public FlightDAO(CouchbaseClient couchbaseClient, Class<Flight> type) {
        super(couchbaseClient, type);
        this.bucketName = couchbaseClient.getConnection().name();
    }

    public List<Flight> searchFlights(String origin, String dest, Date dateOfTravel) throws IOException {
        List<Flight> flights = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String effectiveQuery = QRY_SEARCH_FLIGHTS_WITH_DEST;
        if (dest == null || dest.trim().length()==0 ) {
            effectiveQuery = QRY_SEARCH_FLIGHTS_WITHOUT_DEST;
            dest = "";
        }
        String query = effectiveQuery.replace("${bucketName}", bucketName)
                                        .replace("${origin}", origin)
                                        .replace("${dest}", dest)
                                        .replace("${depDate}", dateFormat.format(dateOfTravel));

        flights = this.getByQuery(query);
        return flights;
    }
}
