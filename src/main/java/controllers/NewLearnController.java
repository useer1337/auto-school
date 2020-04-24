package controllers;

import Formatters.FirstFormatter;
import exceptions.EntityNotFound;
import gw.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.learnTime.Learn;
import models.learnTime.LearnType;
import models.man.Student;
import models.man.Teacher;
import models.room.Room;
import models.simulatorProgram.Category;
import models.simulatorProgram.Transmission;
import registry.GWRegistry;

public class NewLearnController {
    @FXML
    TextField lastNameTF;

    @FXML
    TextField firstNameTF;

    @FXML
    TextField patronymicNameTF;

    @FXML
    TextField ageTF;

    @FXML
    ComboBox<Category> categoryComboBox;

    @FXML
    ComboBox<Transmission> transmissionComboBox;

    @FXML
    TableView<Teacher> teacherTableView;

    @FXML
    TableColumn<Teacher, String> lastNameColumn;

    @FXML
    TableColumn<Teacher, String> firstNameColumn;

    @FXML
    TableColumn<Teacher, String> patronymicNameColumn;

    @FXML
    TableColumn<Teacher, Number> stageColumn;

    @FXML
    ComboBox<Room> roomComboBox;

    @FXML
    ComboBox<LearnType> learnTypeComboBox;

    @FXML
    DatePicker datePicker;

    private Learn learn;

    private RoomGetWay roomGetWay = GWRegistry.getInstance().getRoomGetWay();
    private TransmissionGetWay transmissionGetWay = GWRegistry.getInstance().getTransmissionGetWay();
    private CategoryGetWay categoryGetWay = GWRegistry.getInstance().getCategoryGetWay();
    private TeacherGetWay teacherGetWay = GWRegistry.getInstance().getTeacherGetWay();
    private SimulatorProgramGetWay simulatorProgramGetWay = GWRegistry.getInstance().getSimulatorProgramGetWay();
    private LearnTypeGetWay learnTypeGetWay = GWRegistry.getInstance().getLearnTypeGetWay();

    ObservableList<Teacher> teachers = FXCollections.observableArrayList(teacherGetWay.all());

    public void findLearn(Learn learn) {
        this.learn = learn;
    }

    @FXML
    public void initialize() {
        ageTF.setTextFormatter(new FirstFormatter());
        roomComboBox.setItems(FXCollections.observableArrayList(roomGetWay.all()));
        transmissionComboBox.setItems(FXCollections.observableArrayList(transmissionGetWay.all()));
        categoryComboBox.setItems(FXCollections.observableArrayList(categoryGetWay.all()));
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().first_nameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().last_nameProperty());
        patronymicNameColumn.setCellValueFactory(cellData -> cellData.getValue().patronymic_nameProperty());
        stageColumn.setCellValueFactory(cellData -> cellData.getValue().experienceProperty());
        teacherTableView.setItems(teachers);
        learnTypeComboBox.setItems(FXCollections.observableArrayList(learnTypeGetWay.all()));
    }

    public void back(){
        Stage stage = (Stage) lastNameTF.getScene().getWindow();
        stage.close();
    }

    public void add() throws EntityNotFound {
        if (firstNameTF.getText().trim().length() != 0 && lastNameTF.getText().trim().length() != 0 && patronymicNameTF.getText().trim().length() != 0 &&
                ageTF.getText().trim().length() != 0 && roomComboBox.getSelectionModel().getSelectedItem() != null &&
                teacherTableView.getSelectionModel().getSelectedItem() != null && categoryComboBox.getSelectionModel().getSelectedItem() != null &&
                transmissionComboBox.getSelectionModel().getSelectedItem() != null && learnTypeComboBox.getSelectionModel().getSelectedItem() != null &&
                datePicker.getValue() != null) {

            Student student = new Student(firstNameTF.getText(), lastNameTF.getText(), patronymicNameTF.getText(),
                    Integer.parseInt(ageTF.getText()));

            learn.setStudent(student);
            learn.setRoom(roomComboBox.getSelectionModel().getSelectedItem());
            learn.setTeacher(teacherTableView.getSelectionModel().getSelectedItem());
            learn.setSimulatorProgram(simulatorProgramGetWay.findSimulatorProgramm(categoryComboBox.getSelectionModel().getSelectedItem(),
                    transmissionComboBox.getSelectionModel().getSelectedItem()));
            learn.setLearnType(learnTypeComboBox.getSelectionModel().getSelectedItem());
            learn.setStart(datePicker.getValue());

            Stage stage = (Stage) learnTypeComboBox.getScene().getWindow();
            stage.close();
        }

        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Ошибка при создании нового ученика");
            alert.setContentText("Вы не ввели данные!");
            alert.showAndWait();
        }

    }


}
