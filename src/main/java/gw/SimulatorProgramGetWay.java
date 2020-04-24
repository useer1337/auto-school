package gw;

import exceptions.EntityNotFound;
import models.simulatorProgram.Category;
import models.simulatorProgram.SimulatorProgram;
import models.simulatorProgram.Transmission;

import java.util.ArrayList;

public class SimulatorProgramGetWay extends SimpleGetWay<SimulatorProgram>{
    public SimulatorProgram findSimulatorProgramm(Category category, Transmission transmission) throws EntityNotFound{
        SimulatorProgramGetWay simulatorProgramGetWay = new SimulatorProgramGetWay();
        ArrayList<SimulatorProgram> simulatorProgramList = new ArrayList<>(simulatorProgramGetWay.all());
        for(int i = 0;i<simulatorProgramList.size();i++){
            if(simulatorProgramList.get(i).getCategory().getCategory_type().equals(category.getCategory_type())&&
                    simulatorProgramList.get(i).getTransmission().getTransmission_type().equals(transmission.getTransmission_type())){
                return simulatorProgramList.get(i);
            }
        }
        throw new EntityNotFound("Программа не найдена");
    }
}
