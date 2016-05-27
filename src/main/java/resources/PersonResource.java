package resources;

import com.mongodb.WriteResult;
import entities.Person;
import service.PersonService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by renaganti on 5/20/16.
 */
@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource extends BaseResource {
    private PersonService personService;

    public PersonResource(String mongoUrl, int mongoPort) {
        super(mongoUrl, mongoPort);
        personService = new PersonService(mongoUrl, mongoPort);
    }

    @GET
    public Person getPerson(@QueryParam("id") long id) {
        Person person = personService.getPerson(id);
        return person;
    }
    @GET
    @Path("/search")
    public List<Person> searchPerson(@QueryParam("name") String name,
                                     @QueryParam("profession") String profession) {
        return personService.searchPerson(name, profession);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPerson(Person person) {
        Person newPerson = personService.addNew(person);
        return newPerson;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Person updatePerson(Person person) {
        Person updatedPerson = personService.update(person);
        return updatedPerson;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public WriteResult deletePerson(Person person) {
        return personService.delete(person);
    }
}
