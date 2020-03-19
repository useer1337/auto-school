package models.simulatorProgram;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.EntityClass;

public class SimulatorProgram extends EntityClass {
    private ObjectProperty<Category> category = new SimpleObjectProperty<>();
    private ObjectProperty<Transmission> transmission = new SimpleObjectProperty<>();

    public SimulatorProgram(Category category, Transmission transmission) {
        this.category.set(category);
        this.transmission.set(transmission);
    }

    public Category getCategory() {
        return category.get();
    }

    public ObjectProperty<Category> carProperty() {
        return category;
    }

    public void setCategory(Category category) {
        this.category.set(category);
    }

    public Transmission getTransmission() {
        return transmission.get();
    }

    public ObjectProperty<Transmission> transmissionProperty() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission.set(transmission);
    }
}
