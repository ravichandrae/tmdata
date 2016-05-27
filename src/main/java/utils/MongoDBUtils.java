package utils;

import entities.Counters;
import org.mongodb.morphia.Datastore;
import java.util.List;

/**
 * Created by renaganti on 5/19/16.
 */
public class MongoDBUtils {
    /***Returns the next available id for given counter type
        generates movieid, personid, songid
     ***/
    public static long getNextId(CounterType idType, Datastore datastore) {
        long nextId = -1;
        String idString = "";
        switch(idType) {
            case MOVIE_ID:
                idString = "movieid";
                break;
            case PERSON_ID:
                idString = "personid";
                break;
            case SONG_ID:
                idString = "songid";
                break;
        }
        //Only above ids can be generated
        if( idString.isEmpty() )
            return nextId;

        List<Counters> counters = datastore.createQuery(Counters.class)
                                    .filter("_id",idString)
                                    .asList();
        if( counters != null && !counters.isEmpty() ) {
            Counters movieIdCounter = counters.get(0);
            nextId = movieIdCounter.getSeq();
            ++nextId;
            movieIdCounter.setSeq(nextId);
            //update the counter
            datastore.save(movieIdCounter);
        }
        return nextId;
    }
}
