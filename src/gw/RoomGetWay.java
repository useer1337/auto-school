package gw;

import models.room.Room;

public class RoomGetWay extends SimpleGetWay<Room> {
    public RoomGetWay(){
        insert(new Room("пл. им. В.И, ул. Ленина, 1, Курган, Курганская обл., 640002"));
        insert(new Room("ул. Гоголя, 61, 1 Кабинет, Курган, 640000"));
        insert(new Room("ул. Гоголя, 16, Курган, Курганская обл., 640020"));
    }
}
