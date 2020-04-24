package models.learnTime;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.man.Student;
import models.man.Teacher;
import models.room.Room;
import models.simulatorProgram.SimulatorProgram;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Access(AccessType.PROPERTY)
public class Learn {

    private long id;
    private ObjectProperty<LocalDate> start = new SimpleObjectProperty<>();
    private ObjectProperty<Room> room = new SimpleObjectProperty<>();
    private ObjectProperty<Student> student = new SimpleObjectProperty<>();
    private ObjectProperty<Teacher> teacher = new SimpleObjectProperty<>();
    private ObjectProperty<SimulatorProgram> simulatorProgram = new SimpleObjectProperty<>();
    private ObjectProperty<LearnType> learnType = new SimpleObjectProperty<>();

    public Learn(Student student) {
        this.student.set(student);
    }

    public Learn() {};

    public Learn(LocalDate start, Room room, Student student, Teacher teacher, SimulatorProgram simulatorProgram, LearnType learnType) {
        this.start.set(start);
        this.room.set(room);
        this.student.set(student);
        this.teacher.set(teacher);
        this.simulatorProgram.set(simulatorProgram);
        this.learnType.set(learnType);
    }

    @Id
    @GeneratedValue(generator = "ID_LEARN")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start.get();
    }

    @Transient
    public ObjectProperty<LocalDate> startProperty() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start.set(start);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId", nullable = false)
    public Room getRoom() {
        return room.get();
    }

    @Transient
    public ObjectProperty<Room> roomProperty() {
        return room;
    }

    public void setRoom(Room room) {
        this.room.set(room);
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId", nullable = false)
    public Student getStudent() {
        return student.get();
    }

    @Transient
    public ObjectProperty<Student> studentProperty() {
        return student;
    }

    public void setStudent(Student student) {
        this.student.set(student);
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherId")
    public Teacher getTeacher() {
        return teacher.get();
    }

    @Transient
    public ObjectProperty<Teacher> teacherProperty() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher.set(teacher);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "simulatorProgramId", nullable = false)
    public SimulatorProgram getSimulatorProgram() {
        return simulatorProgram.get();
    }

    @Transient
    public ObjectProperty<SimulatorProgram> simulatorProgramProperty() {
        return simulatorProgram;
    }

    public void setSimulatorProgram(SimulatorProgram simulatorProgram) {
        this.simulatorProgram.set(simulatorProgram);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "learnTypeId", nullable = false)
    public LearnType getLearnType() {
        return learnType.get();
    }

    @Transient
    public ObjectProperty<LearnType> learnTypeProperty() {
        return learnType;
    }

    public void setLearnType(LearnType learnType) {
        this.learnType.set(learnType);
    }
}