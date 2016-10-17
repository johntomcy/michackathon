import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.java.Bucket;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by pankajmisra on 10/16/16.
 */
public class CouchbaseEntityDAOTest {


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
        dao.put(UUID.randomUUID().toString(), entity);
    }

}
