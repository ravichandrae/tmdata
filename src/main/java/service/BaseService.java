package service;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Created by renaganti on 5/20/16.
 */
public class BaseService {
    protected MongoClient mongoClient;
    protected final Morphia morphia;
    protected final Datastore datastore;

    public BaseService(String mongoUrl, int port) {
        mongoClient = new MongoClient(mongoUrl, port);
        morphia = new Morphia();
        morphia.mapPackage("entities");
        datastore = morphia.createDatastore(mongoClient, "tmdb");
    }
}
