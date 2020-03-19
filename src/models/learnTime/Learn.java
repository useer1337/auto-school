package models.learnTime;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import models.EntityClass;
import models.man.Student;
import models.man.Teacher;
import models.room.Room;
import models.simulatorProgram.SimulatorProgram;

public class Learn extends EntityClass {
    private StringProperty start = new SimpleStringProperty();
    private ObjectProperty<Room> room = new SimpleObjectProperty<>();
    private ObjectProperty<Student> student = new SimpleObjectProperty<>();
    private ObjectProperty<Teacher> teacher = new SimpleObjectProperty<>();
    private ObjectProperty<SimulatorProgram> simulatorProgram = new SimpleObjectProperty<>();
    private ObjectProperty<LearnType> learnType = new SimpleObjectProperty<>();

    public Learn(Student student){
        this.student.set(student);
    }

    public Learn(){};

    public Learn(String start, Room room, Student student, Teacher teacher, SimulatorProgram simulatorProgram, LearnType learnType) {
        this.start.set(start);
        this.room.set(room);
        this.student.set(student);
        this.teacher.set(teacher);
        this.simulatorProgram.set(simulatorProgram);
        this.learnType.set(learnType);
    }

    public String getStart() {
        return start.get();
    }

    public StringProperty startProperty() {
        return start;
    }

    public void setStart(String start) {
        this.start.set(start);
    }

    public Room getRoom() {
        return room.get();
    }

    public ObjectProperty<Room> roomProperty() {
        return room;
    }

    public void setRoom(Room room) {
        this.room.set(room);
    }

    public Student getStudent() {
        return student.get();
    }

    public ObjectProperty<Student> studentProperty() {
        return student;
    }

    public void setStudent(Student student) {
        this.student.set(student);
    }

    public Teacher getTeacher() {
        return teacher.get();
    }

    public ObjectProperty<Teacher> teacherProperty() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher.set(teacher);
    }

    public SimulatorProgram getSimulatorProgram() {
        return simulatorProgram.get();
    }

    public ObjectProperty<SimulatorProgram> simulatorProgramProperty() {
        return simulatorProgram;
    }

    public void setSimulatorProgram(SimulatorProgram simulatorProgram) {
        this.simulatorProgram.set(simulatorProgram);
    }

    public LearnType getLearnType() {
        return learnType.get();
    }

    public ObjectProperty<LearnType> learnTypeProperty() {
        return learnType;
    }

    public void setLearnType(LearnType learnType) {
        this.learnType.set(learnType);
    }
}