package com.michackathon.couchbase;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;

import java.util.concurrent.TimeUnit;

/**
 * Created by pankajmisra on 10/16/16.
 */
public class CouchbaseClient {

    private CouchbaseClient(String connectionString, String bucketName) {
        CouchbaseEnvironment env = DefaultCouchbaseEnvironment
            .builder()
            .connectTimeout(6000)
            .kvTimeout(6000)
            .computationPoolSize(5)
            .socketConnectTimeout(6000)
            .build();
        CouchbaseCluster cluster = CouchbaseCluster.create(env, connectionString);
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
