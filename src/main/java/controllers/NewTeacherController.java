package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.man.Teacher;


public class NewTeacherController {
    @FXML
    TextField lastNameTF;

    @FXML
    TextField firstNameTF;

    @FXML
    TextField patronymicNameTF;

    @FXML
    TextField experienceTF;

    private Teacher teacher;

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public void add(){
        String text = lastNameTF.getText();
        if(lastNameTF.getText().trim().length() != 0 && firstNameTF.getText().trim().length() != 0 && patronymicNameTF.getText().trim().length() != 0
            && experienceTF.getText().trim().length()!= 0){

            teacher.setLast_name(lastNameTF.getText());
            teacher.setFirst_name(firstNameTF.getText());
            teacher.setPatronymic_name(patronymicNameTF.getText());
            teacher.setExperience(Integer.parseInt(experienceTF.getText()));

            Stage stage = (Stage)lastNameTF.getScene().getWindow();
            stage.close();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Ошибка при попытке добавить нового учителя");
            alert.setContentText("Вы не ввели данные!");
            alert.showAndWait();
        }
    }

    public void back(){
        Stage stage = (Stage)lastNameTF.getScene().getWindow();
        stage.close();
    }
}
