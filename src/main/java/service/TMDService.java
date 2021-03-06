package service;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import config.TMDConfig;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import resources.AttributeResource;
import resources.MovieResource;
import resources.PersonResource;
import resources.SongResource;

/**
 * Created by renaganti on 5/18/16.
 */
public class TMDService extends Service<TMDConfig> {
    public static void main(String []args) throws Exception {
        new TMDService().run(args);
    }

    @Override
    public void initialize(Bootstrap<TMDConfig> bootstrap) {
        bootstrap.setName("TMD");
    }

    @Override
    public void run(TMDConfig config, Environment environment) {
        environment.addResource(new MovieResource(config.getMongoConfig()));
        environment.addResource(new PersonResource(config.getMongoConfig()));
        environment.addResource(new SongResource(config.getMongoConfig()));
        environment.addResource(new AttributeResource(config.getMongoConfig()));

        environment.addFilter(CrossOriginFilter.class, "/*")
                .setInitParam("allowedOrigins", "*")
                .setInitParam("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin")
                .setInitParam("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
    }
}
