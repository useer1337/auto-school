package models.room;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import models.learnTime.Learn;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Access(AccessType.PROPERTY)
public class Room {
    private Long Id;

    private StringProperty address = new SimpleStringProperty();

    public Room() {};

    public Room(String address) {
        this.address.set(address);
    }

    @Id
    @GeneratedValue(generator = "ID_ROOM")
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAddress() {
        return address.get();
    }

    @Transient
    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    @Override
    public String toString() {
        return getAddress();
    }
}