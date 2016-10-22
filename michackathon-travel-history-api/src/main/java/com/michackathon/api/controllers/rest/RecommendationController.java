package com.michackathon.api.controllers.rest;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.michackathon.api.dao.FlightDAO;
import com.michackathon.api.dao.RecommendationDAO;
import com.michackathon.api.domain.Flight;
import com.michackathon.api.domain.Recommendation;
import com.michackathon.api.model.FlightSearch;
import com.michackathon.couchbase.CouchbaseClient;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by pankajmisra on 10/22/16.
 */
@RestController
@RequestMapping("/recommendation")
public class RecommendationController {

    @RequestMapping(value = "/search",method = RequestMethod.POST,
        consumes = "application/json",produces = "application/json")
    public List<Recommendation> getRecommendations(@RequestParam String custId, @RequestBody FlightSearch search) throws IOException {
        List<Recommendation> recommendations = new ArrayList<>();
        CouchbaseClient client = CouchbaseClient.getConnection("db-couch:8091", "default");
        if (client != null) {
            RecommendationDAO dao = new RecommendationDAO(client, Recommendation.class);
            Double netSpend = dao.getNetSpendTillDate(custId);

            Double percentDiscount = netSpend / 100000;

            //find all future flights
            FlightDAO fltDAO = new FlightDAO(client, Flight.class);
            List<Flight> flights = fltDAO.searchFlights(search.getOrigin(), search.getDestination(), search.getDepDate());

            for(Flight flight:flights) {
                Recommendation rec = new Recommendation();
                rec.setCustomerId(custId);
                rec.setFlight(flight);
                rec.setPrice(flight.getPrice()*(100-percentDiscount)/100);
                System.out.println("Full Price: " + flight.getPrice() + " , Discounted: " + rec.getPrice());
                recommendations.add(rec);
            }
        }
        return recommendations;
    }

    @RequestMapping(value = "/rateRecommendation",method = RequestMethod.POST,
        consumes = "application/json",produces = "application/json")
    public void saveRecommendationRating(@RequestBody Recommendation recommendation) throws JsonProcessingException {
        CouchbaseClient client = CouchbaseClient.getConnection("db-couch:8091", "default");
        if (client != null) {
            RecommendationDAO dao = new RecommendationDAO(client, Recommendation.class);
            dao.put(UUID.randomUUID().toString(), recommendation);
        }
    }

}
