package models.man;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Student extends Person {
    private IntegerProperty age = new SimpleIntegerProperty();

    private Long id;

    public Student() {};

    public Student(String first_name, String last_name, String patronymic_name, int age) {
        super(first_name, last_name, patronymic_name);
        this.age.set(age);
    }

    @Id
    @GeneratedValue(generator = "ID_STUDENT")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age.get();
    }

    @Transient
    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    @Override
    public String toString() {
        return getLast_name() + " " + getFirst_name() + " " + getPatronymic_name();
    }

}