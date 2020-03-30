package controllers;

import gw.TeacherGetWay;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.man.Teacher;
import registry.GWRegistry;

public class TeachersController {
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

    private TeacherGetWay teacherGetWay = GWRegistry.getInstance().getTeacherGetWay();

    ObservableList<Teacher> teacherObservableList = FXCollections.observableArrayList(teacherGetWay.all());

    @FXML
    public void initialize() {
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().first_nameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().last_nameProperty());
        patronymicNameColumn.setCellValueFactory(cellData -> cellData.getValue().patronymic_nameProperty());
        stageColumn.setCellValueFactory(cellData -> cellData.getValue().experienceProperty());
        teacherTableView.setItems(teacherObservableList);
    }

    public void delTeacher(){
        Teacher teacher = teacherTableView.getSelectionModel().getSelectedItem();
        if(teacher != null){
            teacherGetWay.delete(teacher.getId());
            teacherObservableList.remove(teacher);
        }
    }

    public void newTeacher() throws Exception {
        Teacher teacher = new Teacher();
        addTeacher(teacher);
        teacherGetWay.insert(teacher);
        teacherObservableList.add(teacher);
    }

    public void addTeacher(Teacher teacher) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/newteacher.fxml"));
        VBox page = (VBox) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Добавить учителя");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        NewTeacherController newTeacherController = loader.getController();
        newTeacherController.setTeacher(teacher);

        dialogStage.show();
    }
}
