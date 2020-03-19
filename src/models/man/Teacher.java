package models.man;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Teacher extends Person {
    private IntegerProperty experience = new SimpleIntegerProperty();

    public Teacher(String first_name, String last_name, String patronymic_name, int experience) {
        super(first_name, last_name, patronymic_name);
        this.experience.set(experience);
    }

    public int getExperience() {
        return experience.get();
    }

    public IntegerProperty experienceProperty() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience.set(experience);
    }
}
