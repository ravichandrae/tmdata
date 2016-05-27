package service;


import config.MongoConfig;
import entities.Attribute;
import entities.Person;
import utils.CounterType;
import utils.MongoDBUtils;

import java.util.List;

/**
 * Created by renaganti on 5/27/16.
 */
public class AttributeService extends BaseService {
    public AttributeService(MongoConfig mongoConfig) {
        super(mongoConfig);
    }

    public Attribute addNew(Attribute attribute) {
        datastore.save(attribute);
        return attribute;
    }

    public List<Attribute> getAttributes() {
        List<Attribute> attributes = datastore.createQuery(Attribute.class)
                                    .asList();
        return attributes;
    }
}
