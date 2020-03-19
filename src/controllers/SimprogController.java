package controllers;


import gw.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.learnTime.Learn;
import models.man.Teacher;
import models.room.Room;
import models.simulatorProgram.SimulatorProgram;
import models.simulatorProgram.Category;
import models.simulatorProgram.Transmission;
import registry.GWRegistry;


public class SimprogController {
    @FXML
    ComboBox<Room> roomComboBox;

    @FXML
    ComboBox<Transmission> transmissionComboBox;

    @FXML
    ComboBox<Category> categoryComboBox;

    @FXML
    TableView<Teacher> teacherTableView;

    @FXML
    TableColumn<Teacher, String> nameColumn;

    @FXML
    TableColumn<Teacher, String> lastNameColumn;

    @FXML
    TableColumn<Teacher, String> patronymicNameColumn;

    @FXML
    TableColumn<Teacher, Number> stageColumn;

    private Learn learn;

    private RoomGetWay roomGetWay = GWRegistry.getInstance().getRoomGetWay();
    private TransmissionGetWay transmissionGetWay = GWRegistry.getInstance().getTransmissionGetWay();
    private CategoryGetWay categoryGetWay = GWRegistry.getInstance().getCategoryGetWay();
    private TeacherGetWay teacherGetWay = GWRegistry.getInstance().getTeacherGetWay();
    private LearnGW learnGW = GWRegistry.getInstance().getLearnGW();
    private SimulatorProgramGetWay simulatorProgramGetWay = GWRegistry.getInstance().getSimulatorProgramGetWay();

    ObservableList<Teacher> teachers = FXCollections.observableArrayList(teacherGetWay.all());


    @FXML
    public void initialize() {
        roomComboBox.setItems(FXCollections.observableArrayList(roomGetWay.all()));
        transmissionComboBox.setItems(FXCollections.observableArrayList(transmissionGetWay.all()));
        categoryComboBox.setItems(FXCollections.observableArrayList(categoryGetWay.all()));
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().first_nameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().last_nameProperty());
        patronymicNameColumn.setCellValueFactory(cellData -> cellData.getValue().patronymic_nameProperty());
        stageColumn.setCellValueFactory(cellData -> cellData.getValue().experienceProperty());
        teacherTableView.setItems(teachers);
    }

    public void findLearn(Learn learn) {
        this.learn = learn;
    }

    public void clickNext() throws Exception {

        Room selectedRoom = roomComboBox.getSelectionModel().getSelectedItem();
        Teacher selectedTeacher = teacherTableView.getSelectionModel().getSelectedItem();
        SimulatorProgram selectedSimulatorProgram = simulatorProgramGetWay.findSimulatorProgramm(categoryComboBox.getSelectionModel().getSelectedItem(),
                transmissionComboBox.getSelectionModel().getSelectedItem());

        learn.setRoom(selectedRoom);
        learn.setTeacher(selectedTeacher);
        learn.setSimulatorProgram(selectedSimulatorProgram);

        typeAndTime(learn);
    }

    public void typeAndTime(Learn learn) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/typeAndTime.fxml"));
        VBox page = (VBox) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Тип и время обучения");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        TypeAndTimeController typeAndTimeController = loader.getController();
        typeAndTimeController.findLearn(learn);

        dialogStage.show();
        Stage curStage = (Stage) roomComboBox.getScene().getWindow();
        curStage.close();
    }


}
