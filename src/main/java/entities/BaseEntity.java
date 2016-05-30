package entities;

import org.mongodb.morphia.annotations.Property;

/**
 * Created by renaganti on 5/30/16.
 */
public abstract class BaseEntity {
    @Property("lastUpdated")
    private String lastUpdated;

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
