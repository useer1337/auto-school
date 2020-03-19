package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.learnTime.Learn;

public class LookController {
    @FXML
    TextField lastNameTF;

    @FXML
    TextField firstNameTF;

    @FXML
    TextField patronymicNameTF;

    @FXML
    TextField learnTypeTF;

    @FXML
    TextField teacherTF;

    @FXML
    TextField roomTF;

    @FXML
    TextField categoryTF;

    @FXML
    TextField transmissionTF;

    @FXML
    TextField periodTF;

    private Learn learn;

    public void setLearn(Learn learn) {
        this.learn = learn;
        lastNameTF.setText(learn.getStudent().getLast_name());
        firstNameTF.setText(learn.getStudent().getFirst_name());
        patronymicNameTF.setText(learn.getStudent().getPatronymic_name());
        learnTypeTF.setText(learn.getLearnType().getName());
        teacherTF.setText(learn.getTeacher().getFirst_name() + " " + learn.getTeacher().getLast_name() + " " + learn.getTeacher().getPatronymic_name());
        roomTF.setText(learn.getRoom().getAddress());
        categoryTF.setText(learn.getSimulatorProgram().getCategory().getCategory_type());
        transmissionTF.setText(learn.getSimulatorProgram().getTransmission().getTransmission_type());
        periodTF.setText(learn.getStart() + " " + "Здесь будет что-то еще интересное(например дата конца в зависимости от типа оьучения)");
    }


}
