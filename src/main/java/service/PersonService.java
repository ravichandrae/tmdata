package service;

import com.mongodb.WriteResult;
import config.MongoConfig;
import entities.Person;
import org.mongodb.morphia.query.Query;
import utils.CounterType;
import utils.MongoDBUtils;

import java.util.List;

/**
 * Created by renaganti on 5/18/16.
 */
public class PersonService extends BaseService {
    public PersonService(MongoConfig mongoConfig) {
        super(mongoConfig);
    }
    public Person addNew(Person person) {
        long personId = MongoDBUtils.getNextId(CounterType.PERSON_ID, datastore);
        person.setId(personId);
        datastore.save(person);
        return person;
    }

    public Person getPerson(long id) {
        List<Person> persons = datastore.createQuery(Person.class)
                .filter("_id", id)
                .asList();
        Person person = null;
        if( persons != null && !persons.isEmpty())
            person = persons.get(0);
        return person;
    }

    public Person update(Person person) {
        datastore.save(person);
        return person;
    }

    public WriteResult delete(Person person) {
        Query<Person> personQuery = datastore.createQuery(Person.class)
                .filter("_id", person.getId());
        WriteResult deleteResult = datastore.delete(personQuery);
        return deleteResult;
    }

    public List<Person> searchPerson(String name, String profession) {
        Query<Person> personQuery = datastore.createQuery(Person.class);
        if( name != null && !name.isEmpty() ) {
            personQuery = personQuery.field("name").contains(name);
        }
        if( profession != null && !profession.isEmpty() ) {
            personQuery = personQuery.field("occupations").contains(profession);
        }
        return personQuery.asList();
    }
}
