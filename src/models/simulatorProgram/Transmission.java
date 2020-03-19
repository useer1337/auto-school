package models.simulatorProgram;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import models.EntityClass;

public class Transmission extends EntityClass {
    private StringProperty transmission_type = new SimpleStringProperty();

    public Transmission(String transmission_type) {
        this.transmission_type.set(transmission_type);
    }

    public String getTransmission_type() {
        return transmission_type.get();
    }

    public StringProperty transmission_typeProperty() {
        return transmission_type;
    }

    public void setTransmission_type(String transmission_type) {
        this.transmission_type.set(transmission_type);
    }

    @Override
    public String toString() {
        return getTransmission_type();
    }
}
