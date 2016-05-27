package resources;

import config.MongoConfig;
import entities.Attribute;
import entities.Person;
import service.AttributeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by renaganti on 5/27/16.
 */
@Path("/attribute")
@Produces(MediaType.APPLICATION_JSON)
public class AttributeResource extends BaseResource {
    private AttributeService attributeService;
    public AttributeResource(MongoConfig mongoConfig) {
        super(mongoConfig);
        attributeService = new AttributeService(mongoConfig);
    }

    @GET
    public List<Attribute> getAttributes() {
        return attributeService.getAttributes();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Attribute addAttribute(Attribute attribute) {
        return attributeService.addNew(attribute);
    }
}
