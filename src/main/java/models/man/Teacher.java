package models.man;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import models.learnTime.Learn;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Access(AccessType.PROPERTY)
public class Teacher extends Person {
    private IntegerProperty experience = new SimpleIntegerProperty();

    private Long id;

    public Teacher() {};

    public Teacher(String first_name, String last_name, String patronymic_name, int experience) {
        super(first_name, last_name, patronymic_name);
        this.experience.set(experience);
    }

    @Id
    @GeneratedValue(generator = "ID_TEACHER")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getExperience() {
        return experience.get();
    }

    @Transient
    public IntegerProperty experienceProperty() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience.set(experience);
    }
}
