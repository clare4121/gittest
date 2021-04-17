package com.cyp.gitnewmodulewhole.threadstudy;

public class EnergySystem {
   private final double[] energyBoxes;
   public EnergySystem(int n,double initalEnergy){
       energyBoxes= new double[n];
       for (int i = 0; i <energyBoxes.length ; i++) {
           energyBoxes[i]=initalEnergy;
       }
   }

   public void transfer(int from ,int to,double amount){
       if(energyBoxes[from]<amount)
           return;
       System.out.println(Thread.currentThread().getName());
       energyBoxes[from]=energyBoxes[from]-amount;
       System.out.printf("从%d转移%10.2f单位能量到%d",from,amount,to);

       energyBoxes[to]=energyBoxes[to]+amount;
       System.out.printf("能量总和： %10.2f%n",getTotalEnergies());

   }
   public double getTotalEnergies(){

       double sum =0;
       for (double amount:energyBoxes)
           sum=sum+amount;
       return  sum;
   }
   public int getBoxAmount(){
       return energyBoxes.length;
   }

}
