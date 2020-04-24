package FillDB;

import exceptions.EntityNotFound;
import gw.*;
import models.learnTime.LearnType;
import models.man.Teacher;
import models.room.Room;
import models.simulatorProgram.Category;
import models.simulatorProgram.SimulatorProgram;
import models.simulatorProgram.Transmission;
import registry.GWRegistry;

public class FillDB {
    public static void main(String[] args) throws EntityNotFound {

        //fill rooms
        RoomGetWay roomGetWay = GWRegistry.getInstance().getRoomGetWay();
        roomGetWay.insert(new Room("пл. им. В.И, ул. Ленина, 1, Курган, Курганская обл., 640002"));
        roomGetWay.insert(new Room("ул. Гоголя, 61, 1 Кабинет, Курган, 640000"));
        roomGetWay.insert(new Room("ул. Гоголя, 16, Курган, Курганская обл., 640020"));

        //fill categories
        CategoryGetWay categoryGetWay = GWRegistry.getInstance().getCategoryGetWay();
        categoryGetWay.insert(new Category("А – позволяет управлять обычными мотоциклами"));
        categoryGetWay.insert(new Category("В – на легковые машины, весом до 3,5 тонн"));
        categoryGetWay.insert(new Category("В1 – трициклы и квадрициклы"));
        categoryGetWay.insert(new Category("С – разрешение на грузовой транспорт"));
        categoryGetWay.insert(new Category("D – автомобили, приспособленные для перевозки более 8 человек, микроавтобусы"));
        categoryGetWay.insert(new Category("М – мопеды и легкие квадрициклы"));
        categoryGetWay.insert(new Category("Tm – трамваи"));

        //fill learn types
        LearnTypeGetWay learnTypeGetWay = GWRegistry.getInstance().getLearnTypeGetWay();
        learnTypeGetWay.insert(new LearnType("Обычное (3 месяца)"));
        learnTypeGetWay.insert(new LearnType("Обычное (1,5 месяца)"));

        //fill transmissions
        TransmissionGetWay transmissionGetWay = GWRegistry.getInstance().getTransmissionGetWay();
        transmissionGetWay.insert(new Transmission("Механическая"));
        transmissionGetWay.insert(new Transmission("Автомат"));

        //fill simulator programs
        SimulatorProgramGetWay simulatorProgramGetWay = GWRegistry.getInstance().getSimulatorProgramGetWay();
        simulatorProgramGetWay.insert(new SimulatorProgram(categoryGetWay.find(1), transmissionGetWay.find(1)));
        simulatorProgramGetWay.insert(new SimulatorProgram(categoryGetWay.find(1), transmissionGetWay.find(2)));

        simulatorProgramGetWay.insert(new SimulatorProgram(categoryGetWay.find(2), transmissionGetWay.find(1)));
        simulatorProgramGetWay.insert(new SimulatorProgram(categoryGetWay.find(2), transmissionGetWay.find(2)));

        simulatorProgramGetWay.insert(new SimulatorProgram(categoryGetWay.find(3), transmissionGetWay.find(1)));
        simulatorProgramGetWay.insert(new SimulatorProgram(categoryGetWay.find(3), transmissionGetWay.find(2)));

        simulatorProgramGetWay.insert(new SimulatorProgram(categoryGetWay.find(4), transmissionGetWay.find(1)));
        simulatorProgramGetWay.insert(new SimulatorProgram(categoryGetWay.find(4), transmissionGetWay.find(2)));

        simulatorProgramGetWay.insert(new SimulatorProgram(categoryGetWay.find(5), transmissionGetWay.find(1)));
        simulatorProgramGetWay.insert(new SimulatorProgram(categoryGetWay.find(5), transmissionGetWay.find(2)));

        simulatorProgramGetWay.insert(new SimulatorProgram(categoryGetWay.find(6), transmissionGetWay.find(1)));
        simulatorProgramGetWay.insert(new SimulatorProgram(categoryGetWay.find(6), transmissionGetWay.find(2)));

        simulatorProgramGetWay.insert(new SimulatorProgram(categoryGetWay.find(7), transmissionGetWay.find(1)));
        simulatorProgramGetWay.insert(new SimulatorProgram(categoryGetWay.find(7), transmissionGetWay.find(2)));

        //fill teachers
        TeacherGetWay teacherGetWay = GWRegistry.getInstance().getTeacherGetWay();
        teacherGetWay.insert(new Teacher("Владимир", "Чагин","Геннадиевич", 20));
        teacherGetWay.insert(new Teacher("Фирдаус", "Кабиров","Зарипович", 28));
        teacherGetWay.insert(new Teacher("Виталий", "Петров","Александрович", 10));
        teacherGetWay.insert(new Teacher("Борис", "Гадасин","Сергеевич", 21));
    }
}
