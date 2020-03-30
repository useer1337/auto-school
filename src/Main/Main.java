package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.net.URL;

public class Main extends Application {

    private Stage dialogStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        URL u1 = new URL("file:///D:/JavaFxAutoSchool/src/views/mainForm.fxml");
        loader.setLocation(u1);
        VBox page = (VBox) loader.load();
        dialogStage = new Stage();
        dialogStage.setTitle("Запись на обучение");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        dialogStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}