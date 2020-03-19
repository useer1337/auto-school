package models.learnTime;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import models.EntityClass;

public class LearnType extends EntityClass {
    private StringProperty name = new SimpleStringProperty();

    public LearnType(String name) {
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public String toString(){
        return getName();
    }
}
