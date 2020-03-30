package controllers;

import Formatters.FirstFormatter;
import exceptions.EntityNotFound;
import gw.LearnGW;
import gw.LearnTypeGetWay;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.learnTime.Learn;
import models.learnTime.LearnType;
import registry.GWRegistry;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class TypeAndTimeController {
    @FXML
    ComboBox<LearnType> learnTypeComboBox;

    @FXML
    DatePicker datePicker;

    private Learn learn;

    private LearnTypeGetWay learnTypeGetWay = GWRegistry.getInstance().getLearnTypeGetWay();
    private LearnGW learnGW = GWRegistry.getInstance().getLearnGW();

    @FXML
    public void initialize(){
        learnTypeComboBox.setItems(FXCollections.observableArrayList(learnTypeGetWay.all()));
    }

    public void findLearn(Learn learn){
        this.learn = learn;
    }

    public void add() throws EntityNotFound {
        learn.setLearnType(learnTypeComboBox.getSelectionModel().getSelectedItem());
        learn.setStart(datePicker.getValue());

        learnGW.insert(learn);

        Stage stage = (Stage)learnTypeComboBox.getScene().getWindow();
        stage.close();
    }
}
