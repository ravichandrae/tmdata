package service;

import com.mongodb.WriteResult;
import config.MongoConfig;
import entities.Song;
import org.mongodb.morphia.query.Query;
import utils.CounterType;
import utils.MongoDBUtils;

import java.util.List;

/**
 * Created by renaganti on 5/18/16.
 */
public class SongService extends BaseService {
    public SongService(MongoConfig mongoConfig) {
        super(mongoConfig);
    }
    public Song addNew(Song song) {
        long songId = MongoDBUtils.getNextId(CounterType.SONG_ID, datastore);
        song.setId(songId);
        datastore.save(song);
        return song;
    }

    public Song getSong(long id) {
        List<Song> songs = datastore.createQuery(Song.class)
                .filter("_id", id)
                .asList();
        Song song = null;
        if( songs != null && !songs.isEmpty())
            song = songs.get(0);
        return song;
    }

    public List<Song> searchSong(String title, String singer, String composer, String album) {
        Query<Song> query= datastore.createQuery(Song.class);
        if( title != null && !title.isEmpty() )
            query = query.field("title").contains(title);
        if( singer != null && !singer.isEmpty() )
            query = query.field("singers").contains(singer);
        if( composer != null && !composer.isEmpty() )
            query = query.field("composer").contains(composer);
        if( album != null && !album.isEmpty() )
            query = query.field("album").contains(album);
        List<Song> songs = query.asList();
        return songs;
    }

    public Song update(Song song) {
        datastore.save(song);
        return song;
    }

    public WriteResult delete(Song song) {
        Query<Song> songQuery = datastore.createQuery(Song.class)
                .filter("_id", song.getId());
        WriteResult deleteResult = datastore.delete(songQuery);
        return deleteResult;
    }
}
