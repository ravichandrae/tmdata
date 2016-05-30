package entities;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import java.util.List;
import java.util.Map;

/**
 * Created by renaganti on 5/18/16.
 */
@Entity("person")
public class Person {

    @Id
    @Property("_id")
    private long id;

    @Property("name")
    private String name;

    @Property("gender")
    private String gender;

    @Property("birthDate")
    private String birthDate;

    @Property("birthPlace")
    private String birthPlace;

    @Property("deathDate")
    private String deathDate;

    @Property("deathPlace")
    private String deathPlace;

    @Property("alternateNames")
    private List<String> alternateNames;

    @Embedded("occupations")
    private List<Attribute> occupations;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Attribute> getOccupations() {
        return occupations;
    }

    public void setOccupations(List<Attribute> occupations) {
        this.occupations = occupations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAlternateNames() {
        return alternateNames;
    }

    public void setAlternateNames(List<String> alternateNames) {
        this.alternateNames = alternateNames;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getDeathPlace() {
        return deathPlace;
    }

    public void setDeathPlace(String deathPlace) {
        this.deathPlace = deathPlace;
    }
}
