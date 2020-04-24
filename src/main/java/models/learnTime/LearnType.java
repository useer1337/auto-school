package models.learnTime;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class LearnType {

    private Long id;
    private StringProperty name = new SimpleStringProperty();

    public LearnType(){};

    public LearnType(String name) {
        this.name.set(name);
    }

    @Id
    @GeneratedValue(generator = "ID_LEARNTYPE")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name.get();
    }

    @Transient
    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
