package service;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import config.TMDConfig;
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
        environment.addResource(new MovieResource(config.getMongoUrl(), config.getMongoPort()));
        environment.addResource(new PersonResource(config.getMongoUrl(), config.getMongoPort()));
        environment.addResource(new SongResource(config.getMongoUrl(), config.getMongoPort()));
    }
}
