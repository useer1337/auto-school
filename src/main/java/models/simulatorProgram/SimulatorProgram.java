package models.simulatorProgram;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class SimulatorProgram {
    private ObjectProperty<Category> category = new SimpleObjectProperty<>();
    private ObjectProperty<Transmission> transmission = new SimpleObjectProperty<>();

    private Long id;

    public SimulatorProgram(){};

    public SimulatorProgram(Category category, Transmission transmission) {
        this.category.set(category);
        this.transmission.set(transmission);
    }

    @Id
    @GeneratedValue(generator = "ID_SIMULATORPROGRAM")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    public Category getCategory() {
        return category.get();
    }

    @Transient
    public ObjectProperty<Category> carProperty() {
        return category;
    }

    public void setCategory(Category category) {
        this.category.set(category);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transmissionId")
    public Transmission getTransmission() {
        return transmission.get();
    }

    @Transient
    public ObjectProperty<Transmission> transmissionProperty() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission.set(transmission);
    }
}
