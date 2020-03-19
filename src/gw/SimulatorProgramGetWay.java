package gw;

import exceptions.EntityNotFound;
import models.simulatorProgram.Category;
import models.simulatorProgram.SimulatorProgram;
import models.simulatorProgram.Transmission;
import registry.GWRegistry;

import java.util.ArrayList;
import java.util.List;

public class SimulatorProgramGetWay extends SimpleGetWay<SimulatorProgram>{

    public SimulatorProgramGetWay(){
        CategoryGetWay categoryGetWay = GWRegistry.getInstance().getCategoryGetWay();
        TransmissionGetWay transmissionGetWay = GWRegistry.getInstance().getTransmissionGetWay();
        try {
            insert(new SimulatorProgram(categoryGetWay.find(1), transmissionGetWay.find(1)));
            insert(new SimulatorProgram(categoryGetWay.find(1), transmissionGetWay.find(2)));

            insert(new SimulatorProgram(categoryGetWay.find(2), transmissionGetWay.find(1)));
            insert(new SimulatorProgram(categoryGetWay.find(2), transmissionGetWay.find(2)));

            insert(new SimulatorProgram(categoryGetWay.find(3), transmissionGetWay.find(1)));
            insert(new SimulatorProgram(categoryGetWay.find(3), transmissionGetWay.find(2)));

            insert(new SimulatorProgram(categoryGetWay.find(4), transmissionGetWay.find(1)));
            insert(new SimulatorProgram(categoryGetWay.find(4), transmissionGetWay.find(2)));

            insert(new SimulatorProgram(categoryGetWay.find(5), transmissionGetWay.find(1)));
            insert(new SimulatorProgram(categoryGetWay.find(5), transmissionGetWay.find(2)));

            insert(new SimulatorProgram(categoryGetWay.find(6), transmissionGetWay.find(1)));
            insert(new SimulatorProgram(categoryGetWay.find(6), transmissionGetWay.find(2)));

            insert(new SimulatorProgram(categoryGetWay.find(7), transmissionGetWay.find(1)));
            insert(new SimulatorProgram(categoryGetWay.find(7), transmissionGetWay.find(2)));

        }
        catch (EntityNotFound e){

        }

    };

    public SimulatorProgram findSimulatorProgramm(Category category, Transmission transmission) throws EntityNotFound{
        SimulatorProgramGetWay simulatorProgramGetWay = new SimulatorProgramGetWay();
        ArrayList<SimulatorProgram> simulatorProgramList = new ArrayList<>(simulatorProgramGetWay.all());
        for(int i = 0;i<simulatorProgramList.size();i++){
            if(simulatorProgramList.get(i).getCategory() == category &&
                    simulatorProgramList.get(i).getTransmission() == transmission){
                return simulatorProgramList.get(i);
            }
        }
        throw new EntityNotFound("Программа не найдена");
    }
}
