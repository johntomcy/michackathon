import com.michackathon.api.controllers.rest.RecommendationController;
import com.michackathon.api.model.FlightSearch;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by pankajmisra on 10/22/16.
 */
public class RecommendationControllerTest {

    @Test

    public void testGetRecommendations() throws IOException, ParseException {
        RecommendationController rec = new RecommendationController();
        FlightSearch search = new FlightSearch();
        search.setOrigin("DXB");
        search.setDepDate(new SimpleDateFormat("yyyy-MM-dd").parse("2016-10-24"));
        rec.getRecommendations("db0731f4-9244-4f96-9f6f-c6267fb6feaf", search);
    }
}
