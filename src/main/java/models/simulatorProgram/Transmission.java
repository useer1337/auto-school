package models.simulatorProgram;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Transmission {
    private StringProperty transmission_type = new SimpleStringProperty();

    private int id;

    public Transmission(){};

    public Transmission(String transmission_type) {
        this.transmission_type.set(transmission_type);
    }

    @Id
    @GeneratedValue(generator = "ID_TRANSMISSION")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransmission_type() {
        return transmission_type.get();
    }

    @Transient
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
