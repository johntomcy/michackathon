import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.core.type.TypeReference;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.type.ReferenceType;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

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
    }

    public T get(String key) {
        JsonDocument document = couchbaseClient.getConnection().get(key);
        T entity = (T) mapper.convertValue(document, type);
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

}
