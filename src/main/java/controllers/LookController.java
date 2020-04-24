package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.learnTime.Learn;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

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
        periodTF.setText("C " + learn.getStart().toString() + " по " + addDate());
    }


    public String addDate(){
        ZoneId defaultZoneId = ZoneId.systemDefault();

        Date date = Date.from(learn.getStart().atStartOfDay(defaultZoneId).toInstant());

        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        if(learn.getLearnType().getName() == "Обычное (3 месяца)"){
            instance.add(Calendar.MONTH,3);
        }
        else{
            instance.add(Calendar.MONTH,3);
            instance.add(Calendar.DAY_OF_MONTH,15);
        }

        Date newDate = instance.getTime();

        return newDate.toInstant().atZone(defaultZoneId).toLocalDate().toString();
    }
}
