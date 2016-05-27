package config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

/**
 * Created by renaganti on 5/18/16.
 */
public class TMDConfig extends Configuration{
    private MongoConfig mongoConfig;

    public MongoConfig getMongoConfig() {
        return mongoConfig;
    }

    public void setMongoConfig(MongoConfig mongoConfig) {
        this.mongoConfig = mongoConfig;
    }
}
