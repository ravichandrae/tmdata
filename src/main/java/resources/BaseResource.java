package resources;

import config.MongoConfig;

/**
 * Created by renaganti on 5/20/16.
 */
public class BaseResource {
    protected MongoConfig mongoConfig;
    protected BaseResource(MongoConfig mongoConfig) {
        this.mongoConfig = mongoConfig;
    }
}
