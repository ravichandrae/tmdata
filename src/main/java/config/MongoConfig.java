package config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by renaganti on 5/27/16.
 */
public class MongoConfig {
    @JsonProperty
    private String mongoUrl;

    @JsonProperty
    private int mongoPort;

    @JsonProperty
    private String dbName;

    @JsonProperty
    private
    String userName;

    @JsonProperty
    private
    String password;


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

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
