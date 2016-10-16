import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;

/**
 * Created by pankajmisra on 10/16/16.
 */
public class CouchbaseClient {

    private CouchbaseClient(String connectionString, String bucketName) {
        CouchbaseCluster cluster = CouchbaseCluster.create(connectionString);
        this.bucket =  cluster.openBucket(bucketName);
    }

    private static volatile CouchbaseClient connection;

    private Bucket bucket;

    public static CouchbaseClient getConnection(String connectionString, String bucketName) {

        if (connection == null) {
                synchronized (CouchbaseClient.class) {
                    if (connection == null) {
                        synchronized ( CouchbaseClient.class) {
                            connection = new CouchbaseClient(connectionString, bucketName);
                        }
                    }
                }
            }
        return connection;
    }

    public static synchronized void closeConnection() {
        if (connection.bucket != null) {
            if (!connection.bucket.isClosed()) {
                connection.bucket.close();
            }
        }
    }

    public Bucket getConnection() {
        return bucket;
    }

}
