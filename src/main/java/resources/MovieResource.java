package resources;

import com.mongodb.WriteResult;
import entities.Movie;
import service.MovieService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by renaganti on 5/18/16.
 */
@Path("/movie")
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource extends BaseResource{
    private MovieService movieService;
    public MovieResource(String mongoUrl, int mongoPort) {
        super(mongoUrl, mongoPort);
        movieService = new MovieService(mongoUrl, mongoPort);
    }

    @GET
    public Movie getMovie(@QueryParam("id") long id) {
        Movie movie = movieService.getMovie(id);
        return movie;
    }

    @GET
    @Path("/search")
    public List<Movie> searchPerson(@QueryParam("title") String title) {
        return movieService.searchMovie(title);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Movie addMovie(Movie movie) {
        Movie newMovie = movieService.addNew(movie);
        return newMovie;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Movie updateMovie(Movie movie) {
        Movie updatedMovie = movieService.update(movie);
        return updatedMovie;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public WriteResult deleteMovie(Movie movie) {
       return movieService.delete(movie);
    }
}
