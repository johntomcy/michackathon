import com.michackathon.api.controllers.rest.FlightController;
import com.michackathon.entity.Flight;
import com.michackathon.model.FlightSearch;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by pankajmisra on 10/22/16.
 */
public class FlightControllerTest {
    @Test
    public void testFlightSearch() throws ParseException, IOException {
        FlightController controller = new FlightController();
        FlightSearch fltSearch = new FlightSearch();
        fltSearch.setOrigin("DXB");
        fltSearch.setDestination("CPR");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fltSearch.setDepDate(dateFormat.parse("2016-10-24"));
        List<Flight> flights = controller.flightSearch(fltSearch);
        Assert.assertNotNull(flights);
        Assert.assertNotEquals(0, flights.size());
    }
}
