package models.simulatorProgram;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Category{
    private StringProperty category_type = new SimpleStringProperty();

    private int id;

    public Category(){};

    public Category(String category_type) {
        this.category_type.set(category_type);
    }

    @Id
    @GeneratedValue(generator = "ID_CATEGORY")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_type() {
        return category_type.get();
    }

    @Transient
    public StringProperty category_typeProperty() {
        return category_type;
    }

    public void setCategory_type(String category_type) {
        this.category_type.set(category_type);
    }

    @Override
    public String toString() {
        return getCategory_type();
    }
}
