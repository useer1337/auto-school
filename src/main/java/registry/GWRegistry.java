package registry;

import gw.*;

public class GWRegistry {
    private RoomGetWay roomGetWay = new RoomGetWay();
    private TransmissionGetWay transmissionGetWay = new TransmissionGetWay();
    private CategoryGetWay categoryGetWay = new CategoryGetWay();
    private TeacherGetWay teacherGetWay = new TeacherGetWay();
    private LearnGW learnGW = new LearnGW();
    private SimulatorProgramGetWay simulatorProgramGetWay = null;
    private LearnTypeGetWay learnTypeGetWay = new LearnTypeGetWay();


    public  LearnGW getLearnGW() {
        return learnGW;
    }

    public RoomGetWay getRoomGetWay() {
        return roomGetWay;
    }

    public TransmissionGetWay getTransmissionGetWay() {
        return transmissionGetWay;
    }

    public CategoryGetWay getCategoryGetWay() {
        return categoryGetWay;
    }

    public TeacherGetWay getTeacherGetWay() {
        return teacherGetWay;
    }

    public LearnTypeGetWay getLearnTypeGetWay() {
        return learnTypeGetWay;
    }

    public SimulatorProgramGetWay getSimulatorProgramGetWay() {
        if (simulatorProgramGetWay == null)
            simulatorProgramGetWay = new SimulatorProgramGetWay();
        return simulatorProgramGetWay;
    }

    private GWRegistry() {};

    private static GWRegistry instance = new GWRegistry();

    public static GWRegistry getInstance(){
        return instance;
    }
}
