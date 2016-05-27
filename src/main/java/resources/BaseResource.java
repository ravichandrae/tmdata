package resources;

/**
 * Created by renaganti on 5/20/16.
 */
public class BaseResource {
    protected String mongoUrl;
    protected int mongoPort;
    protected BaseResource(String mongoUrl, int mongoPort) {
        this.mongoUrl = mongoUrl;
        this.mongoPort = mongoPort;
    }
}
