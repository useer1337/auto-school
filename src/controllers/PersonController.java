package controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.learnTime.Learn;
import models.man.Student;


public class PersonController {
    @FXML
    private TextField firstNameTF;

    @FXML
    private TextField lastNameTF;

    @FXML
    private TextField patronymicNameTF;

    @FXML
    private TextField ageTF;

    private Learn learn;

    public void findLearn(Learn learn) {
        this.learn = learn;
    }


    public void Next() throws Exception {
        Student student = new Student();

        student.setFirst_name(firstNameTF.getText());
        student.setLast_name(lastNameTF.getText());
        student.setPatronymic_name(patronymicNameTF.getText());
        student.setAge(Integer.parseInt(ageTF.getText()));

        learn.setStudent(student);

        roomTeacherAndSimProg(learn);
    }

    public void roomTeacherAndSimProg(Learn learn) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/simprog.fxml"));
        VBox page = (VBox) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Выбор программы обучения");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        SimprogController simprogController = loader.getController();
        simprogController.findLearn(learn);

        /**
         * как создать и закрыть предидущее.
         */
        dialogStage.show();
        Stage curStage = (Stage) lastNameTF.getScene().getWindow();
        curStage.close();
    }
}
