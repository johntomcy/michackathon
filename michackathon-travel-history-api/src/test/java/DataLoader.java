import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.michackathon.api.dao.CustomerDAO;
import com.michackathon.api.dao.FlightDAO;
import com.michackathon.api.dao.TravelHistoryDAO;
import com.michackathon.api.domain.Customer;
import com.michackathon.api.domain.Flight;
import com.michackathon.api.domain.TravelHistory;
import com.michackathon.couchbase.CouchbaseClient;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.apache.commons.math.random.RandomData;
import org.apache.commons.math.random.RandomDataImpl;
import org.joda.time.DateTime;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by pankajmisra on 10/19/16.
 */
public class DataLoader {

    private static final int  MAX_CUSTOMERS = 100;
    private static final int  MAX_HISTORY = 20;
    private static final int MAX_FLIGHTS = 1000;

    private static ObjectMapper mapper  = new ObjectMapper();
    private static SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
    private static DecimalFormat decFormat = new DecimalFormat("#.00");
    private static List<Map<String, String>> iataAirports = null;




    public static void main(String[] args) throws IOException, ParseException {

        System.out.println(new File("").getAbsolutePath());
        iataAirports = mapper.readValue(new File("michackathon-travel-history-api/src/main/resources/airports-iata.json"),
                                            mapper.getTypeFactory().constructCollectionType(List.class,
                                                                                        Map.class));
        mapper.setDateFormat(format);
        //generate customer history with past flights
        generateCustomer();

        //generate future flights
        for(int ctrFlts=0; ctrFlts < MAX_FLIGHTS; ctrFlts++) {
            generateFlight(false);
        }

    }

    private static void generateCustomer() throws JsonProcessingException, ParseException {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();

        Customer cust = new Customer();
        cust.setFirstName(person.firstName());
        cust.setLastName(person.lastName());
        cust.setCustId(UUID.randomUUID().toString());
        System.out.println(mapper.writeValueAsString(cust));
        CustomerDAO custDAO = new CustomerDAO(CouchbaseClient.getConnection("couchbase://localhost:8091","default"), Customer.class);
        custDAO.put(cust.getCustId(), cust);
        generateTravelHistory(cust);

    }

    private static Flight generateFlight(boolean pastFlight) throws JsonProcessingException, ParseException {

        Flight flt = new Flight();
        RandomData randomData = new RandomDataImpl();
        DateTime currentDate = new DateTime();

        flt.setFlightId(UUID.randomUUID().toString());
        if (pastFlight) {
            flt.setDepDate(new Date(randomData.nextLong(currentDate.minusDays(1000).getMillis(), currentDate.getMillis())));
        } else {
            flt.setDepDate(new Date(randomData.nextLong(currentDate.plusDays(1).getMillis(), currentDate.plusDays(90).getMillis())));
        }
        flt.setFlightNumber("" + randomData.nextInt(1, 500));

        //DXB as origin - 0, DXB as dest - 1
        int dxbSourceDest = randomData.nextInt(0, 1);

        if (dxbSourceDest == 0) {
            flt.setOrigin("DXB");
        } else {
            flt.setOrigin(iataAirports.get(randomData.nextInt(0, 1766)).get("Code"));
        }

        if (dxbSourceDest == 1) {
            flt.setDestination("DXB");
        } else {
            flt.setDestination(iataAirports.get(randomData.nextInt(0, 1766)).get("Code"));
        }

        flt.setPrice(Double.valueOf(decFormat.format(randomData.nextUniform(1000.0, 4000.0))));
        System.out.println(mapper.writeValueAsString(flt));
        FlightDAO fltDAO = new FlightDAO(CouchbaseClient.getConnection("couchbase://localhost:8091","default"), Flight.class);
        fltDAO.put(flt.getFlightId(), flt);
        return flt;
    }

    private static void generateTravelHistory(Customer cust) throws JsonProcessingException, ParseException {

        TravelHistoryDAO travelHistoryDAO = new TravelHistoryDAO(CouchbaseClient.getConnection("couchbase://localhost:8091","default"), TravelHistory.class);
        RandomData randomData = new RandomDataImpl();

        for(int ctrHistory=0;ctrHistory<MAX_HISTORY; ctrHistory++) {
            TravelHistory history = new TravelHistory();
            history.setCustId(cust.getCustId());
            history.setId(UUID.randomUUID().toString());
            history.setPrice( Double.valueOf(decFormat.format(randomData.nextUniform(1000.0, 4000.0))));
            Flight flt = generateFlight(true);
            history.setFlightId(flt.getFlightId());
            history.setCustId(cust.getCustId());
            travelHistoryDAO.put(history.getId(), history);
        }

    }

}
