package controllers;

import gw.LearnGW;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.learnTime.Learn;
import models.learnTime.LearnType;
import models.man.Student;
import registry.GWRegistry;

public class MainFormController {
    @FXML
    TableView<Learn> learnTableView;

    @FXML
    TableColumn<Learn, Student> learnNameColumn;

    @FXML
    TableColumn<Learn, LearnType> learnTypeColumn;

    private LearnGW learnGW = GWRegistry.getInstance().getLearnGW();

    ObservableList<Learn> learns = FXCollections.observableArrayList(learnGW.all());

    @FXML
    public void initialize() {
        learnNameColumn.setCellValueFactory(cell -> cell.getValue().studentProperty());
        learnTypeColumn.setCellValueFactory(cell -> cell.getValue().learnTypeProperty());
        learnTableView.setItems(learns);
    }

    public void lookTeachers() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/teachers.fxml"));
        VBox page = (VBox) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Все учителя");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setResizable(false);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        dialogStage.show();
    }

    public void lookRooms() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/rooms.fxml"));
        VBox page = (VBox) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Места обучения");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setResizable(false);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        dialogStage.show();
    }

    public void look() throws Exception {
        Learn learn = learnTableView.getSelectionModel().getSelectedItem();
        if(learn != null){
            lookLearn(learn);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Ошибка при попытке просмотра ученика");
            alert.setContentText("Вы не выбрали ученика!");
            alert.showAndWait();
        }
    }

    public void del() {
        Learn curLearn = learnTableView.getSelectionModel().getSelectedItem();
        if (curLearn != null) {
            learnGW.delete(curLearn);
            learns.remove(curLearn);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Ошибка при удалении");
            alert.setContentText("Вы не выбрали ученика!");
            alert.showAndWait();
        }
    }

    public void newLearn() throws Exception {
        Learn learn = new Learn();
        newStudent(learn);
        if (learn.getStudent() != null) {
            learnGW.insert(learn);
            learns.add(learn);
        }
    }

    public void lookLearn(Learn learn) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/look.fxml"));
        VBox page = (VBox) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Ученик");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setResizable(false);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        LookController lookController = loader.getController();
        lookController.setLearn(learn);

        dialogStage.show();
    }

    public void newStudent(Learn learn) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/newlearn.fxml"));
        VBox page = (VBox) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Новый ученик");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setResizable(false);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        NewLearnController newLearnController = loader.getController();
        newLearnController.findLearn(learn);

        dialogStage.showAndWait();
    }
}