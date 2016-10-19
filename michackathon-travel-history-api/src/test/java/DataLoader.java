import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.michackathon.api.dao.CustomerDAO;
import com.michackathon.api.dao.FlightDAO;
import com.michackathon.api.dao.TravelHistoryDAO;
import com.michackathon.api.domain.travelHistory.Customer;
import com.michackathon.api.domain.travelHistory.Flight;
import com.michackathon.api.domain.travelHistory.TravelHistory;
import com.michackathon.couchbase.CouchbaseClient;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.apache.commons.math.random.RandomData;
import org.apache.commons.math.random.RandomDataImpl;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by pankajmisra on 10/19/16.
 */
public class DataLoader {

    private static final int  MAX_CUSTOMERS = 100;
    private static final int  MAX_HISTORY = 20;

    private static ObjectMapper mapper  = new ObjectMapper();
    private static SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");

    public static void main(String[] args) throws JsonProcessingException, ParseException {

        mapper.setDateFormat(format);
        generateCustomer();

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
            flt.setDepDate(new Date(randomData.nextLong(currentDate.plusDays(3).getMillis(), currentDate.getMillis())));
        }
        flt.setFlightNumber(""+ randomData.nextInt(1,500));
        flt.setOrigin(Fairy.create().person().getAddress().getCity());
        flt.setDestination(Fairy.create().person().getAddress().getCity());
        System.out.println(mapper.writeValueAsString(flt));
        FlightDAO fltDAO = new FlightDAO(CouchbaseClient.getConnection("couchbase://localhost:8091","default"), Flight.class);
        fltDAO.put(flt.getFlightId(), flt);
        return flt;
    }

    private static void generateTravelHistory(Customer cust) throws JsonProcessingException, ParseException {

        TravelHistoryDAO travelHistoryDAO = new TravelHistoryDAO(CouchbaseClient.getConnection("couchbase://localhost:8091","default"), TravelHistory.class);

        for(int ctrHistory=0;ctrHistory<MAX_HISTORY; ctrHistory++) {
            TravelHistory history = new TravelHistory();
            history.setCustId(cust.getCustId());
            history.setId(UUID.randomUUID().toString());
            Flight flt = generateFlight(true);
            history.setFlightId(flt.getFlightId());
            history.setCustId(cust.getCustId());
            travelHistoryDAO.put(history.getId(), history);
        }

    }
}
