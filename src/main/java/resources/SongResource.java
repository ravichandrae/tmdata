package resources;

import com.mongodb.WriteResult;
import config.MongoConfig;
import entities.Song;
import service.SongService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by renaganti on 5/20/16.
 */
@Path("/song")
@Produces(MediaType.APPLICATION_JSON)
public class SongResource extends BaseResource {
    private SongService songService;
    public SongResource(MongoConfig mongoConfig) {
        super(mongoConfig);
        songService = new SongService(mongoConfig);
    }

    @GET
    public Song getSong(@QueryParam("id") long id) {
        Song song = songService.getSong(id);
        return song;
    }

    @GET
    @Path("/search")
    public List<Song> searchSong(@QueryParam("title") String title,
                                 @QueryParam("singer") String singer,
                                 @QueryParam("composer") String composer,
                                 @QueryParam("album") String album) {
        List<Song> searchResults = songService.searchSong(title, singer, composer, album);
        return searchResults;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Song addSong(Song song) {
        Song newSong = songService.addNew(song);
        return newSong;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Song updateSong(Song song) {
        Song updatedSong = songService.update(song);
        return updatedSong;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public WriteResult deleteSong(Song song) {
        return songService.delete(song);
    }
}
