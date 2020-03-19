package gw;

import models.man.Teacher;

public class TeacherGetWay extends  SimpleGetWay<Teacher> {
    public TeacherGetWay(){
        insert(new Teacher("Владимир", "Чагин","Геннадиевич", 20));
        insert(new Teacher("Фирдаус", "Кабиров","Зарипович", 28));
        insert(new Teacher("Виталий", "Петров","Александрович", 10));
        insert(new Teacher("Борис", "Гадасин","Сергеевич", 21));
    }

}
