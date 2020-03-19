package models.simulatorProgram;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import models.EntityClass;

public class Category extends EntityClass {
    private StringProperty category_type = new SimpleStringProperty();

    public Category(String category_type) {
        this.category_type.set(category_type);
    }

    public String getCategory_type() {
        return category_type.get();
    }

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
