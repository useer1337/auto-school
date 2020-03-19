package gw;

import models.simulatorProgram.Transmission;

public class TransmissionGetWay extends SimpleGetWay<Transmission>{
    public TransmissionGetWay(){
        insert(new Transmission("Механическая"));
        insert(new Transmission("Автомат"));
    }
}
