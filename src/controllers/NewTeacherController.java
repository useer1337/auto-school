package controllers;

import javafx.fxml.FXML;
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
        teacher.setLast_name(lastNameTF.getText());
        teacher.setFirst_name(firstNameTF.getText());
        teacher.setPatronymic_name(patronymicNameTF.getText());
        teacher.setExperience(Integer.parseInt(experienceTF.getText()));

        Stage stage = (Stage)lastNameTF.getScene().getWindow();
        stage.close();
    }

    public void back(){
        Stage stage = (Stage)lastNameTF.getScene().getWindow();
        stage.close();
    }
}
