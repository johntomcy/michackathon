import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.JsonNode;
import com.couchbase.client.java.Bucket;
import com.michackathon.couchbase.CouchbaseClient;
import com.michackathon.couchbase.JSONEntityDAO;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by pankajmisra on 10/16/16.
 */
public class CouchbaseEntityDAOTest {

   public static final String sampleUUID = UUID.randomUUID().toString();

    @Test
    public void getConnectionTest() {
        Bucket bucket  = CouchbaseClient.getConnection("couchbase://127.0.0.1", "default").getConnection();
        Assert.assertNotNull(bucket);
    }



    @Test
    public void putSampleEntity() throws JsonProcessingException {
        SampleEntity entity = new SampleEntity();
        entity.setAge(38);
        entity.setName("Test");
        CouchbaseClient client  = CouchbaseClient.getConnection("couchbase://127.0.0.1", "default");
        SampleEntityDAO dao = new SampleEntityDAO(client, SampleEntity.class);
        System.out.println(sampleUUID);
        dao.put(sampleUUID, entity);
    }

    @Test
    public void getSampleEntity() throws IOException {
        CouchbaseClient client  = CouchbaseClient.getConnection("couchbase://127.0.0.1", "default");
        SampleEntityDAO dao = new SampleEntityDAO(client, SampleEntity.class);
        System.out.println(sampleUUID);
        SampleEntity entity = dao.get(sampleUUID);
        Assert.assertNotNull(entity);
        Assert.assertEquals(38, entity.getAge());
        Assert.assertEquals("Test", entity.getName());
    }

    @Test
    public void getResultsByQuery() throws IOException {
        String query = "Select * FROM `default` limit 10";
        CouchbaseClient client = CouchbaseClient.getConnection("couchbase://127.0.0.1", "default");
        JSONEntityDAO dao = new JSONEntityDAO(client, JsonNode.class);
        List<JsonNode> objects = dao.getByQuery(query);
        Assert.assertEquals(10, objects.size());
        for(JsonNode object: objects) {
            System.out.println(object.toString());
        }
    }

}
