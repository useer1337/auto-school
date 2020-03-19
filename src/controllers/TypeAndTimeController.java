package controllers;

import exceptions.EntityNotFound;
import gw.LearnGW;
import gw.LearnTypeGetWay;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.learnTime.Learn;
import models.learnTime.LearnType;
import registry.GWRegistry;

public class TypeAndTimeController {
    @FXML
    ComboBox<LearnType> learnTypeComboBox;

    @FXML
    TextField timeTF;

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
        learn.setStart(timeTF.getText());

        learnGW.insert(learn);

        Stage stage = (Stage)timeTF.getScene().getWindow();
        stage.close();
    }
}
