package service;

import com.mongodb.*;
import config.MongoConfig;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renaganti on 5/20/16.
 */
public class BaseService {
    protected MongoClient mongoClient;
    protected final Morphia morphia;
    protected final Datastore datastore;

    public BaseService(MongoConfig mongoConfig) {
        String server = mongoConfig.getMongoUrl();
        int port = mongoConfig.getMongoPort();
        String dbName = mongoConfig.getDbName();
        String userName = mongoConfig.getUserName();
        String password = mongoConfig.getPassword();

        //Check for Server name in config
        if( server == null || server.isEmpty() ) {
            morphia = null;
            datastore = null;
            return;
        }
        //Check for port number in config
        if( port == 0 ) {
            morphia = null;
            datastore = null;
            return;
        }
        //Check if dbName is present in the config
        if( dbName == null || dbName.isEmpty() ) {
            morphia = null;
            datastore = null;
            return;
        }

        morphia = new Morphia();
        morphia.mapPackage("entities");

        //If user name and password are present, prepare MongoClientURI
        if( userName != null && !userName.isEmpty() && password != null ) {
            ServerAddress addr = new ServerAddress(server, port);
            List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
            MongoCredential credential = MongoCredential.createCredential(
                    userName, dbName, password.toCharArray());
            credentialsList.add(credential);
            mongoClient = new MongoClient(addr, credentialsList);
        }
        else {
            mongoClient = new MongoClient(server, port);
        }
        datastore = morphia.createDatastore(mongoClient, dbName);
    }
}
