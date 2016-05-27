package config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

/**
 * Created by renaganti on 5/18/16.
 */
public class TMDConfig extends Configuration{
    @JsonProperty
    private String mongoUrl;

    @JsonProperty
    private int mongoPort;

    public String getMongoUrl() {
        return mongoUrl;
    }

    public void setMongoUrl(String mongoUrl) {
        this.mongoUrl = mongoUrl;
    }

    public int getMongoPort() {
        return mongoPort;
    }

    public void setMongoPort(int mongoPort) {
        this.mongoPort = mongoPort;
    }
}
