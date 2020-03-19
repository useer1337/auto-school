package models.man;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Student extends Person {
    private IntegerProperty age = new SimpleIntegerProperty();

    public Student(){};

    public Student(String first_name, String last_name, String patronymic_name, int age) {
        super(first_name, last_name, patronymic_name);
        this.age.set(age);
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    @Override
    public String toString(){
        return getFirst_name() + " " + getLast_name() + " " + getPatronymic_name();
    }

}