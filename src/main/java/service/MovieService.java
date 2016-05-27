package service;

import com.mongodb.WriteResult;
import config.MongoConfig;
import entities.Movie;
import org.mongodb.morphia.query.Query;
import utils.CounterType;
import utils.MongoDBUtils;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;
/**
 * Created by renaganti on 5/18/16.
 */
public class MovieService extends BaseService {

    public MovieService(MongoConfig mongoConfig) {
        super(mongoConfig);
    }
    public Movie addNew(Movie movie) {
        long movieId = MongoDBUtils.getNextId(CounterType.MOVIE_ID, datastore);
        movie.setId(movieId);
        datastore.save(movie);
        return movie;
    }

    public Movie getMovie(long id) {
        List<Movie> movies = datastore.createQuery(Movie.class)
                                            .filter("_id", id)
                                            .asList();
        Movie movie = null;
        if( movies != null && !movies.isEmpty())
            movie = movies.get(0);
        return movie;
    }

    public Movie update(Movie movie) {
        datastore.save(movie);
        return movie;
    }

    public WriteResult delete(Movie movie) {
        Query<Movie> movieQuery = datastore.createQuery(Movie.class)
                                        .filter("_id", movie.getId());
        WriteResult deleteResult = datastore.delete(movieQuery);
        return deleteResult;
    }

    public List<Movie> searchMovie(String title) {
        Query<Movie> movieQuery = datastore.createQuery(Movie.class);
        if( title != null && !title.isEmpty() ) {
            movieQuery = movieQuery.field("title").contains(title);
        }
        return movieQuery.asList();
    }
}
