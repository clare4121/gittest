package com.cyp.gitnewmodulewhole.threadstudy;


public class EnergySytemTest {
    public static final double INITAL_ENERGY=1000;
    public static  final int BOX_AMOUNT=100;

    public static void main(String[] args) {
        EnergySystem eng = new EnergySystem(BOX_AMOUNT,INITAL_ENERGY);
        for (int i = 0; i <BOX_AMOUNT ; i++) {
            EnergyTransferTask energyTransferTask =new EnergyTransferTask(eng,i,INITAL_ENERGY);
            Thread thread= new Thread(energyTransferTask,"TransferThread_"+i);
            thread.start();

        }
    }
}
