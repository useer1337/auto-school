package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.room.Room;

public class NewRoomController {
    @FXML
    TextField textField;

    private Room room;

    public void setRoom(Room room) {
        this.room = room;
    }

    public void back() {
        Stage stage = (Stage) textField.getScene().getWindow();
        stage.close();
    }

    public void add() {
        if(textField.getText().trim().length() != 0){
            room.setAddress(textField.getText());
            Stage stage = (Stage) textField.getScene().getWindow();
            stage.close();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Ошибка при попытке добавить новое помещение");
            alert.setContentText("Вы не ввели данные!");
            alert.showAndWait();
        }

    }
}
