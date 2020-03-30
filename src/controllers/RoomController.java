package controllers;

import gw.RoomGetWay;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.room.Room;
import registry.GWRegistry;

import java.io.IOException;

public class RoomController {

    @FXML
    TableView<Room> roomTableView;

    @FXML
    TableColumn<Room, String> roomStringTableColumn;

    private RoomGetWay roomGetWay = GWRegistry.getInstance().getRoomGetWay();

    ObservableList<Room> roomObservableList = FXCollections.observableArrayList(roomGetWay.all());

    @FXML
    public void initialize(){
        roomStringTableColumn.setCellValueFactory(cell->cell.getValue().addressProperty());
        roomTableView.setItems(roomObservableList);
    }

    public void delRoom(){
        Room curRoom = roomTableView.getSelectionModel().getSelectedItem();
        if(curRoom != null){
            roomGetWay.delete(curRoom.getId());
            roomObservableList.remove(curRoom);
        }
    }

    public void newRoom() throws IOException {
        Room room = new Room();
        addRoom(room);
        if(room != null){
            roomGetWay.insert(room);
            roomObservableList.add(room);
        }
    }

    public void addRoom(Room room) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/newroom.fxml"));
        VBox page = (VBox) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Добавить помещение");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        NewRoomController newRoomController = loader.getController();
        newRoomController.setRoom(room);

        dialogStage.show();
    }

}
