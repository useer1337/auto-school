package models.man;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass //TODO ДРУГИЕ СТРАТЕГИИ
public abstract class  Person{
    private StringProperty first_name = new SimpleStringProperty();
    private StringProperty last_name = new SimpleStringProperty();
    private StringProperty patronymic_name = new SimpleStringProperty();

    public Person(){};

    public Person(String first_name, String last_name, String patronymic_name) {
        this.first_name.set(first_name);
        this.last_name.set(last_name);
        this.patronymic_name.set(patronymic_name);
    }

    public String getFirst_name() {
        return first_name.get();
    }
    @Transient
    public StringProperty first_nameProperty() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name.set(first_name);
    }

    public String getLast_name() {
        return last_name.get();
    }
    @Transient
    public StringProperty last_nameProperty() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name.set(last_name);
    }

    public String getPatronymic_name() {
        return patronymic_name.get();
    }
    @Transient
    public StringProperty patronymic_nameProperty() {
        return patronymic_name;
    }

    public void setPatronymic_name(String patronymic_name) {
        this.patronymic_name.set(patronymic_name);
    }
}
